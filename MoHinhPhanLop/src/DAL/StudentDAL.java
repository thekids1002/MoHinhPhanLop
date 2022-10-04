package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.Person;
import GUI.Contrains;

public class StudentDAL {
	public static StudentDAL gI;
	Connection conn;

	public static StudentDAL gI() {
		if (gI == null) {
			gI = new StudentDAL();
		}
		return gI;
	}

	public StudentDAL() {
		super();
		conn = DBConnect.getConnection();
	}

	public ArrayList<Person> readStudents() {
		try {

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

			return listStudents;
		} catch (Exception e) {
		}
		return null;
	}

	public ArrayList<Person> loadStudentsByPage(int page) {
		try {
			int num_record = Contrains.pagesize;
			ArrayList<Person> list = this.readStudents();
			int size = list.size();
			System.out.println(size);
			int from, to;
			from = (page - 1) * num_record;
			to = page * num_record;
			List a = list.subList(from, Math.min(to, size));
			return list = new ArrayList<Person>(a);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Person> searchByID(int ID) {
		try {

			Statement stmt = conn.createStatement();
			ArrayList<Person> listStudents = new ArrayList<>();
			String query = "SELECT * FROM person WHERE HireDate IS NULL AND PersonID =?";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, ID);
			ResultSet rs = pstm.executeQuery();
			if (rs != null) {
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

			return listStudents;
		} catch (Exception e) {
		}
		return null;
	}

	public ArrayList<Person> searchByName(String name) {
		try {

			Statement stmt = conn.createStatement();
			ArrayList<Person> listStudents = new ArrayList<>();
			String query = "SELECT * FROM person WHERE HireDate IS NULL AND concat(FirstName,' ',LastName) like ?";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, "%" + name + "%");
			ResultSet rs = pstm.executeQuery();
			if (rs != null) {
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

			return listStudents;
		} catch (Exception e) {
		}
		return null;
	}

	public boolean addStudent(Person s) {
		try {
			String sql = "INSERT INTO `person`( `Lastname`, `Firstname`, `HireDate`, `EnrollmentDate`) VALUES (?,?,?,?)";

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, s.getLastname());
			pstm.setString(2, s.getFirstname());
			// pstm.setDate(3, new java.sql.Date(s.getHireDate().getTime()));
			pstm.setDate(3, null);
			pstm.setDate(4, new java.sql.Date(s.getEnrollmentDate().getTime()));
			int i = pstm.executeUpdate();

			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean editStudent(Person s) {
		try {
			String sql = "UPDATE `person` SET `Lastname`= ? ,`Firstname`= ? ,`HireDate`= ?,`EnrollmentDate`= ? WHERE PersonID = ?";

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, s.getLastname());
			pstm.setString(2, s.getFirstname());
			// pstm.setDate(3, new java.sql.Date(s.getHireDate().getTime()));
			pstm.setDate(3, null);
			pstm.setDate(4, new java.sql.Date(s.getEnrollmentDate().getTime()));
			pstm.setInt(5, s.getID());
			int i = pstm.executeUpdate();

			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteStudent(int id) {
		try {
			String sql = "DELETE FROM `person` WHERE PersonID = ? ";

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			int i = pstm.executeUpdate();

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
		// ArrayList<Person> list = student.readStudents();
		ArrayList<Person> arrayList = student.loadStudentsByPage(3);
		for (Person person : arrayList) {
			System.out.println(person.toString());
		}
	}

}
