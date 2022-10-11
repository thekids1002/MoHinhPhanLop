package BLL;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.LectureDAL;
import DAL.StudentDAL;
import DTO.Person;

public class LectureBLL {
	LectureDAL lectureDAL;
	
	public LectureBLL() {
		super();
		lectureDAL = new LectureDAL();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Person> readLectures() {
		return lectureDAL.readLecture();
	}

	public ArrayList<Person> searchByID(int ID) {
		return lectureDAL.searchByID(ID);
	}

	public ArrayList<Person> searchByName(String name) {
		return lectureDAL.searchByName(name);
	}

	public ArrayList<Person> loadLecturesByPage(int page) {
		return lectureDAL.loadLecturesByPage(page);
	}

	public boolean editLecture(Person person) {

		return lectureDAL.editLecture(person);
	}

	public boolean addLecture(Person person) {

		return lectureDAL.addLecture(person);
	}

	public boolean deleteLecture(int id) {
		if(lectureDAL.checkLectureInContrusctor(id)) {
			return false;
		}
		return lectureDAL.deleteLecture(id);
	}
	public static void main(String[] args) {
		System.out.println(new LectureBLL().loadLecturesByPage(1));
	}
}
