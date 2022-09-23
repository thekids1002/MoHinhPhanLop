package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import DTO.Course;
import DTO.Department;

public class DepartmentDAL {
	public static DepartmentDAL gI;

	public static DepartmentDAL gI() {
		if (gI == null) {
			gI = new DepartmentDAL();
		}
		return gI;
	}

	public DepartmentDAL() {
		super();
	}

	public ArrayList<Department> readDepartments() {
		try {
			Connection conn = DBConnect.getConnection();
			Statement stmt = conn.createStatement();
			ArrayList<Department> listDepartments = new ArrayList<>();
			String query = "SELECT * FROM `department`";
			ResultSet rs = stmt.executeQuery(query);
			if (rs != null) {
				int i = 1;
				while (rs.next()) {
					int id = rs.getInt("DepartmentID");
					String name = rs.getString("Name");
					double budget = rs.getDouble("Budget");
					Date startdate = rs.getDate("StartDate");
					int admin = rs.getInt("Administrator");
					Department depart = new Department(id, name, budget, startdate, admin);
					listDepartments.add(depart);
				}
			}
			conn.close();
			return listDepartments;
		} catch (Exception e) {
		}
		return null;
	}

	public boolean addDepartment(Department depart) {
		try {
			String sql = "INSERT INTO `department`( `DepartmentID`, `Name`, `Budget`, `StartDate`, `Administrator`) VALUES (?,?,?,?,?)";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, depart.getDepartmentID());
			pstm.setString(2, depart.getName());
			pstm.setDouble(3, depart.getBudget());
			pstm.setDate(4, new java.sql.Date(depart.getStartDate().getTime()));
			pstm.setInt(5, depart.getAdministrator());
			int i = pstm.executeUpdate();
			conn.close();
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean editDepartment(Department depart) {
		try {
			String sql = "UPDATE `department` SET `Name`= ? ,`Budget`= ? ,`StartDate`= ? ,`Adinistrator`= ? WHERE DepartmentID = ? ";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, depart.getName());
			pstm.setDouble(2, depart.getBudget());
			pstm.setDate(3, new java.sql.Date(depart.getStartDate().getTime()));
			pstm.setInt(4, depart.getAdministrator());
			pstm.setInt(5, depart.getDepartmentID());
			int i = pstm.executeUpdate();
			conn.close();
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteDepartment(int idDepartment) {
		try {
			String sql = "DELETE FROM `department` WHERE DepartmentID = ? ";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idDepartment);
			int i = pstm.executeUpdate();
			conn.close();
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
