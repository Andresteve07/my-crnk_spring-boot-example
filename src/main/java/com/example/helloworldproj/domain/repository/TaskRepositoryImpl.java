package com.example.helloworldproj.domain.repository;

import com.example.helloworldproj.domain.model.Task;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.exception.ResourceNotFoundException;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.resource.list.ResourceList;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import io.crnk.core.repository.ResourceRepositoryBase;
// tag::doc[]
@Component
public class TaskRepositoryImpl extends ResourceRepositoryBase<Task, Long> implements TaskRepository {

	// for simplicity we make use of static, should not be used in real applications
	private static final Map<Long, Task> tasks = new ConcurrentHashMap<>();

	private static final AtomicLong ID_GENERATOR = new AtomicLong(4);

	public TaskRepositoryImpl() {
		super(Task.class);
	}

	@Override
	public <S extends Task> S save(S entity) {
		if (entity.getId() == null) {
			entity.setId(ID_GENERATOR.getAndIncrement());
		}
		tasks.put(entity.getId(), entity);
		return entity;
	}

	@Override
	public <S extends Task> S create(S entity) {
		if (entity.getId() != null && tasks.containsKey(entity.getId())) {
			throw new BadRequestException("Task already exists");
		}
		return save(entity);
	}

	@Override
	public Class<Task> getResourceClass() {
		return Task.class;
	}

	@Override
	public Task findOne(Long taskId, QuerySpec querySpec) {
		Task task = tasks.get(taskId);
		if (task == null) {
			throw new ResourceNotFoundException("Task not found!");
		}
		return task;
	}

	@Override
	public ResourceList<Task> findAll(QuerySpec querySpec) {
		return querySpec.apply(tasks.values());
	}


	@Override
	public void delete(Long taskId) {
		tasks.remove(taskId);
	}
}
// end::doc[]