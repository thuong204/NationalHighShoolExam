package Dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import model.DiemThiSinh;
import Helper.Connect;
import model.NguoiDung;
import model.ThiSinh;
import model.Tinh;
import view.HomeView;

public class ThiSinhDao {
	public boolean insert(ThiSinh ts ) 
			throws Exception{
	
				String sql = "INSERT INTO dbo.ThiSinh(MaThiSinh,TenThiSinh,NgaySinh,GioiTinh,Lop,Truong,Tinh)\r\n"
						+ "VALUES(?,?,?,?,?,?,?)";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setString(1,ts.getMaThiSinh());
					pstmt.setString(2,ts.getTenThiSinh());
					pstmt.setString(3,ts.getNgaySinh());
					pstmt.setInt(4,ts.getGioiTinh());
					pstmt.setString(5,ts.getLop());
					pstmt.setString(6,ts.getTruong());
					pstmt.setString(7,ts.getTinh());
					
		return pstmt.executeUpdate()>0;
		}	
	}
	public boolean update(ThiSinh ts ) 
			throws Exception{
		
	
				String sql = "UPDATE dbo.ThiSinh"
						+ "				   SET MaThiSinh = ?,TenThiSinh = ?,NgaySinh = ?,GioiTinh =?,Lop = ?,Truong = ?,Tinh = ? "+" where MaThiSinh=?";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setString(1,ts.getMaThiSinh());
					pstmt.setString(2,ts.getTenThiSinh());
					pstmt.setString(3,ts.getNgaySinh());
					pstmt.setInt(4,ts.getGioiTinh());
					pstmt.setString(5,ts.getLop());
					pstmt.setString(6,ts.getTruong());
					pstmt.setString(7,ts.getTinh());
					pstmt.setString(8, ts.getMaThiSinh());
					
		return pstmt.executeUpdate()>0;
		}	
	}
	public boolean delete(String maThiSinh ) 
			throws Exception{
		
	
				String sql = "delete from ThiSinh "+"where MaThiSinh=?";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setString(1,maThiSinh);
					
		return pstmt.executeUpdate()>0;
		}	
	}
	public boolean insertDiem(DiemThiSinh dts) 
	       throws Exception{
		if(dts.getToan()>10 || dts.getToan()<0 || dts.getLy()>10 || dts.getLy()<0 ||dts.getHoa()>10 ||
		  dts.getHoa()<0 ||dts.getSinh()>10 || dts.getSinh()<0 ||dts.getVan()>10 || dts.getVan()<0 ||dts.getAnh()>10 
		   || dts.getAnh()<0  ) {
			return false;
		}
		String sql ="INSERT INTO dbo.DiemThiSinh(MaThiSinh,Toan,Van,Anh,Ly,Hoa,Sinh)\r\n"+"VALUES(?,?,?,?,?,?,?)";
		try (
				Connection con = Connect.openConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			    
			    pstmt.setString(1,dts.getMaTS());
			    pstmt.setFloat(2,dts.getToan());
			    pstmt.setFloat(3,dts.getVan());
			    pstmt.setFloat(4,dts.getAnh());
			    pstmt.setFloat(5,dts.getLy());
			    pstmt.setFloat(6,dts.getHoa());
			    pstmt.setFloat(7,dts.getSinh());
			    
		   return pstmt.executeUpdate()>0;	
		}
	}
	public boolean updateDiem(DiemThiSinh dts) 
		       throws Exception{
			if(dts.getToan()>10 || dts.getToan()<0 || dts.getLy()>10 || dts.getLy()<0 ||dts.getHoa()>10 ||
			  dts.getHoa()<0 ||dts.getSinh()>10 || dts.getSinh()<0 ||dts.getVan()>10 || dts.getVan()<0 ||dts.getAnh()>10 
			   || dts.getAnh()<0  ) {
				return false;
			}
			String sql ="UPDATE dbo.DiemThiSinh"+"   SET MaThiSInh=? ,Toan=?,Van=?,Anh=?,Ly=?,Hoa=?,Sinh=?"+"   where MaThiSInh=?";
			try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
				    
				    pstmt.setString(1,dts.getMaTS());
				    pstmt.setFloat(2,dts.getToan());
				    pstmt.setFloat(3,dts.getVan());
				    pstmt.setFloat(4,dts.getAnh());
				    pstmt.setFloat(5,dts.getLy());
				    pstmt.setFloat(6,dts.getHoa());
				    pstmt.setFloat(7,dts.getSinh());
				    pstmt.setString(8,dts.getMaTS());
				    
			   return pstmt.executeUpdate()>0;	
			}
		}
	public boolean deleteDiem(String maThiSinh ) 
			throws Exception{
		
	
				String sql = "delete from DiemThiSinh "+"where MaThiSinh=?";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setString(1,maThiSinh);
					
		return pstmt.executeUpdate()>0;
		}	
	}
	public ArrayList<DiemThiSinh> getListComponents(){
		ArrayList<DiemThiSinh> list = new ArrayList<>();
		String sql = "SELECT * FROM DiemThiSinh";
		try {
			Connection connection = Connect.openConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DiemThiSinh s = new DiemThiSinh();
				s.setMaTS(rs.getString("MaThiSinh"));
				s.setToan(rs.getFloat("Toan"));
				s.setVan(rs.getFloat("Van"));
				s.setAnh(rs.getFloat("Anh"));
				s.setLy(rs.getFloat("Ly"));
				s.setHoa(rs.getFloat("Hoa"));
				s.setSinh(rs.getFloat("Sinh"));
				list.add(s);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
//	public ArrayList<DiemThiSinh> getListTimKiemDiem(DiemThiSinh dts){
//		ArrayList<DiemThiSinh> list = new ArrayList<>();
//		String sql = "SELECT * FROM DiemThiSinh where MaThiSinh=? ";
//		try {
//			Connection connection = Connect.openConnection();
//			PreparedStatement ps = connection.prepareStatement(sql);
//			ps.setString(0,dts.getMaTS());
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				DiemThiSinh s = new DiemThiSinh();
//				s.setMaTS(rs.getString("MaThiSinh"));
//				s.setToan(rs.getFloat("Toan"));
//				s.setVan(rs.getFloat("Van"));
//				s.setAnh(rs.getFloat("Anh"));
//				s.setLy(rs.getFloat("Ly"));
//				s.setHoa(rs.getFloat("Hoa"));
//				s.setSinh(rs.getFloat("Sinh"));
//				list.add(s);
//				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
	public ArrayList<ThiSinh> getListThiSinh(){
		ArrayList<ThiSinh> list = new ArrayList<>();
		String sql = "SELECT * FROM ThiSinh";
		try {
			Connection connection = Connect.openConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ThiSinh ts = new ThiSinh();
				Tinh t = new Tinh();
				ts.setMaThiSinh(rs.getString("MaThiSinh"));
				ts.setTenThiSinh(rs.getString("TenThiSinh"));
				ts.setNgaySinh(rs.getString("NgaySinh"));
				ts.setGioiTinh(rs.getInt("GioiTinh"));
				ts.setLop(rs.getString("Lop"));
				ts.setTruong(rs.getString("Truong"));
				ts.setTinh(rs.getString("Tinh"));
				list.add(ts);
			}			
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		}     
	
}
