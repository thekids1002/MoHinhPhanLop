package DTO;

public class khoahoconline {
	private int MaKhoaHoc;
	private String url;
	private String TrangThai;

	public int getMaKhoaHoc() {
		return MaKhoaHoc;
	}

	public void setMaKhoaHoc(int maKhoaHoc) {
		MaKhoaHoc = maKhoaHoc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}

	@Override
	public String toString() {
		return "khoahoconline [MaKhoaHoc=" + MaKhoaHoc + ", url=" + url + ", TrangThai=" + TrangThai + "]";
	}

	public khoahoconline() {
		super();
		// TODO Auto-generated constructor stub
	}

	public khoahoconline(int maKhoaHoc, String url, String trangThai) {
		super();
		MaKhoaHoc = maKhoaHoc;
		this.url = url;
		TrangThai = trangThai;
	}

}
