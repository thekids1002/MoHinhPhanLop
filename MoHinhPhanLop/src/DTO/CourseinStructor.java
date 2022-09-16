package DTO;

public class CourseinStructor {
	private int CourseID;
	private int PersonID;

	public int getCourseID() {
		return CourseID;
	}

	public void setCourseID(int courseID) {
		CourseID = courseID;
	}

	public int getPersonID() {
		return PersonID;
	}

	public void setPersonID(int personID) {
		PersonID = personID;
	}

	@Override
	public String toString() {
		return "CourseinStructor [CourseID=" + CourseID + ", PersonID=" + PersonID + "]";
	}

	public CourseinStructor(int courseID, int personID) {
		super();
		CourseID = courseID;
		PersonID = personID;
	}

	public CourseinStructor() {
		super();
		// TODO Auto-generated constructor stub
	}

}
