package DTO;

public class diem {
	private int MaHV;
	private int MaKhoaHoc;
	private float DiemSo;
	private int MaDiem;

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

	public float getDiemSo() {
		return DiemSo;
	}

	public void setDiemSo(float diemSo) {
		DiemSo = diemSo;
	}

	public int getMaDiem() {
		return MaDiem;
	}

	public void setMaDiem(int maDiem) {
		MaDiem = maDiem;
	}

	@Override
	public String toString() {
		return "diem [MaHV=" + MaHV + ", MaKhoaHoc=" + MaKhoaHoc + ", DiemSo=" + DiemSo + ", MaDiem=" + MaDiem + "]";
	}

	public diem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
