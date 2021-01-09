package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.HoaDon;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.payload.ChiTietHoaDonPayload;
import com.example.demo.payload.ChiTietHoaDonRequest;
import com.example.demo.services.HoaDonService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
	@Autowired
	HoaDonService service;
	
	@GetMapping("")
	public List<HoaDon> getOrders() {
		return service.getOrders();
	}

	@GetMapping("/{id}")
	public HoaDon getOrderById(@PathVariable Long id) {
		return service.getOrderById(id);
	}

	@PostMapping("/checkout")
	public void checkoutOrder(@RequestBody Map<String, Object> payload) {
		ChiTietHoaDonRequest cthdRequest = new ChiTietHoaDonRequest();

		double total = (Integer) payload.get("total") * 1.0;
		Long ban_stt = Long.parseLong(payload.get("ban_stt").toString());

		cthdRequest.setTotal(total);
		cthdRequest.setBan_stt(ban_stt);
		cthdRequest.setOrderdetail((List<Object>) payload.get("orderdetail"));

		service.checkout(cthdRequest);
	}
}
