package com.zfinance.repositories.security;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zfinance.orm.security.Menu;

public interface MenuRepository extends MongoRepository<Menu, Long> {

}
