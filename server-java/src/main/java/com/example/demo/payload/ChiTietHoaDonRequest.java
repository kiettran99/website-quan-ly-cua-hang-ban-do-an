package com.example.demo.payload;

import java.util.List;

public class ChiTietHoaDonRequest {
	public List<Object> orderdetail;
	public Long ban_stt;
	public double total;

	public List<Object> getOrderdetail() {
		return orderdetail;
	}

	public void setOrderdetail(List<Object> list) {
		this.orderdetail = list;
	}

	public Long getBan_stt() {
		return ban_stt;
	}

	public void setBan_stt(Long ban_stt) {
		this.ban_stt = ban_stt;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
