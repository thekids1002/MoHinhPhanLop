package DTO;

public class danhmuc {
	private int MaDanhMuc;
	private String TenDanhMuc;
	private String TrangThai;

	public int getMaDanhMuc() {
		return MaDanhMuc;
	}

	public void setMaDanhMuc(int maDanhMuc) {
		MaDanhMuc = maDanhMuc;
	}

	public String getTenDanhMuc() {
		return TenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		TenDanhMuc = tenDanhMuc;
	}

	public danhmuc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public danhmuc(int maDanhMuc, String tenDanhMuc, String trangThai) {
		super();
		MaDanhMuc = maDanhMuc;
		TenDanhMuc = tenDanhMuc;
		TrangThai = trangThai;
	}

	@Override
	public String toString() {
		return "danhmuc [MaDanhMuc=" + MaDanhMuc + ", TenDanhMuc=" + TenDanhMuc + ", TrangThai=" + TrangThai + "]";
	}

	public String getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
}
