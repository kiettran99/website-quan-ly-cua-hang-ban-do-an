package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.MonAn;

@Repository
public interface MonAnRepository extends JpaRepository<MonAn, Long> {

}
