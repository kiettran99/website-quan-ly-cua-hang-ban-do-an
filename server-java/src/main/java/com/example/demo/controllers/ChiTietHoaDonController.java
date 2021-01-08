package com.example.demo.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.ChiTietHoaDon;
import com.example.demo.services.ChiTietHoaDonService;

@RestController
@RequestMapping("/api/v1/chitiethoadons")
public class ChiTietHoaDonController {
	@Autowired
	ChiTietHoaDonService service;
	
	@GetMapping("")
	public Collection<ChiTietHoaDon> getList() {
		return service.repo.findAll();
	}
	
	@GetMapping("/hoadon/{idHoaDon}")
	public Collection<ChiTietHoaDon> getListByHoaDon(@PathVariable Long idHoaDon) {
		return service.getChiTietHoaDonTheoHD(idHoaDon);
	}
}
