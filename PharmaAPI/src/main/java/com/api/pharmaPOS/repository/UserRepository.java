package com.api.pharmaPOS.repository;

import org.springframework.data.repository.CrudRepository;
import com.api.pharmaPOS.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
