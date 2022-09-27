package BLL;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import DAL.StudentDAL;
import DAL.StudentGradeDAL;
import DTO.StudentGrade;

public class StudentGradeBLL {

	public static StudentGradeBLL gI;

	public static StudentGradeBLL gI() {
		if (gI == null) {
			gI = new StudentGradeBLL();
		}
		return gI;
	}
	
	public static ArrayList<DTO.StudentGrade> readAllGrade() {
		return new StudentGradeDAL().gI().readStudentGrades();
	}
	
	public static ArrayList<DTO.StudentGrade> LoaddGradeByPage(int page) {
		return new StudentGradeDAL().gI().loadGardeByPage(page);
	}

	public static boolean addGrade(StudentGrade grade) {
		if (grade.getGrade() > 10 || grade.getGrade() < 0) {
			JOptionPane.showMessageDialog(null, "Điểm không hợp lệ");
			return false;
		}
		if (grade.getCourseID() < 0) {
			JOptionPane.showMessageDialog(null, "Tên khóa học không được để trống");
			return false;
		}
		if (grade.getStudentID() < 0) {
			JOptionPane.showMessageDialog(null, "Tên học viên không được để trống");
			return false;
		}
		return new StudentGradeDAL().gI().addStudentGrade(grade);
	}

	public static boolean editGrade(StudentGrade grade) {
		if (grade.getGrade() > 10 || grade.getGrade() < 0) {
			JOptionPane.showMessageDialog(null, "Điểm không hợp lệ");
			return false;
		}
		if (grade.getCourseID() < 0) {
			JOptionPane.showMessageDialog(null, "Tên khóa học không được để trống");
			return false;
		}
		if (grade.getStudentID() < 0) {
			JOptionPane.showMessageDialog(null, "Tên học viên không được để trống");
			return false;
		}
		return new StudentGradeDAL().gI().editStudentGrade(grade);
	}
	
	public static boolean deleteGrade (int id) {
		if (id < 0) {
			return false;
		}
		return StudentGradeDAL.gI().deleteStudentGrade(id);
	}
}
