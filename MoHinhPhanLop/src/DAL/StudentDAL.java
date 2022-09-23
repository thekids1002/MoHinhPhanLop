package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import DTO.Person;

public class StudentDAL {
	public static StudentDAL gI;

	public static StudentDAL gI() {
		if (gI == null) {
			gI = new StudentDAL();
		}
		return gI;
	}

	public StudentDAL() {
		super();
	}

	public ArrayList<Person> readStudents() {
		try {
			Connection conn = DBConnect.getConnection();
			Statement stmt = conn.createStatement();
			ArrayList<Person> listStudents = new ArrayList<>();
			String query = "SELECT * FROM person WHERE HireDate IS NULL  ;";
			ResultSet rs = stmt.executeQuery(query);
			if (rs != null) {
				int i = 1;
				while (rs.next()) {
					int id = rs.getInt("PersonID");
					String lastName = rs.getString("Lastname");
					String Firstname = rs.getString("Firstname");
					Date HireDate = rs.getDate("HireDate");
					Date EnrollmentDate = rs.getDate("EnrollmentDate");
					Person person = new Person(id, lastName, Firstname, HireDate, EnrollmentDate);
					listStudents.add(person);
				}
			}
			conn.close();
			return listStudents;
		} catch (Exception e) {
		}
		return null;
	}

	public boolean addStudent(Person s) {
		try {
			String sql = "INSERT INTO `person`( `Lastname`, `Firstname`, `HireDate`, `EnrollmentDate`) VALUES (?,?,?,?)";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, s.getLastname());
			pstm.setString(2, s.getFirstname());
		//	pstm.setDate(3, new java.sql.Date(s.getHireDate().getTime()));
			pstm.setDate(3, null);
			pstm.setDate(4, new java.sql.Date(s.getEnrollmentDate().getTime()));
			int i = pstm.executeUpdate();
			conn.close();
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean editStudent(Person s) {
		try {
			String sql = "UPDATE `person` SET `Lastname`= ? ,`Firstname`= ? ,`HireDate`= ?,`EnrollmentDate`= ? WHERE PersonID = ?";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, s.getLastname());
			pstm.setString(2, s.getFirstname());
		//	pstm.setDate(3, new java.sql.Date(s.getHireDate().getTime()));
			pstm.setDate(3, null);
			pstm.setDate(4, new java.sql.Date(s.getEnrollmentDate().getTime()));
			pstm.setInt(5, s.getID());
			int i = pstm.executeUpdate();
			conn.close();
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteStudent(int id) {
		try {
			String sql = "DELETE FROM `person` WHERE PersonID = ? ";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			int i = pstm.executeUpdate();
			conn.close();
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		Person person1 = new Person(33, "Voxasdasdasda", "Hoang", new Date(System.currentTimeMillis()),
				new Date(System.currentTimeMillis()));
		StudentDAL student = new StudentDAL();
		student.deleteStudent(35);
		ArrayList<Person> arrayList = student.readStudents();
		for (Person person : arrayList) {
			System.out.println(person.toString());
		}
	}

}
