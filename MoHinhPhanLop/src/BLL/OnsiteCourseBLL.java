package BLL;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.OnsiteCourseDAL;
import DTO.OnsiteCourse;

public class OnsiteCourseBLL {
	public ArrayList<OnsiteCourse> readAllOnsiteCourses() {
		return new OnsiteCourseDAL().readOnsiteCourses();
	}
	
	public ArrayList<OnsiteCourse> loadOnsiteCourses(int page) {
		return new OnsiteCourseDAL().loadOnsiteCourses(page);
	}

	public boolean addOnSiteCourse(OnsiteCourse course) {
		
		return new OnsiteCourseDAL().addOnsiteCourse(course);

	}

	public boolean editOnSiteCourse(OnsiteCourse course) {
		if (course.getDays().isEmpty() || course.getDays().isBlank()) {
			JOptionPane.showMessageDialog(null, "Không được để trống ngày");
			return false;
		}
		if (course.getLocation().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Không được để trống phòng học");
			return false;
		}
		if (course.getTime() == null) {
			JOptionPane.showMessageDialog(null, "Thời gian sai");
			return false;
		}
		return new OnsiteCourseDAL().editOnsiteCourse(course);

	}
	public boolean deleteSiteCourse(int id) {
		return new OnsiteCourseDAL().deleteOnsiteCourse(id);
	}
}
