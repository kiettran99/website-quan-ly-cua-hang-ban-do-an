package com.hns2t.QuanLyQuanNhau_server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hns2t.QuanLyQuanNhau_server.model.MonAn;

@Repository
public interface MonAnRepository extends JpaRepository<MonAn, Long> {

}
