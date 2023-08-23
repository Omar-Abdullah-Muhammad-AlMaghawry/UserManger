package com.efinance.repositories.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efinance.orm.security.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}
