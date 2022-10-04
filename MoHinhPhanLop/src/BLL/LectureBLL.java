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

	public ArrayList<Person> loadLecturesByPage(int page) {
		return LectureDAL.gI().loadLecturesByPage(page);
	}

	public boolean editLecture(Person person) {

		return LectureDAL.gI().editLecture(person);
	}

	public boolean addLecture(Person person) {

		return LectureDAL.gI().addLecture(person);
	}

	public boolean deleteLecture(int id) {
		
		return LectureDAL.gI().deleteLecture(id);
	}
	public static void main(String[] args) {
		System.out.println(new LectureBLL().loadLecturesByPage(1));
	}
}
