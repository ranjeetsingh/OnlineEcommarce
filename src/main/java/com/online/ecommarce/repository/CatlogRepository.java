package com.online.ecommarce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.ecommarce.entity.Catlog;

/**
 * Catlog Repository for Catlog table.
 * @author RanjeetSi
 *
 */
@Repository
public interface CatlogRepository extends JpaRepository<Catlog, Long> {

}
