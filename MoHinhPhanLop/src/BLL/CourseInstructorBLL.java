package BLL;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import DAL.CourseDAL;
import DAL.CourseInstructorDAL;
import DTO.Course;
import DTO.CourseInstructor;

public class CourseInstructorBLL {

	public static ArrayList<DTO.CourseInstructor> readAllCourseInstructor() {
		return new CourseInstructorDAL().readCourseInstructors();
	}
	
	public static boolean addCourseInstructor(CourseInstructor instructor) {
		if (instructor.getCourseID() < 0) {
			JOptionPane.showMessageDialog(null, "Mã khóa học không được để trống ");
			return false;
		}
		if (instructor.getPersonID() < 0) {
			JOptionPane.showMessageDialog(null, "Mã học viên không được để trống");
			return false;
		}
		return new CourseInstructorDAL().addCourseInstructor(instructor);
	}

	public static boolean editCourseInstructor(CourseInstructor instructor) {
		if (instructor.getCourseID() < 0) {
			JOptionPane.showMessageDialog(null, "Mã khóa học không được để trống ");
			return false;
		}
		if (instructor.getPersonID() < 0) {
			JOptionPane.showMessageDialog(null, "Mã học viên không được để trống");
			return false;
		}
		return new CourseInstructorDAL().editCourseInstructor(instructor);
	}

}
