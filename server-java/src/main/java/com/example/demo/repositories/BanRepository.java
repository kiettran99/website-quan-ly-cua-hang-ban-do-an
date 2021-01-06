package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Ban;

@Repository
public interface BanRepository extends JpaRepository<Ban, Long> {

}
