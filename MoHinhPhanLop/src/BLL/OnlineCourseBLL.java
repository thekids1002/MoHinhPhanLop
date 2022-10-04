package BLL;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import DAL.OnlineCourseDAL;
import DTO.OnlineCourse;

public class OnlineCourseBLL {
	public ArrayList<OnlineCourse> readAllCourseOnline() {
		return new OnlineCourseDAL().readOnlineCourses();
	}
	public ArrayList<OnlineCourse> loadCourseByPage(int pgae) {
		return new OnlineCourseDAL().loadOnlineCourseByPage(pgae);
	}
	public boolean addOnlineCourse(OnlineCourse course) {
		
		return new OnlineCourseDAL().addOnlineCourse(course);
	}
	
	

	public boolean editOnlineCourse(OnlineCourse course) {
		
		return new OnlineCourseDAL().editOnlineCourse(course);
	}
	
	public boolean deleteOnlineCourse(int id) {
		return new OnlineCourseDAL().deleteOnlineCourse(id);
	}
}
