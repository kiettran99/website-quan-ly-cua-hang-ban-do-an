package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.NguoiDung;
import com.example.demo.payload.LoginRequest;

import com.example.demo.services.NguoiDungService;

@RestController
@RequestMapping(value = "/api/v1/users")
public class NguoiDungController {

	@Autowired
	private NguoiDungService userService;


	@PostMapping("/signin")
	public NguoiDung login(@RequestBody LoginRequest login) {
		return userService.login(login.getUsername(), login.getPassword());
	}

	@PostMapping("/signup")
	public String signup(@RequestBody NguoiDung user) {
		return userService.signup(user);
	}

}
