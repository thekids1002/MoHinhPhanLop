package BLL;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.LectureDAL;
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
