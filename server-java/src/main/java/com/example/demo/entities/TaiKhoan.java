package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "taikhoan")
public class TaiKhoan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tk_id;
	private String tk_user;
	private Double tk_password;
	//private PhanQuyen tk_phanquyen;
	
	@OneToOne(mappedBy = "taiKhoan")
	private NhanVien tk_nhanVien;
	
	public TaiKhoan() {
		super();
	}
	
	
}
