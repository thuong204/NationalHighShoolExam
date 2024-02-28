package model;

import java.sql.Date;
import java.util.ArrayList;

public class ThiSinh {
	private String MaThiSinh, TenThiSinh, Lop,Truong;
	private Tinh queQuan;
	private String ngaySinh;
	private String tinh;
	private int GioiTinh;
	public ThiSinh() {
	}
	
	
	public ThiSinh(String maThiSinh, String tenThiSinh, String lop, String truong, String ngaySinh, String tinh,
			int gioiTinh) {
		super();
		MaThiSinh = maThiSinh;
		TenThiSinh = tenThiSinh;
		Lop = lop;
		Truong = truong;
		this.ngaySinh = ngaySinh;
		this.tinh = tinh;
		GioiTinh = gioiTinh;
	}


	public ThiSinh(String maThiSinh, String tenThiSinh, String lop, String truong, Tinh queQuan, String ngaySinh,
			int gioiTinh) {
		super();
		MaThiSinh = maThiSinh;
		TenThiSinh = tenThiSinh;
		Lop = lop;
		Truong = truong;
		this.queQuan = queQuan;
		this.ngaySinh = ngaySinh;
		GioiTinh = gioiTinh;
	}
	public String getMaThiSinh() {
		return MaThiSinh;
	}
	public void setMaThiSinh(String maThiSinh) {
		MaThiSinh = maThiSinh;
	}
	public String getTenThiSinh() {
		return TenThiSinh;
	}
	public void setTenThiSinh(String tenThiSinh) {
		TenThiSinh = tenThiSinh;
	}
	public String getLop() {
		return Lop;
	}
	public void setLop(String lop) {
		Lop = lop;
	}
	public String getTruong() {
		return Truong;
	}
	public void setTruong(String truong) {
		Truong = truong;
	}
	public Tinh getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(Tinh queQuan) {
		this.queQuan = queQuan;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public int getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		GioiTinh = gioiTinh;
	}


	public String getTinh() {
		return tinh;
	}


	public void setTinh(String tinh) {
		this.tinh = tinh;
	}
	
}
	