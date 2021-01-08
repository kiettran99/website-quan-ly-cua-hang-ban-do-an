package com.hns2t.QuanLyQuanNhau_server.model;
import org.springframework.security.core.GrantedAuthority;
public enum PhanQuyen implements GrantedAuthority {
	Admin, Nguoidung;
	public String getAuthority() {
	    return name();
	  }

}
