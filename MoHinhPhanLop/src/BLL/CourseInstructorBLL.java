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

	public static ArrayList<DTO.CourseInstructor> searchByCourseID(int ID) {
		return new CourseInstructorDAL().searchByCourseID(ID);
	}
	
	public static ArrayList<DTO.CourseInstructor> searchByLectureID(int ID) {
		return new CourseInstructorDAL().searchByLectureID(ID);
	}

	public static ArrayList<DTO.CourseInstructor> readAllCourseInstructor() {
		return new CourseInstructorDAL().readCourseInstructors();
	}

	public static ArrayList<DTO.CourseInstructor> loadCourseInstructorByPage(int page) {
		return new CourseInstructorDAL().loadCourseInstructorByPage(page);
	}

	public static boolean addCourseInstructor(CourseInstructor instructor) {
		
		return new CourseInstructorDAL().addCourseInstructor(instructor);
	}

	public static boolean editCourseInstructor(CourseInstructor instructor, CourseInstructor instructor2) {
		
		return new CourseInstructorDAL().editCourseInstructor(instructor, instructor2);
	}

	public boolean deleteCourseInstructor(int idCourse, int idPerson) {
	
		return new CourseInstructorDAL().deleteCourseInstructor(idCourse, idPerson);
	}

}
