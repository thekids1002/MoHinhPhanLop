package DTO;

import java.util.Date;

public class OfficeAssignment {
	private int InstructorID;
	private String Location;
	private Date Timestamp;

	public int getInstructorID() {
		return InstructorID;
	}

	public void setInstructorID(int instructorID) {
		InstructorID = instructorID;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public Date getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(Date timestamp) {
		Timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "OfficeAssignment [InstructorID=" + InstructorID + ", Location=" + Location + ", Timestamp=" + Timestamp
				+ "]";
	}

	public OfficeAssignment(int instructorID, String location, Date timestamp) {
		super();
		InstructorID = instructorID;
		Location = location;
		Timestamp = timestamp;
	}

	public OfficeAssignment() {
		super();
	}

}
