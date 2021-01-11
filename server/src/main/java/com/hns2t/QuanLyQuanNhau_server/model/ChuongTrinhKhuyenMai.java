package com.hns2t.QuanLyQuanNhau_server.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ctkm")
public class ChuongTrinhKhuyenMai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ctkm_id;
	
	@Column(name = "ten")
	private String ctkm_ten;
	
	@Column(name = "discount")
	private Double ctkm_discount;
	
	@Column(name = "ngaybatdau")
	private Date ctkm_ngaybatdau;
	
	@Column(name = "ngayketthuc")
	private Date ctkm_ngayketthuc;
	
	@Column(name = " dieukien")
	private String ctkm_dieukien;
	
	@OneToMany(mappedBy = "chuongTrinhKhuyenMai")
	private List<HoaDon> hoandons;

	public ChuongTrinhKhuyenMai() {
		super();
	}
	
	
}
