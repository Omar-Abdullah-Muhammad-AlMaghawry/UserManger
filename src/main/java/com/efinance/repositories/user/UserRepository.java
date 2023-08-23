package com.efinance.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efinance.orm.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
