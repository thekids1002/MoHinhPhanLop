package DTO;

public class hocvien {
	private int MaHocVien;
	private String TenHocVien;
	private String DiaChi;
	private String Sdt;
	private String TrangThai;

	@Override
	public String toString() {
		return "hocvien [MaHocVien=" + MaHocVien + ", TenHocVien=" + TenHocVien + ", DiaChi=" + DiaChi + ", Sdt=" + Sdt
				+ ", TrangThai=" + TrangThai + "]";
	}

	public hocvien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public hocvien(int maHocVien, String tenHocVien, String diaChi, String sdt, String trangThai) {
		super();
		MaHocVien = maHocVien;
		TenHocVien = tenHocVien;
		DiaChi = diaChi;
		Sdt = sdt;
		TrangThai = trangThai;
	}

	public int getMaHocVien() {
		return MaHocVien;
	}

	public void setMaHocVien(int maHocVien) {
		MaHocVien = maHocVien;
	}

	public String getTenHocVien() {
		return TenHocVien;
	}

	public void setTenHocVien(String tenHocVien) {
		TenHocVien = tenHocVien;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getSdt() {
		return Sdt;
	}

	public void setSdt(String sdt) {
		Sdt = sdt;
	}

	public String getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
}
