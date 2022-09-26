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

	public ArrayList<Person> searchByID(int ID) {
		return StudentDAL.gI().searchByID(ID);
	}

	public ArrayList<Person> searchByName(String name) {
		return StudentDAL.gI().searchByName(name);
	}

	public boolean editStudents(Person person) {
		if (person.getFirstname().isEmpty() || person.getLastname().isBlank()) {
			JOptionPane.showMessageDialog(null, "Bạn không được để trống tên");
			return false;
		}
		if (person.getLastname().isEmpty() || person.getLastname().isBlank()) {
			JOptionPane.showMessageDialog(null, "Bạn không được để trống họ");
			return false;
		}
		if (person.getEnrollmentDate() == null) {
			JOptionPane.showMessageDialog(null, "Bạn không được để trống ngày đăng kí");
			return false;
		}
		return StudentDAL.gI().editStudent(person);
	}

	public boolean addStudents(Person person) {
		if (person.getFirstname().isEmpty() || person.getLastname().isBlank()) {
			JOptionPane.showMessageDialog(null, "Bạn không được để trống tên");
			return false;
		}
		if (person.getLastname().isEmpty() || person.getLastname().isBlank()) {
			JOptionPane.showMessageDialog(null, "Bạn không được để trống họ");
			return false;
		}
		if (person.getEnrollmentDate() == null) {
			JOptionPane.showMessageDialog(null, "Bạn không được để trống ngày đăng kí");
			return false;
		}
		return StudentDAL.gI().addStudent(person);
	}

	public boolean deleteLecture(int id) {
		if (id < 0) {
			return false;
		}
		return StudentDAL.gI().deleteStudent(id);
	}

}
