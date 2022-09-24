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

	public static ArrayList<DTO.Course> readOnlineCourse() {
		return new CourseDAL().readOnlineCourse();
	}

	public static boolean addCourse(Course course) {
		if (course.getTitle().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Tên khoá học không được để trống");
			return false;
		}
		if (course.getDepartmentID() < 0) {
			JOptionPane.showMessageDialog(null, "Tên khoa không được để trống");
			return false;
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
}
