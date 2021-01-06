package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.LoaiMonAn;
import com.example.demo.entities.MonAn;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.LoaiMonAnRepository;

@RestController
@RequestMapping("/api/v1/loaimonans")
public class LoaiMonAnController {
//	@Autowired
//	private LoaiMonAnService service;
	@Autowired
	private LoaiMonAnRepository repo;
	
	@GetMapping("")
	public List<LoaiMonAn> getAll(){
		return repo.findAll();
	}
	
	@PostMapping("")
	public LoaiMonAn createLoaiMonAn(@RequestBody LoaiMonAn loaiMonAn) {
		return repo.save(loaiMonAn);
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<LoaiMonAn> getLoaiMonAn(@PathVariable Long id){
		LoaiMonAn object = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Loai mon an khong ton tai with: " + id));
		return ResponseEntity.ok(object);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LoaiMonAn> updateLoaiMonAn(@PathVariable Long id, @RequestBody LoaiMonAn loaiMonAnDetail){
		LoaiMonAn object =repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Loai mon an khong ton tai with: " + id));
		object.setLma_ten(loaiMonAnDetail.getLma_ten());
		LoaiMonAn updateLoaiMonAn = repo.save(object);
		return ResponseEntity.ok(updateLoaiMonAn);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteLoaiMonAn(@PathVariable Long id){
		LoaiMonAn loaiMonAn = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Loai mon an khong ton tai with: " + id));
		repo.delete(loaiMonAn);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}/monans")
	public ResponseEntity<List<MonAn>> getListMonAnOfLoaiMonAn(@PathVariable Long id){
		LoaiMonAn object = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Loai mon an khong ton tai with: " + id));
		List<MonAn> listMonAns = object.getMonans();
		System.out.println(listMonAns.toString());
		return ResponseEntity.ok(listMonAns);
		
	}
}








