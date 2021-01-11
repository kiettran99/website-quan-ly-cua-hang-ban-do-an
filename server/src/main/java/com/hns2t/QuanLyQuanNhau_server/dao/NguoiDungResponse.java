package com.hns2t.QuanLyQuanNhau_server.dao;

import java.util.List;

import com.hns2t.QuanLyQuanNhau_server.model.PhanQuyen;

import io.swagger.annotations.ApiModelProperty;

public class NguoiDungResponse {
	@ApiModelProperty(position = 0)
	  private Integer id;
	  @ApiModelProperty(position = 1)
	  private String username;
	  @ApiModelProperty(position = 2)
	  private String email;
	  @ApiModelProperty(position = 3)
	  List<PhanQuyen> roles;

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

	  public List<PhanQuyen> getRoles() {
	    return roles;
	  }

	  public void setRoles(List<PhanQuyen> roles) {
	    this.roles = roles;
	  }
}
