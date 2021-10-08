package com.example.helloworldproj.domain.repository;

import com.example.helloworldproj.domain.model.ScheduleEntity;
import io.crnk.data.jpa.JpaEntityRepositoryBase;
import org.springframework.stereotype.Component;

@Component
public class ScheduleRepositoryImpl extends JpaEntityRepositoryBase<ScheduleEntity, Long> {

    public ScheduleRepositoryImpl() {
        super(ScheduleEntity.class);
    }
}