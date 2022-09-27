package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.OnsiteCourse;
import DTO.Person;
import DTO.StudentGrade;
import GUI.Contrains;

public class OnsiteCourseDAL {

	public OnsiteCourseDAL() {
		super();
	}
	
	
	public ArrayList<OnsiteCourse> loadOnsiteCourses(int page){
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
			Connection conn = DBConnect.getConnection();
			Statement stmt = conn.createStatement();
			ArrayList<OnsiteCourse> listOnsiteCourses = new ArrayList<>();
			String query = "SELECT * FROM `onsitecourse` ";
			ResultSet rs = stmt.executeQuery(query);
			if (rs != null) {
				int i = 1;
				while (rs.next()) {
					int id = rs.getInt("CourseID");
					String location = rs.getString("Location");
					String days = rs.getString("Days");
					Time time = rs.getTime("Time");
					OnsiteCourse onsitecourse = new OnsiteCourse(id, location, days, time);
					listOnsiteCourses.add(onsitecourse);
				}
			}
			conn.close();
			return listOnsiteCourses;
		} catch (Exception e) {
		}
		return null;
	}
	
	public boolean addOnsiteCourse(OnsiteCourse o) {
		try {
			String sql = "INSERT INTO `onsitecourse`( `CourseID`, `Location`, `Days`, `Time`) VALUES (?,?,?,?)";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, o.getCourseID());
			pstm.setString(2, o.getLocation());
			pstm.setString(3, o.getDays());
			pstm.setTime(4, o.getTime());
			int i = pstm.executeUpdate();
			conn.close();
			return i > 0 ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean editOnsiteCourse(OnsiteCourse o) {
		try {
			String sql = "UPDATE `onsitecourse` SET `Location`= ? ,`Days`= ? ,`Time`= ? WHERE CourseID = ?";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, o.getLocation());
			pstm.setString(2, o.getDays());
			pstm.setTime(3, o.getTime());
			pstm.setInt(4, o.getCourseID());
			int i = pstm.executeUpdate();
			conn.close();
			return i > 0 ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteOnsiteCourse(int id) {
		try {
			String sql = "DELETE FROM `onsitecourse` WHERE CourseID = ? ";
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			int i = pstm.executeUpdate();
			conn.close();
			return i > 0 ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
