package com.hns2t.QuanLyQuanNhau_server.payload;

import org.springframework.web.multipart.MultipartFile;

public class MonAnRequest {

	public String getMa_ten() {
		return ma_ten;
	}

	public void setMa_ten(String ma_ten) {
		this.ma_ten = ma_ten;
	}

	public Double getMa_giavon() {
		return ma_giavon;
	}

	public void setMa_giavon(Double ma_giavon) {
		this.ma_giavon = ma_giavon;
	}

	public Double getMa_giaban() {
		return ma_giaban;
	}

	public void setMa_giaban(Double ma_giaban) {
		this.ma_giaban = ma_giaban;
	}

	public String getMa_donvitinh() {
		return ma_donvitinh;
	}

	public void setMa_donvitinh(String ma_donvitinh) {
		this.ma_donvitinh = ma_donvitinh;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getMa_motachitiet() {
		return ma_motachitiet;
	}

	public void setMa_motachitiet(String ma_motachitiet) {
		this.ma_motachitiet = ma_motachitiet;
	}
	
	private String ma_ten;
	
	private Double ma_giavon;
	
	private Double ma_giaban;
	
	private String ma_donvitinh;
	
	private MultipartFile image;

	private String ma_motachitiet;
}
