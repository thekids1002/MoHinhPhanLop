package DTO;

import java.sql.Time;

public class OnsiteCourse {
	private int CourseID;
	private String Location;
	private String Days;
	private Time Time;

	public int getCourseID() {
		return CourseID;
	}

	public void setCourseID(int courseID) {
		CourseID = courseID;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
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

	public OnsiteCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OnsiteCourse(int courseID, String location, String days, java.sql.Time time) {
		super();
		CourseID = courseID;
		Location = location;
		Days = days;
		Time = time;
	}

	@Override
	public String toString() {
		return "OnsiteCourse [CourseID=" + CourseID + ", Location=" + Location + ", Days=" + Days + ", Time=" + Time
				+ "]";
	}

}
