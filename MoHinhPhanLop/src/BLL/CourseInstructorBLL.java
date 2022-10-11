package BLL;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import DAL.CourseDAL;
import DAL.CourseInstructorDAL;
import DAL.StudentDAL;
import DTO.Course;
import DTO.CourseInstructor;

public class CourseInstructorBLL {

	CourseInstructorDAL courseInstructorDAL;
	
	public CourseInstructorBLL() {
		super();
		courseInstructorDAL = new CourseInstructorDAL();
		// TODO Auto-generated constructor stub
	}

	public  ArrayList<DTO.CourseInstructor> searchByCourseID(int ID) {
		return courseInstructorDAL.searchByCourseID(ID);
	}
	
	public  ArrayList<DTO.CourseInstructor> searchByLectureID(int ID) {
		return courseInstructorDAL.searchByLectureID(ID);
	}

	public  ArrayList<DTO.CourseInstructor> readAllCourseInstructor() {
		return courseInstructorDAL.readCourseInstructors();
	}

	public  ArrayList<DTO.CourseInstructor> loadCourseInstructorByPage(int page) {
		return courseInstructorDAL.loadCourseInstructorByPage(page);
	}

	public  boolean addCourseInstructor(CourseInstructor instructor) {
		
		return courseInstructorDAL.addCourseInstructor(instructor);
	}

	public  boolean editCourseInstructor(CourseInstructor instructor, CourseInstructor instructor2) {
		
		return courseInstructorDAL.editCourseInstructor(instructor, instructor2);
	}

	public boolean deleteCourseInstructor(int idCourse, int idPerson) {
	
		return courseInstructorDAL.deleteCourseInstructor(idCourse, idPerson);
	}

}
