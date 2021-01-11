package com.hns2t.QuanLyQuanNhau_server.Responsitory;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hns2t.QuanLyQuanNhau_server.model.NguoiDung;


public interface NguoiDungResponsitory extends JpaRepository<NguoiDung, Integer> {

	  boolean existsByUsername(String username);

	  NguoiDung findByUsername(String username);

	  @Transactional
	  void deleteByUsername(String username);

	}
