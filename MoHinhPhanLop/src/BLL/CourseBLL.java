package BLL;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.CourseDAL;
import DTO.Course;

public class CourseBLL {
	public static ArrayList<DTO.Course> readAllCourse() {
		return new CourseDAL().readCourses();
	}

	public static ArrayList<DTO.Course> readOnsiteCourse() {
		return new CourseDAL().readOnsiteCourse();
	}

	public static ArrayList<DTO.Course> readOnsiteCoursePage(int Page) {
		return new CourseDAL().loadOnsiteCourses(Page);
	}

	public static ArrayList<DTO.Course> readOnlineCoursePage(int Page) {
		return new CourseDAL().loadOnlineCourses(Page);
	}
	
	public static ArrayList<DTO.Course> searchOnline(int ID) {
		return new CourseDAL().searchOnlineByID(ID);
	}
	public static ArrayList<DTO.Course> searchOnsite(int ID) {
		return new CourseDAL().searchOnsiteByID(ID);
	}

	public static ArrayList<DTO.Course> readOnlineCourse() {
		return new CourseDAL().readOnlineCourse();
	}

	public static int addCourse(Course course) {
		if (course.getTitle().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Tên khoá học không được để trống");
			return -1;
		}
		if (course.getDepartmentID() < 0) {
			JOptionPane.showMessageDialog(null, "Tên khoa không được để trống");
			return -1;
		}
		return new CourseDAL().addCourse(course);
	}

	public static boolean editCourse(Course course) {
		if (course.getTitle().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Tên khoá học không được để trống");
			return false;
		}
		if (course.getDepartmentID() < 0) {
			JOptionPane.showMessageDialog(null, "Tên khoa không được để trống");
			return false;
		}
		return new CourseDAL().editCourse(course);
	}

	public boolean deleteCourse(int ID) {
		return new CourseDAL().deleteCourse(ID);
	}
}
