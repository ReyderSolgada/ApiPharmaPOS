package com.api.pharmaPOS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.pharmaPOS.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
