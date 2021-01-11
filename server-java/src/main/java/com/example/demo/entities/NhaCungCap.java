package com.example.demo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nhacungcap")
public class NhaCungCap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ncc_id; 
	@Column(name = "ten")
	private String ncc_ten;
	@Column(name = "sodienthoai")
	private String ncc_sdt;
	@Column(name = "email")
	private String ncc_email;
	@Column(name = "tongmua")
	private Double ncc_tongmua;
	
	@OneToMany(mappedBy = "nhaCungCap")
	private List<NguyenLieu> nguyenLieus;
	
	public NhaCungCap() {
		super();
	}
	
	
}
