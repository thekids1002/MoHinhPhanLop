package DTO;

public class khoahocoffline {
	private int MaKhoaHoc;
	private int MaPhong;
	private String TrangThai;
	public int getMaKhoaHoc() {
		return MaKhoaHoc;
	}
	public void setMaKhoaHoc(int maKhoaHoc) {
		MaKhoaHoc = maKhoaHoc;
	}
	public int getMaPhong() {
		return MaPhong;
	}
	public void setMaPhong(int maPhong) {
		MaPhong = maPhong;
	}
	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
	@Override
	public String toString() {
		return "khoahocoffline [MaKhoaHoc=" + MaKhoaHoc + ", MaPhong=" + MaPhong + ", TrangThai=" + TrangThai + "]";
	}
	public khoahocoffline() {
		super();
		// TODO Auto-generated constructor stub
	}
	public khoahocoffline(int maKhoaHoc, int maPhong, String trangThai) {
		super();
		MaKhoaHoc = maKhoaHoc;
		MaPhong = maPhong;
		TrangThai = trangThai;
	}
	
}
