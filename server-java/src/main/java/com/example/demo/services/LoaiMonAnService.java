package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.LoaiMonAn;
import com.example.demo.repositories.LoaiMonAnRepository;

@Service
@Transactional
public class LoaiMonAnService {

	@Autowired
	private LoaiMonAnRepository repo;

	public List<LoaiMonAn> listAll() {
		return repo.findAll();

	}

	public LoaiMonAn save(LoaiMonAn loaiMonAn) {
		return repo.save(loaiMonAn);
	}

	public void delete(long id) {
		repo.deleteById(id);
	}

}
