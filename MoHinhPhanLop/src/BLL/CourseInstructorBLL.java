package BLL;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import DAL.CourseDAL;
import DAL.CourseInstructorDAL;
import DAL.StudentDAL;
import DTO.Course;
import DTO.CourseInstructor;

public class CourseInstructorBLL {

	public static CourseInstructorBLL gI;

	public static CourseInstructorBLL gI() {
		if (gI == null) {
			gI = new CourseInstructorBLL();
		}
		return gI;
	}
	
	public static ArrayList<DTO.CourseInstructor> readAllCourseInstructor() {
		return new CourseInstructorDAL().gI().readCourseInstructors();
	}
	
	public static boolean addCourseInstructor(CourseInstructor instructor) {
		if (instructor.getCourseID() < 0) {
			JOptionPane.showMessageDialog(null, "Mã khóa học không được để trống ");
			return false;
		}
		if (instructor.getPersonID() < 0) {
			JOptionPane.showMessageDialog(null, "Mã giảng viên không được để trống");
			return false;
		}
		return new CourseInstructorDAL().gI().addCourseInstructor(instructor);
	}

	public static boolean editCourseInstructor(CourseInstructor instructor) {
		if (instructor.getCourseID() < 0) {
			JOptionPane.showMessageDialog(null, "Mã khóa học không được để trống ");
			return false;
		}
		if (instructor.getPersonID() < 0) {
			JOptionPane.showMessageDialog(null, "Mã giảng viên không được để trống");
			return false;
		}
		return new CourseInstructorDAL().gI().editCourseInstructor(instructor);
	}
	
	public boolean deleteCourseInstructor(int idCourse, int idPerson) {
		if (idCourse < 0 || idPerson < 0) {
			return false;
		}
		return new CourseInstructorDAL().gI().deleteCourseInstructor(idCourse, idPerson);
	}

}
