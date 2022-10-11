package BLL;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.CourseDAL;
import DTO.Course;
import DTO.OnsiteCourse;

public class CourseBLL {
	
	CourseDAL courseDAL;
	
	public CourseBLL() {
		courseDAL = new CourseDAL();
	}

	public  ArrayList<DTO.Course> readAllCourse() {
		return courseDAL.readCourses();
	}

//	public  ArrayList<DTO.Course> readOnsiteCourse() {
//		return courseDAL.readOnsiteCourse();
//	}
//
//	public  ArrayList<DTO.Course> readOnsiteCoursePage(int Page) {
//		return new  CourseDAL().loadOnsiteCourses(Page);
//	}
//
//	public  ArrayList<DTO.Course> readOnlineCoursePage(int Page) {
//		return courseDAL.loadOnlineCourses(Page);
//	}
//	
//	public  ArrayList<DTO.Course> searchOnline(int ID) {
//		return courseDAL.searchOnlineByID(ID);
//	}
//	
//	public  ArrayList<DTO.Course> searchOnsite(int ID) {
//		return courseDAL.searchOnsiteByID(ID);
//	}
//
//	public  ArrayList<DTO.Course> readOnlineCourse() {
//		return courseDAL.readOnlineCourse();
//	}

	public  int addCourse(Course course) {
		if (course.getTitle().isEmpty()) {
			return -1;
		}
		if (course.getDepartmentID() < 0) {
			
			return -2;
		}
		return courseDAL.addCourse(course);
	}

	public  boolean editCourse(Course course) {
		if (course.getTitle().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Tên khoá học không được để trống");
			return false;
		}
		if (course.getDepartmentID() < 0) {
			JOptionPane.showMessageDialog(null, "Tên khoa không được để trống");
			return false;
		}
		return courseDAL.editCourse(course);
	}

	public boolean deleteCourse(int ID) {
		return courseDAL.deleteCourse(ID);
	}


}
