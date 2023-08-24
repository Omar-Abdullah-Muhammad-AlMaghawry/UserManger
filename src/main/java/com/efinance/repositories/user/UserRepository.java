package com.efinance.repositories.user;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.efinance.orm.user.User;

public interface UserRepository extends CassandraRepository<User, String> {

}
