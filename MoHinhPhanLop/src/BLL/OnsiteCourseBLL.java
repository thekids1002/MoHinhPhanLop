package BLL;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.OnsiteCourseDAL;
import DTO.OnsiteCourse;

public class OnsiteCourseBLL {

	OnsiteCourseDAL onsiteCourseDAL;

	public ArrayList<OnsiteCourse> readAllOnsiteCourses() {
		return onsiteCourseDAL.readOnsiteCourses();
	}

	public ArrayList<OnsiteCourse> loadOnsiteCoursesByPage(int page) {
		return onsiteCourseDAL.loadOnsiteCoursesByPage(page);
	}
	
	public OnsiteCourseBLL() {
		super();
		onsiteCourseDAL = new OnsiteCourseDAL();
		// TODO Auto-generated constructor stub
	}

	public boolean addOnSiteCourse(OnsiteCourse course) {

		return onsiteCourseDAL.addOnsiteCourse(course);

	}
	
	public  ArrayList<DTO.OnsiteCourse> searchOnline(int ID) {
	return onsiteCourseDAL.searchOnsiteByID(ID);
}

//	public boolean editOnSiteCourse(OnsiteCourse course) {
////		if (course.getDays().isEmpty() || course.getDays().isBlank()) {
////			JOptionPane.showMessageDialog(null, "Không được để trống ngày");
////			return false;
////		}
////		if (course.getLocation().isEmpty()) {
////			JOptionPane.showMessageDialog(null, "Không được để trống phòng học");
////			return false;
////		}
////		if (course.getTime() == null) {
////			JOptionPane.showMessageDialog(null, "Thời gian sai");
////			return false;
////		}
//		return onsiteCourseDAL.editOnsiteCourse(course);
//
//	}

	public boolean editOnSiteCourse(OnsiteCourse course) {
		return onsiteCourseDAL.editOnsiteCourse(course);
	}

	public boolean deleteSiteCourse(int id) {
		if(onsiteCourseDAL.checkCourseInContrusctor(id)) {
			return false;
		}
		return onsiteCourseDAL.deleteOnsiteCourse(id);
	}
}
