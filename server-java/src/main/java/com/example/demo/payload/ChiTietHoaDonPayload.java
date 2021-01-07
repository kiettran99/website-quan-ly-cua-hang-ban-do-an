package com.example.demo.payload;

import java.util.Map;

public class ChiTietHoaDonPayload {
	private Double cthd_gia;
	private Integer cthd_soluong;
	private Long monAn;

	public Double getCthd_gia() {
		return cthd_gia;
	}

	public void setCthd_gia(Double cthd_gia) {
		this.cthd_gia = cthd_gia;
	}

	public Integer getCthd_soluong() {
		return cthd_soluong;
	}

	public void setCthd_soluong(Integer cthd_soluong) {
		this.cthd_soluong = cthd_soluong;
	}

	public Long getMonAn() {
		return monAn;
	}

	public void setMonAn(Long monAn) {
		this.monAn = monAn;
	}

	public ChiTietHoaDonPayload() {
	}

	public ChiTietHoaDonPayload(Object coppy) {
		Map<String, Object> user = (Map<String, Object>) coppy;

		this.monAn = Long.parseLong(user.get("monAn").toString());
		this.cthd_soluong = (Integer) user.get("cthd_soluong");
		this.cthd_gia = Double.parseDouble( user.get("cthd_gia").toString());
	}
}
