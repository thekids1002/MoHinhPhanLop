package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.Course;
import DTO.OnlineCourse;
import DTO.OnsiteCourse;
import DTO.Person;
import DTO.StudentGrade;
import GUI.Contrains;

public class OnsiteCourseDAL {
	Connection conn;
	public OnsiteCourseDAL() {
		super();
		conn = DBConnect.getConnection();
	}
	
	public ArrayList<OnsiteCourse> loadOnsiteCoursesByPage(int page){
		try {
			int num_record = Contrains.pagesize;
			ArrayList<OnsiteCourse> list = this.readOnsiteCourses();
			int size = list.size();
			System.out.println(size);
			int from, to;
			from = ( page - 1)  * num_record;
			to = page * num_record;
			List a =  list.subList(from, Math.min(to,size));
			return list = new ArrayList<OnsiteCourse>(a);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<OnsiteCourse> readOnsiteCourses() {
		try {
			
			Statement stmt = conn.createStatement();
			ArrayList<OnsiteCourse> listOnsiteCourses = new ArrayList<>();
			String query = "SELECT * FROM `onsitecourse`, `course` WHERE onsitecourse.CourseID = course.CourseID";
			ResultSet rs = stmt.executeQuery(query);
			if (rs != null) {
				int i = 1;
				while (rs.next()) {
					int id = rs.getInt("CourseID");
					String location = rs.getString("Location");
					String days = rs.getString("Days");
					Time time = rs.getTime("Time");
					int credtis = rs.getInt("credits");
					String title = rs.getString("Title");
					int department = rs.getInt("DepartmentID"); 
					OnsiteCourse onsitecourse = new OnsiteCourse(id, title, credtis, department, location, days, time);
					listOnsiteCourses.add(onsitecourse);
				}
			}
			
			return listOnsiteCourses;
		} catch (Exception e) {
		}
		return null;
	}
	
	public boolean addOnsiteCourse(OnsiteCourse o) {
		try {
			String sql = "INSERT INTO `onsitecourse`( `CourseID`, `Location`, `Days`, `Time`) VALUES (?,?,?,?)";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, o.getCourseID());
			pstm.setString(2, o.getLocation());
			pstm.setString(3, o.getDays());
			pstm.setTime(4, o.getTime());
			int i = pstm.executeUpdate();
			
			return i > 0 ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean editOnsiteCourse(OnsiteCourse o) {
		try {
			String sql = "UPDATE `onsitecourse` SET `Location`= ? ,`Days`= ? ,`Time`= ? WHERE CourseID = ?";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, o.getLocation());
			pstm.setString(2, o.getDays());
			pstm.setTime(3, o.getTime());
			pstm.setInt(4, o.getCourseID());
			int i = pstm.executeUpdate();
			
			return i > 0 ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteOnsiteCourse(int id) {
		try {
			String sql = "DELETE FROM `onsitecourse` WHERE CourseID = ? ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			int i = pstm.executeUpdate();
			
			return i > 0 ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean checkCourseInContrusctor(int id) {
		try {
			String sql = "SELECT * FROM courseinstructor WHERE CourseID = ?";

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			return rs != null;
		} catch (Exception e) {
		}
		return false;
		
	}
	
	public ArrayList<OnsiteCourse> searchOnsiteByID(int ID) {
		try {

			Statement stmt = conn.createStatement();
			ArrayList<OnsiteCourse> listCourses = new ArrayList<>();
			String query = "SELECT course.CourseID, course.Title, course.Credits, course.DepartmentID, onsitecourse.Location,"
					+ " onsitecourse.Days, onsitecourse.Time "
					+ "FROM `course` , onsitecourse"
					+ " WHERE course.CourseID = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, ID);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs != null) {
				int i = 1;
				while (rs.next()) {
					int idCourse = rs.getInt("CourseID");
					String title = rs.getString("Title");
					int credit = rs.getInt("Credits");
					int department = rs.getInt("DepartmentID");
					String location = rs.getString("Location");
					String Days = rs.getString("Days");
					Time time = rs.getTime("Time");
					OnsiteCourse onsiteCourse = new OnsiteCourse(idCourse, title, credit, department, location, Days, time);
					listCourses.add(onsiteCourse);
				}
			}
			
			return listCourses;
		} catch (Exception e) {
		}
		return null;
	}
	
	
}
