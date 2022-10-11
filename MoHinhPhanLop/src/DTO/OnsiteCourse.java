package DTO;

import java.sql.Time;

public class OnsiteCourse extends Course {

	private String Location;
	private String Days;

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public OnsiteCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OnsiteCourse(int courseID, String title, int credits, int departmentID) {
		super(courseID, title, credits, departmentID);
		// TODO Auto-generated constructor stub
	}

	public OnsiteCourse(int courseID, String title, int credits, int departmentID, String location, String days,
			java.sql.Time time) {
		super(courseID, title, credits, departmentID);
		Location = location;
		Days = days;
		Time = time;
	}


	public String getDays() {
		return Days;
	}

	public void setDays(String days) {
		Days = days;
	}

	public Time getTime() {
		return Time;
	}

	public void setTime(Time time) {
		Time = time;
	}

	private Time Time;

	@Override
	public String toString() {
		return "OnsiteCourse [CourseID=" + getCourseID() + ", Location=" + Location + ", Days=" + Days + ", Time="
				+ Time + "]";
	}

}
