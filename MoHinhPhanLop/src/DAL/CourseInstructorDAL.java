package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.CourseInstructor;
import DTO.Person;
import GUI.Contrains;

public class CourseInstructorDAL {

	public CourseInstructorDAL() {
		super();
	}

	public ArrayList<CourseInstructor> readCourseInstructors() {
		try {
			Connection conn = DBConnect.getConnection();
			Statement stmt = conn.createStatement();
			ArrayList<CourseInstructor> listCourseinStructors = new ArrayList<>();
			String query = "SELECT * FROM `courseinstructor`";
			ResultSet rs = stmt.executeQuery(query);
			if (rs != null) {
				int i = 1;
				while (rs.next()) {
					int idCourse = rs.getInt("CourseID");
					int idPerson = rs.getInt("PersonId");
					CourseInstructor course = new CourseInstructor(idCourse, idPerson);
					listCourseinStructors.add(course);
				}
			}
			
			return listCourseinStructors;
		} catch (Exception e) {
		}
		return null;
	}

	public ArrayList<CourseInstructor> searchByCourseID(int ID) {
		try {
			Connection conn = DBConnect.getConnection();
			ArrayList<CourseInstructor> listCourseinStructors = new ArrayList<CourseInstructor>();
			String query = "SELECT * FROM `courseinstructor` where CourseID = ?";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, ID);
			ResultSet rs = pstm.executeQuery();
			if (rs != null) {
				int i = 1;
				while (rs.next()) {
					int idCourse = rs.getInt("CourseID");
					int idPerson = rs.getInt("PersonId");
					CourseInstructor course = new CourseInstructor(idCourse, idPerson);
					listCourseinStructors.add(course);
				}
			}
			
			return listCourseinStructors;
		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		return null;
	}

	public ArrayList<CourseInstructor> searchByLectureID(int ID) {
		try {
			Connection conn = DBConnect.getConnection();
			ArrayList<CourseInstructor> listCourseinStructors = new ArrayList<CourseInstructor>();
			String query = "SELECT * FROM `courseinstructor` where PersonID = ?";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, ID);
			ResultSet rs = pstm.executeQuery();
			if (rs != null) {
				int i = 1;
				while (rs.next()) {
					int idCourse = rs.getInt("CourseID");
					int idPerson = rs.getInt("PersonId");
					CourseInstructor course = new CourseInstructor(idCourse, idPerson);
					listCourseinStructors.add(course);
				}
			}
			
			return listCourseinStructors;
		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		return null;
	}

	public ArrayList<CourseInstructor> loadCourseInstructorByPage(int page) {
		try {
			int num_record = Contrains.pagesize;
			ArrayList<CourseInstructor> list = this.readCourseInstructors();
			int size = list.size();
			System.out.println(size);
			int from, to;
			from = (page - 1) * num_record;
			to = page * num_record;
			List a = list.subList(from, Math.min(to, size));
			return list = new ArrayList<CourseInstructor>(a);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public boolean addCourseInstructor(CourseInstructor course) {
		try {
			String sql = "INSERT INTO `courseinstructor`( `CourseID`, `PersonID`) VALUES (?,?)";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, course.getCourseID());
			pstm.setInt(2, course.getPersonID());
			int i = pstm.executeUpdate();
			
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean editCourseInstructor(CourseInstructor c, CourseInstructor c2) {
		try {
			String sql = "UPDATE `courseinstructor` SET `CourseID`= ? ,`PersonID`= ? WHERE CourseID = ? AND PersonID = ?";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, c.getCourseID());
			pstm.setInt(2, c.getPersonID());
			pstm.setInt(3, c2.getCourseID());
			pstm.setInt(4, c2.getPersonID());
			int i = pstm.executeUpdate();
			
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteCourseInstructor(int idCourse, int idPerson) {
		try {
			String sql = "DELETE FROM `courseinstructor` WHERE CourseID = ? AND PersonID = ? ";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idCourse);
			pstm.setInt(2, idPerson);
			int i = pstm.executeUpdate();
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new CourseInstructorDAL().searchByCourseID(2021));
	}

}
