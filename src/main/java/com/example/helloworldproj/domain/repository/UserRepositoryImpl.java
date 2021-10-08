package com.example.helloworldproj.domain.repository;

import com.example.helloworldproj.domain.model.UserEntity;
import io.crnk.data.jpa.JpaEntityRepositoryBase;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl extends JpaEntityRepositoryBase<UserEntity, String> implements UserRepository {

    public UserRepositoryImpl() {
        super(UserEntity.class);
    }
}