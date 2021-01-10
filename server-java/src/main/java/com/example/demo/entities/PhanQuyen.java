package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "phanquyen")
public class PhanQuyen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-Increment
	private Long QuyenId;

	private String role;

	@ManyToOne()
	@JoinColumn(name = "userId", nullable = false)
	@JsonBackReference
	private NguoiDung user;

	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public NguoiDung getUser() {
		return user;
	}

	public void setUser(NguoiDung user) {
		this.user = user;
	}
}
