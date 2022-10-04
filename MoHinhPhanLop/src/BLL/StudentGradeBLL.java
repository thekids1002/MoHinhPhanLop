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
	public static ArrayList<DTO.StudentGrade> searchByStudentID(int ID) {
		return new StudentGradeDAL().gI().searchGradeByStudentID(ID);
	}
	
	public static ArrayList<DTO.StudentGrade> LoaddGradeByPage(int page) {
		return new StudentGradeDAL().gI().loadGardeByPage(page);
	}

	public static boolean addGrade(StudentGrade grade) {
		
		return new StudentGradeDAL().gI().addStudentGrade(grade);
	}

	public static boolean editGrade(StudentGrade grade) {
		return new StudentGradeDAL().gI().editStudentGrade(grade);
	}
	
	public static boolean deleteGrade (int id) {
		return StudentGradeDAL.gI().deleteStudentGrade(id);
	}
}
