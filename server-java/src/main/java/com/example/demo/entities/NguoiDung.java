package com.example.demo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class NguoiDung {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(unique = true, nullable = false)
	private String username;
	@Column(unique = true, nullable = false)
	private String email;

	private String password;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@JsonManagedReference
	@JsonIgnoreProperties("user")
	List<PhanQuyen> roles;

	public List<PhanQuyen> getRoles() {
		return roles;
	}

	public void setRoles(List<PhanQuyen> roles) {
		this.roles = roles;
	}
}
