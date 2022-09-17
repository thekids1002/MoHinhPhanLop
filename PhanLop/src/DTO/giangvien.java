package DTO;

public class giangvien {
	private int MaGV;
	private String TenGV;
	private String DiaChi;
	private String Sdt;
	private String TrangThai;

	public giangvien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public giangvien(String tenGV) {
		super();
		TenGV = tenGV;
	}

	@Override
	public String toString() {
		return "giangvien [MaGV=" + MaGV + ", TenGV=" + TenGV + ", DiaChi=" + DiaChi + ", Sdt=" + Sdt + ", TrangThai="
				+ TrangThai + "]";
	}

	public int getMaGV() {
		return MaGV;
	}

	public void setMaGV(int maGV) {
		MaGV = maGV;
	}

	public String getTenGV() {
		return TenGV;
	}

	public void setTenGV(String tenGV) {
		TenGV = tenGV;
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
