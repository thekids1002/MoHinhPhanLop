package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import DTO.Course;

public class CourseDAL {
	
	public CourseDAL() {
		super();
	}
	
	public ArrayList<Course> readCourses() {
		try {
			Connection conn = DBConnect.getConnection();
			Statement stmt = conn.createStatement();
			ArrayList<Course> listCourses = new ArrayList<>();
			String query = "SELECT * FROM `course`";
			ResultSet rs = stmt.executeQuery(query);
			if (rs != null) {
				int i = 1;
				while (rs.next()) {
					int idCourse = rs.getInt("CourseID");
					String title = rs.getString("Title");
					int credit = rs.getInt("Credits");
					int department = rs.getInt("DepartmentID");
					Course course = new Course(idCourse, title, credit, department);
					listCourses.add(course);
				}
			}
			conn.close();
			return listCourses;
		} catch (Exception e) {
		}
		return null;
	}
	
	public boolean addCourse(Course course) {
		try {
			String sql = "INSERT INTO `course`( `Title`, `Credits`, `DepartmentID`) VALUES (?,?,?)";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, course.getTitle());
			pstm.setInt(2, course.getCredits());
			pstm.setInt(3, course.getDepartmentID());
			int i = pstm.executeUpdate();
			conn.close();
			return i > 0 ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean editCourse(Course c) {
		try {
			String sql = "UPDATE `course` SET `Title`= ? ,`Credits`= ? ,`DepartmentID`= ? WHERE CourseID = ? ";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, c.getTitle());
			pstm.setInt(2, c.getCredits());
			pstm.setInt(3, c.getDepartmentID());
			pstm.setInt(4, c.getCourseID());
			int i = pstm.executeUpdate();
			conn.close();
			return i > 0 ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteCourse(int idCourse) {
		try {
			String sql = "DELETE FROM `course` WHERE CourseID = ? ";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idCourse);
			int i = pstm.executeUpdate();
			conn.close();
			return i > 0 ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
//	public static void main(String[] args) {
//		Course course = new Course(1045, "Calculus", 3, 7);
//		CourseDAL c1 = new CourseDAL();
//		//c1.addCourse(course);
//		//c1.deleteCourse(1111);
//		c1.editCourse(course);
//		ArrayList<Course> arrayList  = c1.readCourses();
//		for (Course c : arrayList) {
//			System.out.println(c.toString());
//		}
//	}
	
}
