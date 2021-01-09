package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "cthd")
public class ChiTietHoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cthd_id;

	@Column(name = "gia")
	private Double cthd_gia;

	@Column(name = "soluong")
	private Integer cthd_soluong;

	@ManyToOne
	@JoinColumn(name = "cthd_hdid")
	@JsonBackReference
	private HoaDon hoaDon;

	@ManyToOne
	@JoinColumn(name = "cthd_monanid")
	@JsonBackReference
	private MonAn monAn;

	public ChiTietHoaDon() {
		super();
	}

	public Long getCthd_id() {
		return cthd_id;
	}

	public void setCthd_id(Long cthd_id) {
		this.cthd_id = cthd_id;
	}

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

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public MonAn getMonAn() {
		return monAn;
	}

	public void setMonAn(MonAn monAn) {
		this.monAn = monAn;
	}

}
