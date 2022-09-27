package BLL;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.LectureDAL;
import DAL.StudentDAL;
import DTO.Person;

public class LectureBLL {
	public static LectureBLL gI;

	public static LectureBLL gI() {
		if (gI == null) {
			gI = new LectureBLL();
		}
		return gI;
	}

	public ArrayList<Person> readLectures() {
		return LectureDAL.gI().readLecture();
	}

	public ArrayList<Person> searchByID(int ID) {
		return LectureDAL.gI().searchByID(ID);
	}

	public ArrayList<Person> searchByName(String name) {
		return LectureDAL.gI().searchByName(name);
	}
	
	public ArrayList<Person> loadLecturesByPage(int page){
		return LectureDAL.gI().loadStudentsByPage(page);
	}

	public boolean editLecture(Person person) {
		if (person.getFirstname().isEmpty() || person.getLastname().isBlank()) {
			JOptionPane.showMessageDialog(null, "Bạn không được để trống tên");
			return false;
		}
		if (person.getLastname().isEmpty() || person.getLastname().isBlank()) {
			JOptionPane.showMessageDialog(null, "Bạn không được để trống họ");
			return false;
		}
		if (person.getHireDate() == null) {
			JOptionPane.showMessageDialog(null, "Bạn không được để trống ngày thuê");
			return false;
		}
		return LectureDAL.gI().editLecture(person);
	}

	public boolean addLecture(Person person) {
		if (person.getFirstname().isEmpty() || person.getLastname().isBlank()) {
			JOptionPane.showMessageDialog(null, "Bạn không được để trống tên");
			return false;
		}
		if (person.getLastname().isEmpty() || person.getLastname().isBlank()) {
			JOptionPane.showMessageDialog(null, "Bạn không được để trống họ");
			return false;
		}
		if (person.getHireDate() == null) {
			JOptionPane.showMessageDialog(null, "Bạn không được để trống ngày thuê");
			return false;
		}
		return LectureDAL.gI().addLecture(person);
	}

	public boolean deleteLecture(int id) {
		if (id < 0) {
			return false;
		}
		return LectureDAL.gI().deleteLecture(id);
	}

}
