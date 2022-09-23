package BLL;

import java.util.ArrayList;

import DAL.DepartmentDAL;

public class DepartementBLL {
	public static DepartementBLL gI;

	public static DepartementBLL gI() {
		if (gI == null) {
			gI = new DepartementBLL();
		}
		return gI;
	}

	public ArrayList<DTO.Department> listDepartments() {
		return DepartmentDAL.gI().readDepartments();

	}
}
