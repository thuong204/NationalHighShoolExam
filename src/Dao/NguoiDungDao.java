package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Helper.Connect;
import model.NguoiDung;

public class NguoiDungDao {
	public NguoiDung checkLogin(String tenDangNhap, String matKhau ) 
		throws Exception{
			String sql = "Select tenDangNhap,matKhau from NguoiQuanLi where tenDangNhap=? and matKhau=?";
			try (
				Connection con = Connect.openConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
				pstmt.setString(1, tenDangNhap);
				pstmt.setString(2, matKhau);
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()){
					NguoiDung nd = new NguoiDung();
					nd.setTenDN(tenDangNhap);
					return nd;
				}
			}
		}
	return null;
	}	
}
