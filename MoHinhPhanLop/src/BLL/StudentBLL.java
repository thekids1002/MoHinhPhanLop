package BLL;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.LectureDAL;
import DAL.StudentDAL;
import DTO.Person;

public class StudentBLL {
	
	StudentDAL studentDAL;
	
	public StudentBLL() {
		super();
		studentDAL = new StudentDAL();
		// TODO Auto-generated constructor stubS
	}

	public ArrayList<Person> readStudens() {
		return studentDAL.readStudents();
	}

	public ArrayList<Person> loadStudentsByPage(int page){
		return studentDAL.loadStudentsByPage(page);
	}
	
	// tìm kiếm theo mã
	public ArrayList<Person> searchByID(int ID) {
		return studentDAL.searchByID(ID);
	}
	// tìm kiếm theo tên
	public ArrayList<Person> searchByName(String name) {
		return studentDAL.searchByName(name);
	}

	public boolean editStudents(Person person) {
		
		return studentDAL.editStudent(person);
	}

	public boolean addStudents(Person person) {
		return studentDAL.addStudent(person);
	}
	
	public boolean deleteLecture(int id) {
		
		return studentDAL.deleteStudent(id);
	}

}
