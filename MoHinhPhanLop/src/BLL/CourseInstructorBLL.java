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
		
		return new CourseInstructorDAL().addCourseInstructor(instructor);
	}

	public static boolean editCourseInstructor(CourseInstructor instructor) {
		
		return new CourseInstructorDAL().editCourseInstructor(instructor);
	}

}
