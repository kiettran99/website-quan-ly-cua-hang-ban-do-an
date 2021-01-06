package com.example.demo.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "nhanvien")
public class NhanVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long nv_id;
	private String nv_hoten;
	@Column(unique = true)
	
	private String nv_chungminhnhandan;
	@Column(name = "ngaysinh")
	private Date nv_ngaysinh;
	@Column(name = "diachi")
	private String nv_diachi;
	@Column(name = "sodienthoai")
	private String nv_sodienthoai;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "nv_lnvid")
	private LoaiNhanVien loaiNhanVien;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "nv_tkid")
	private TaiKhoan taiKhoan;
	
	@ManyToMany(mappedBy = "nhanviens")
	private List<Ban> bans;
	
	@OneToMany(mappedBy = "hd_nhanvien")
	private List<HoaDon> hoaDons;
	
	@OneToMany(mappedBy = "nhanvien")
	private List<PhieuXuat> phieuXuats;
	
	@OneToMany(mappedBy = "nhanvien")
	private List<PhieuNhap> phieuNhaps;
	
	public NhanVien() {
		super();
	}
	
	
	
}
