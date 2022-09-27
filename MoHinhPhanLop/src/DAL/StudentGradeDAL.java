package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.Person;
import DTO.StudentGrade;
import GUI.Contrains;

public class StudentGradeDAL {
	public static StudentGradeDAL gI;

	public static StudentGradeDAL gI() {
		if (gI == null) {
			gI = new StudentGradeDAL();
		}
		return gI;
	}

	public StudentGradeDAL() {
		super();
	}

	public ArrayList<StudentGrade> loadGardeByPage(int page) {
		try {
			int num_record = Contrains.pagesize;
			ArrayList<StudentGrade> list = this.readStudentGrades();
			int size = list.size();
			System.out.println(size);
			int from, to;
			from = (page - 1) * num_record;
			to = page * num_record;
			List a = list.subList(from, Math.min(to, size));
			return list = new ArrayList<StudentGrade>(a);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<StudentGrade> readStudentGrades() {
		try {
			Connection conn = DBConnect.getConnection();
			Statement stmt = conn.createStatement();
			ArrayList<StudentGrade> listStudentGrades = new ArrayList<>();
			String query = "SELECT * FROM `studentgrade` ";
			ResultSet rs = stmt.executeQuery(query);
			if (rs != null) {
				int i = 1;
				while (rs.next()) {
					int idEn = rs.getInt("EnrollmentID");
					int idCo = rs.getInt("CourseID");
					int idSt = rs.getInt("StudentID");
					float grade = rs.getFloat("Grade");
					StudentGrade stugrade = new StudentGrade(idEn, idCo, idSt, grade);
					listStudentGrades.add(stugrade);
				}
			}
			conn.close();
			return listStudentGrades;
		} catch (Exception e) {
		}
		return null;
	}

	public boolean addStudentGrade(StudentGrade s) {
		try {
			String sql = "INSERT INTO `studentgrade`( `CourseID`, `StudentID`, `Grade`) VALUES (?,?,?)";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, s.getCourseID());
			pstm.setInt(2, s.getStudentID());
			pstm.setFloat(3, s.getGrade());
			int i = pstm.executeUpdate();
			conn.close();
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean editStudentGrade(StudentGrade s) {
		try {
			String sql = "UPDATE `studentgrade` SET `CourseID`= ? ,`StudentID`= ? ,`Grade`= ? WHERE EnrollmentID = ?";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, s.getCourseID());
			pstm.setInt(2, s.getStudentID());
			pstm.setFloat(3, s.getGrade());
			pstm.setInt(4, s.getEnrollmentID());
			int i = pstm.executeUpdate();
			conn.close();
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteStudentGrade(int id) {
		try {
			String sql = "DELETE FROM `studentgrade` WHERE EnrollmentID = ? ";
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

}
