package DTO;

public class khoahoc {
	private int MaKhoaHoc;
	private String TenKhoaHoc;
	private String MoTaKhoaHoc;
	private String HinhThucHoc;
	private int MaPhong;
	private int MaDanhMuc;

	public int getMaKhoaHoc() {
		return MaKhoaHoc;
	}

	public khoahoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public khoahoc(int maKhoaHoc, String tenKhoaHoc, String moTaKhoaHoc, String hinhThucHoc, int maPhong,
			int maDanhMuc) {
		super();
		MaKhoaHoc = maKhoaHoc;
		TenKhoaHoc = tenKhoaHoc;
		MoTaKhoaHoc = moTaKhoaHoc;
		HinhThucHoc = hinhThucHoc;
		MaPhong = maPhong;
		MaDanhMuc = maDanhMuc;
	}

	public void setMaKhoaHoc(int maKhoaHoc) {
		MaKhoaHoc = maKhoaHoc;
	}

	public String getTenKhoaHoc() {
		return TenKhoaHoc;
	}

	public void setTenKhoaHoc(String tenKhoaHoc) {
		TenKhoaHoc = tenKhoaHoc;
	}

	public String getMoTaKhoaHoc() {
		return MoTaKhoaHoc;
	}

	public void setMoTaKhoaHoc(String moTaKhoaHoc) {
		MoTaKhoaHoc = moTaKhoaHoc;
	}

	public String getHinhThucHoc() {
		return HinhThucHoc;
	}

	public void setHinhThucHoc(String hinhThucHoc) {
		HinhThucHoc = hinhThucHoc;
	}

	public int getMaPhong() {
		return MaPhong;
	}

	public void setMaPhong(int maPhong) {
		MaPhong = maPhong;
	}

	public int getMaDanhMuc() {
		return MaDanhMuc;
	}

	public void setMaDanhMuc(int maDanhMuc) {
		MaDanhMuc = maDanhMuc;
	}
}
