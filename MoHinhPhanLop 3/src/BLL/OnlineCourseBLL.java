package BLL;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import DAL.OnlineCourseDAL;
import DTO.OnlineCourse;

public class OnlineCourseBLL {
	public ArrayList<OnlineCourse> readAllCourseOnline() {
		return new OnlineCourseDAL().readOnlineCourses();
	}

	public boolean addOnlineCourse(OnlineCourse course) {
		if (course.getUrl().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Không được để trống URL");
			return false;
		}
		if (course.getCourseID() < 0) {
			JOptionPane.showMessageDialog(null, "Lỗi không có ID");
			return false;
		}
		return new OnlineCourseDAL().addOnlineCourse(course);
	}

	public boolean editOnlineCourse(OnlineCourse course) {
		if (course.getUrl().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Không được để trống URL");
			return false;
		}
		if (course.getCourseID() < 0) {
			JOptionPane.showMessageDialog(null, "Lỗi không có ID");
			return false;
		}
		return new OnlineCourseDAL().editOnlineCourse(course);
	}
}
