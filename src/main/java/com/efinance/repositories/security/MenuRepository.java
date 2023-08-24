package com.efinance.repositories.security;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.efinance.orm.security.Menu;

public interface MenuRepository extends CassandraRepository<Menu, Long> {

}
