package DTO;

public class phancong {
	private int MaKhoaHoc;
	private int MaGV;
	private String TrangThai;

	public int getMaKhoaHoc() {
		return MaKhoaHoc;
	}

	public void setMaKhoaHoc(int maKhoaHoc) {
		MaKhoaHoc = maKhoaHoc;
	}

	public int getMaGV() {
		return MaGV;
	}

	public void setMaGV(int maGV) {
		MaGV = maGV;
	}

	public String getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}

	public phancong(int maKhoaHoc, int maGV, String trangThai) {
		super();
		MaKhoaHoc = maKhoaHoc;
		MaGV = maGV;
		TrangThai = trangThai;
	}

	public phancong() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "phancong [MaKhoaHoc=" + MaKhoaHoc + ", MaGV=" + MaGV + ", TrangThai=" + TrangThai + "]";
	}
	
}
