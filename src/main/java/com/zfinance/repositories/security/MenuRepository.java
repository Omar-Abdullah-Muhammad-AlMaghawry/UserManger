package com.zfinance.repositories.security;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.zfinance.orm.security.Menu;

public interface MenuRepository extends CassandraRepository<Menu, Long> {

}
