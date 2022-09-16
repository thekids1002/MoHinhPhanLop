package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import DTO.CourseinStructor;

public class CourseinStructorDAL {
	
	public CourseinStructorDAL() {
		super();
	}
	
	public ArrayList<CourseinStructor> readCourseinStructors() {
		try {
			Connection conn = DBConnect.getConnection();
			Statement stmt = conn.createStatement();
			ArrayList<CourseinStructor> listCourseinStructors = new ArrayList<>();
			String query = "SELECT * FROM `courseinstructor`";
			ResultSet rs = stmt.executeQuery(query);
			if (rs != null) {
				int i = 1;
				while (rs.next()) {
					int idCourse = rs.getInt("CourseID");
					int idPerson = rs.getInt("PersonId");
					CourseinStructor course = new CourseinStructor(idCourse, idPerson);
					listCourseinStructors.add(course);
				}
			}
			conn.close();
			return listCourseinStructors;
		} catch (Exception e) {
		}
		return null;
	}
	
	public boolean addCourseinStructor(CourseinStructor course) {
		try {
			String sql = "INSERT INTO `courseinstructor`( `CourseID`, `PersonID`) VALUES (?,?)";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, course.getCourseID());
			pstm.setInt(2, course.getPersonID());
			int i = pstm.executeUpdate();
			conn.close();
			return i > 0 ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//Hai thằng đều là khóa chính thì hơi khó sửa
	public boolean editCourseinStructor(CourseinStructor c) {
		try {
			String sql = "UPDATE `courseinstructor` SET `CourseID`= ? ,`PersonID`= ? WHERE CourseID = ? AND PersonID = ?";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, c.getCourseID());
			pstm.setInt(2, c.getPersonID());
			int i = pstm.executeUpdate();
			conn.close();
			return i > 0 ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteCourseinStructor(int idCourse, int idPerson) {
		try {
			String sql = "DELETE FROM `courseinstructor` WHERE CourseID = ? AND PersonID = ? ";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idCourse);
			pstm.setInt(2, idPerson);
			int i = pstm.executeUpdate();
			conn.close();
			return i > 0 ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
