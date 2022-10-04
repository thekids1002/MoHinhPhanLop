package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.OnlineCourse;
import DTO.OnsiteCourse;
import GUI.Contrains;

public class OnlineCourseDAL {
	Connection conn;

	public OnlineCourseDAL() {
		super();
		conn = DBConnect.getConnection();
	}

	public ArrayList<OnlineCourse> loadOnlineCourseByPage(int page) {
		try {
			int num_record = Contrains.pagesize;
			ArrayList<OnlineCourse> list = this.readOnlineCourses();
			int size = list.size();
			System.out.println(size);
			int from, to;
			from = (page - 1) * num_record;
			to = page * num_record;
			List a = list.subList(from, Math.min(to, size));
			return list = new ArrayList<OnlineCourse>(a);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<OnlineCourse> readOnlineCourses() {
		try {
			
			Statement stmt = conn.createStatement();
			ArrayList<OnlineCourse> listOnlineCourses = new ArrayList<>();
			String query = "SELECT * FROM `onlinecourse` ";
			ResultSet rs = stmt.executeQuery(query);
			if (rs != null) {
				int i = 1;
				while (rs.next()) {
					int id = rs.getInt("CourseID");
					String url = rs.getString("url");
					OnlineCourse onlinecourse = new OnlineCourse(id, url);
					listOnlineCourses.add(onlinecourse);
				}
			}
			
			return listOnlineCourses;
		} catch (Exception e) {
		}
		return null;
	}

	public boolean addOnlineCourse(OnlineCourse o) {
		try {
			String sql = "INSERT INTO `onlinecourse`( `CourseID`, `url`) VALUES (?,?)";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, o.getCourseID());
			pstm.setString(2, o.getUrl());
			int i = pstm.executeUpdate();
			
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean editOnlineCourse(OnlineCourse o) {
		try {
			String sql = "UPDATE `onlinecourse` SET `url`= ? WHERE CourseID = ?";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, o.getUrl());
			pstm.setInt(2, o.getCourseID());
			int i = pstm.executeUpdate();
			
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteOnlineCourse(int id) {
		try {
			String sql = "DELETE FROM `onlinecourse` WHERE CourseID = ? ";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			int i = pstm.executeUpdate();
			
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
