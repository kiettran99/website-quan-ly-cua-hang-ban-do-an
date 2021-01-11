package com.example.demo.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.entities.NguoiDung;
import com.example.demo.exception.CustomException;
import com.example.demo.repositories.NguoiDungResponsitory;

@Service
public class NguoiDungService {

	@Autowired
	private NguoiDungResponsitory userRepository;
	

	public NguoiDung login(String username, String password) {

		NguoiDung nguoiDung = userRepository.findByUsername(username);

		if (nguoiDung != null) {
			if (nguoiDung.getPassword().equals(password)) {
				return nguoiDung;
			}
		}

		return new NguoiDung();
	}

	public String signup(NguoiDung user) {
		NguoiDung nguoiDung = userRepository.findByUsername(user.getUsername());
		
		if (nguoiDung != null) {
			return "User is existed";
		}
		
		userRepository.save(nguoiDung);
		
		return "User is created";
	}

	public void delete(String username) {
		userRepository.deleteByUsername(username);
	}

	public List<NguoiDung> getAllUsers() {
		return userRepository.findAll();
	}

	public NguoiDung search(String username) {
		NguoiDung user = userRepository.findByUsername(username);
		if (user == null) {
			throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
		}
		return user;
	}
}
