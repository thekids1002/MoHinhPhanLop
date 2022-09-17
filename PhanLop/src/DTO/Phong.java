package DTO;

public class Phong {
	private int MaPhong;
	private String TenPhong;
	private String TrangThai;
	public int getMaPhong() {
		return MaPhong;
	}
	public void setMaPhong(int maPhong) {
		MaPhong = maPhong;
	}
	public String getTenPhong() {
		return TenPhong;
	}
	public void setTenPhong(String tenPhong) {
		TenPhong = tenPhong;
	}
	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
	public Phong(int maPhong, String tenPhong, String trangThai) {
		super();
		MaPhong = maPhong;
		TenPhong = tenPhong;
		TrangThai = trangThai;
	}
	public Phong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
