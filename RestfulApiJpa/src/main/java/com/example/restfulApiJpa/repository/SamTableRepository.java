package com.example.restfulApiJpa.repository;

import com.example.restfulApiJpa.entity.SamTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SamTableRepository extends JpaRepository<SamTable, Integer> {
}
