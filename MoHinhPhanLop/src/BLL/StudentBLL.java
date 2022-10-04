package BLL;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.LectureDAL;
import DAL.StudentDAL;
import DTO.Person;

public class StudentBLL {
	public static StudentBLL gI;

	public static StudentBLL gI() {
		if (gI == null) {
			gI = new StudentBLL();
		}
		return gI;
	}

	public ArrayList<Person> readStudens() {
		return StudentDAL.gI().readStudents();
	}

	public ArrayList<Person> loadStudentsByPage(int page){
		return StudentDAL.gI().loadStudentsByPage(page);
	}
	public ArrayList<Person> searchByID(int ID) {
		return StudentDAL.gI().searchByID(ID);
	}

	public ArrayList<Person> searchByName(String name) {
		return StudentDAL.gI().searchByName(name);
	}

	public boolean editStudents(Person person) {
		
		return StudentDAL.gI().editStudent(person);
	}

	public boolean addStudents(Person person) {
		return StudentDAL.gI().addStudent(person);
	}
	public boolean deleteLecture(int id) {
		
		return StudentDAL.gI().deleteStudent(id);
	}

}
