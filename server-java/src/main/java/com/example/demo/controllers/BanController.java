package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Ban;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.BanRepository;

@RestController
@RequestMapping("/api/v1/bans")
public class BanController {

	@Autowired
	BanRepository repo;

	@GetMapping("")
	public List<Ban> getAll() {
		return repo.findAll();
	}

	@PostMapping("")
	public Ban create(@RequestBody Ban ban) {
		return repo.save(ban);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ban> getById(@PathVariable Long id) {
		Ban object = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Ban an khong ton tai with: " + id));
		return ResponseEntity.ok(object);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Ban> update(@PathVariable Long id, @RequestBody @Validated Ban ban) {
		Ban object = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Ban an khong ton tai with: " + id));

		if (ban.getB_soghe() != null) {
			object.setB_soghe(ban.getB_soghe());
		}
		
		if (ban.getB_stt() != null) {
			object.setB_stt(ban.getB_stt());
		}

		Ban banAn = repo.save(object);
		return ResponseEntity.ok(banAn);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
		Ban ban = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Ban an khong ton tai with: " + id));
		repo.delete(ban);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
