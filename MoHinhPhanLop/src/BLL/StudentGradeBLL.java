package BLL;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import DAL.StudentGradeDAL;
import DTO.StudentGrade;

public class StudentGradeBLL {

	public static ArrayList<DTO.StudentGrade> readAllGrade() {
		return new StudentGradeDAL().readStudentGrades();
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
		return new StudentGradeDAL().addStudentGrade(grade);
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
		return new StudentGradeDAL().editStudentGrade(grade);
	}
}
