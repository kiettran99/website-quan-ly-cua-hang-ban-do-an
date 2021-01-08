package com.hns2t.QuanLyQuanNhau_server.dao;

import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.hns2t.QuanLyQuanNhau_server.model.PhanQuyen;



public class NguoiDungData {
	@ApiModelProperty(position = 0)
	  private String username;
	  @ApiModelProperty(position = 1)
	  private String email;
	  @ApiModelProperty(position = 2)
	  private String password;
	  @ApiModelProperty(position = 3)
	  List<PhanQuyen> roles;

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

	  public List<PhanQuyen> getRoles() {
	    return roles;
	  }

	  public void setRoles(List<PhanQuyen> roles) {
	    this.roles = roles;
	  }
}
