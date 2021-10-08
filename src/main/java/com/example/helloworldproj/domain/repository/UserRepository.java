package com.example.helloworldproj.domain.repository;

import com.example.helloworldproj.domain.model.UserEntity;
import io.crnk.core.repository.ResourceRepository;

public interface UserRepository extends ResourceRepository<UserEntity, String> {

}
