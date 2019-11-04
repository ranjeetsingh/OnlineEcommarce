package com.online.ecommarce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.ecommarce.entity.User;

/**
 * User Repository for user table.
 * @author RanjeetSi
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
