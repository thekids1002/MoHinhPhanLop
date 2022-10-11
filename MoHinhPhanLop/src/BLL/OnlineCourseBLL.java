package BLL;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import DAL.OnlineCourseDAL;
import DTO.OnlineCourse;

public class OnlineCourseBLL {

	private OnlineCourseDAL onlineCourseDAL;

	public OnlineCourseBLL() {
		super();
		onlineCourseDAL = new OnlineCourseDAL();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<OnlineCourse> readAllCourseOnline() {
		return onlineCourseDAL.readOnlineCourses();
	}

	public ArrayList<OnlineCourse> loadCourseByPage(int pgae) {
		return onlineCourseDAL.loadOnlineCourseByPage(pgae);
	}

	public boolean addOnlineCourse(OnlineCourse course) {

		return onlineCourseDAL.addOnlineCourse(course);
	}

	public boolean editOnlineCourse(OnlineCourse course) {

		return onlineCourseDAL.editOnlineCourse(course);
	}

	public boolean deleteOnlineCourse(int id) {
		return onlineCourseDAL.deleteOnlineCourse(id);
	}

	public ArrayList<OnlineCourse> searchOnlineCourse(int id) {
		return onlineCourseDAL.searchOnlineByID(id);
	}
}
