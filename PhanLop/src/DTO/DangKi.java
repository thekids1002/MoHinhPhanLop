package DTO;

public class DangKi {
	private int MaHV;
	private int MaKhoaHoc;
	public int getMaHV() {
		return MaHV;
	}
	public void setMaHV(int maHV) {
		MaHV = maHV;
	}
	public int getMaKhoaHoc() {
		return MaKhoaHoc;
	}
	public void setMaKhoaHoc(int maKhoaHoc) {
		MaKhoaHoc = maKhoaHoc;
	}
	@Override
	public String toString() {
		return "DangKi [MaHV=" + MaHV + ", MaKhoaHoc=" + MaKhoaHoc + "]";
	}
	public DangKi(int maHV, int maKhoaHoc) {
		super();
		MaHV = maHV;
		MaKhoaHoc = maKhoaHoc;
	}
	public DangKi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
