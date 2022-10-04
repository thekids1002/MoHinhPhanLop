package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.Course;
import DTO.OnlineCourse;
import DTO.OnsiteCourse;
import GUI.Contrains;

public class CourseDAL {
	Connection conn;

	public CourseDAL() {
		super();

		conn = DBConnect.getConnection();
	}

	public ArrayList<Course> readCourses() {
		try {

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
			
			return listCourses;
		} catch (Exception e) {
		}
		return null;
	}

	public ArrayList<Course> readOnsiteCourse() {
		try {

			Statement stmt = conn.createStatement();
			ArrayList<Course> listCourses = new ArrayList<>();
			String query = "SELECT course.CourseID, course.Title, course.Credits, course.DepartmentID,"
					+ " onsitecourse.Location, onsitecourse.Days, onsitecourse.Time "
					+ "FROM `course` , onsitecourse "
					+ "WHERE course.CourseID = onsitecourse.CourseID";
			ResultSet rs = stmt.executeQuery(query);
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
					OnsiteCourse onsiteCourse = new OnsiteCourse(idCourse, location, Days, time);
					Course course = new Course(idCourse, title, credit, department, onsiteCourse);
					listCourses.add(course);
				}
			}
			
			return listCourses;
		} catch (Exception e) {
		}
		return null;
	}

	public ArrayList<Course> loadOnsiteCourses(int page) {
		try {
			int num_record = Contrains.pagesize;
			ArrayList<Course> list = this.readOnsiteCourse();
			int size = list.size();
			System.out.println(size);
			int from, to;
			from = (page - 1) * num_record;
			to = page * num_record;
			List a = list.subList(from, Math.min(to, size));
			return list = new ArrayList<Course>(a);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Course> loadOnlineCourses(int page) {
		try {
			int num_record = Contrains.pagesize;
			ArrayList<Course> list = this.readOnlineCourse();
			int size = list.size();
			System.out.println(size);
			int from, to;
			from = (page - 1) * num_record;
			to = page * num_record;
			List a = list.subList(from, Math.min(to, size));
			return list = new ArrayList<Course>(a);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Course> readOnlineCourse() {
		try {

			Statement stmt = conn.createStatement();
			ArrayList<Course> listCourses = new ArrayList<>();
			String query = "SELECT course.CourseID, course.Title, course.Credits, course.DepartmentID, onlinecourse.url FROM `course` , "
					+ "onlinecourse WHERE course.CourseID = onlinecourse.CourseID;";
			ResultSet rs = stmt.executeQuery(query);
			if (rs != null) {
				int i = 1;
				while (rs.next()) {
					int idCourse = rs.getInt("CourseID");
					String title = rs.getString("Title");
					int credit = rs.getInt("Credits");
					int department = rs.getInt("DepartmentID");
					String url = rs.getString("url");
					OnlineCourse onlineCourse = new OnlineCourse(idCourse, url);
					Course course = new Course(idCourse, title, credit, department, onlineCourse);
					listCourses.add(course);
				}
			}
			
			return listCourses;
		} catch (Exception e) {
		}
		return null;
	}

	public int addCourse(Course course) {
		try {
			String sql = "INSERT INTO `course`( `Title`, `Credits`, `DepartmentID`) VALUES (?,?,?)";

			PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, course.getTitle());
			pstm.setInt(2, course.getCredits());
			pstm.setInt(3, course.getDepartmentID());
			pstm.execute();
			ResultSet rs = pstm.getGeneratedKeys();
			int generatedKey = 0;
			if (rs.next()) {
				generatedKey = rs.getInt(1);
			}
			
			return generatedKey;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public boolean editCourse(Course c) {
		try {
			String sql = "UPDATE `course` SET `Title`= ? ,`Credits`= ? ,`DepartmentID`= ? WHERE CourseID = ? ";

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, c.getTitle());
			pstm.setInt(2, c.getCredits());
			pstm.setInt(3, c.getDepartmentID());
			pstm.setInt(4, c.getCourseID());
			int i = pstm.executeUpdate();
			
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteCourse(int idCourse) {
		try {
			String sql = "DELETE FROM `course` WHERE CourseID = ? ";

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idCourse);
			int i = pstm.executeUpdate();
			
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Course> searchOnsiteByID(int ID) {
		try {

			Statement stmt = conn.createStatement();
			ArrayList<Course> listCourses = new ArrayList<>();
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
					OnsiteCourse onsiteCourse = new OnsiteCourse(idCourse, location, Days, time);
					Course course = new Course(idCourse, title, credit, department, onsiteCourse);
					listCourses.add(course);
				}
			}
			
			return listCourses;
		} catch (Exception e) {
		}
		return null;
	}

	public ArrayList<Course> searchOnlineByID(int ID) {
		try {

			ArrayList<Course> listCourses = new ArrayList<>();
			String query = "SELECT course.CourseID, course.Title, course.Credits, course.DepartmentID,"
					+ " onlinecourse.url FROM `course` , onlinecourse WHERE course.CourseID = ?";
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
					String url = rs.getString("url");
					OnlineCourse onlineCourse = new OnlineCourse(idCourse, url);
					Course course = new Course(idCourse, title, credit, department, onlineCourse);
					listCourses.add(course);
				}
			}
			
			return listCourses;
		} catch (Exception e) {
		}
		return null;
	}

	public static void main(String[] args) {
		CourseDAL c1 = new CourseDAL();
		// c1.addCourse(course);
		// c1.deleteCourse(1111);
		System.out.println(c1.searchOnlineByID(1045));
	}

}
