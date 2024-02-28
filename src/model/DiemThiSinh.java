package model;

public class DiemThiSinh {
	private String maTS;
	private Float toan,ly,hoa,sinh,van, anh;
	
	public DiemThiSinh() {
	}
	public DiemThiSinh( String maTS, Float toan, Float van, Float anh, Float ly, Float hoa, Float sinh) {
		this.maTS = maTS;
		this.toan = toan;
		this.ly = ly;
		this.hoa = hoa;
		this.sinh = sinh;
		this.van = van;
		this.anh = anh;
	}
	
	
	public String getMaTS() {
		return maTS;
	}
	public void setMaTS(String maTS) {
		this.maTS = maTS;
	}
	public Float getToan() {
		return toan;
	}
	public void setToan(Float toan) {
		this.toan = toan;
	}
	public Float getLy() {
		return ly;
	}
	public void setLy(Float ly) {
		this.ly = ly;
	}
	public Float getHoa() {
		return hoa;
	}
	public void setHoa(Float hoa) {
		this.hoa = hoa;
	}
	public Float getSinh() {
		return sinh;
	}
	public void setSinh(Float sinh) {
		this.sinh = sinh;
	}
	public Float getVan() {
		return van;
	}
	public void setVan(Float van) {
		this.van = van;
	}
	public Float getAnh() {
		return anh;
	}
	public void setAnh(Float anh) {
		this.anh = anh;
	}
	
	
}
