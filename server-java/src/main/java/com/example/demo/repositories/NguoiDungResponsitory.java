package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.NguoiDung;


public interface NguoiDungResponsitory extends JpaRepository<NguoiDung, Integer> {

	  boolean existsByUsername(String username);

	  NguoiDung findByUsername(String username);

	  @Transactional
	  void deleteByUsername(String username);

	}
