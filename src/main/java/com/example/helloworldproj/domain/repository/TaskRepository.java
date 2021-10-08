package com.example.helloworldproj.domain.repository;

import com.example.helloworldproj.domain.model.Task;
import io.crnk.core.repository.ResourceRepository;

public interface TaskRepository extends ResourceRepository<Task, Long> {

}
