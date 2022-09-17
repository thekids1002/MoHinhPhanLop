package DTO;

public class TaiKhoan {
	private int MaTaiKhoan;
	private String Password;
	private String TrangThai;

	public int getMaTaiKhoan() {
		return MaTaiKhoan;
	}

	public void setMaTaiKhoan(int maTaiKhoan) {
		MaTaiKhoan = maTaiKhoan;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}

	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaiKhoan(int maTaiKhoan, String password, String trangThai) {
		super();
		MaTaiKhoan = maTaiKhoan;
		Password = password;
		TrangThai = trangThai;
	}

	@Override
	public String toString() {
		return "TaiKhoan [MaTaiKhoan=" + MaTaiKhoan + ", Password=" + Password + ", TrangThai=" + TrangThai + "]";
	}
}
