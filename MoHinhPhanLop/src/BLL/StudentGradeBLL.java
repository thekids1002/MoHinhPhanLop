package BLL;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import DAL.StudentDAL;
import DAL.StudentGradeDAL;
import DTO.StudentGrade;

public class StudentGradeBLL {

	StudentGradeDAL studentGradeDAL;

	public StudentGradeBLL() {
		super();
		studentGradeDAL = new StudentGradeDAL();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<DTO.StudentGrade> readAllGrade() {
		return studentGradeDAL.readStudentGrades();
	}

	public ArrayList<DTO.StudentGrade> searchByStudentID(int ID) {
		return studentGradeDAL.searchGradeByStudentID(ID);
	}

	public ArrayList<DTO.StudentGrade> LoaddGradeByPage(int page) {
		return studentGradeDAL.loadGardeByPage(page);
	}

	public boolean addGrade(StudentGrade grade) {

		return studentGradeDAL.addStudentGrade(grade);
	}

	public boolean editGrade(StudentGrade grade) {
		return studentGradeDAL.editStudentGrade(grade);
	}

	public boolean deleteGrade(int id) {
		return studentGradeDAL.deleteStudentGrade(id);
	}
}
