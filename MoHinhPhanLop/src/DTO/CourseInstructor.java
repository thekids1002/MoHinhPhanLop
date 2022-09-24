package DTO;

public class CourseInstructor {
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

	public CourseInstructor(int courseID, int personID) {
		super();
		CourseID = courseID;
		PersonID = personID;
	}

	public CourseInstructor() {
		super();
		// TODO Auto-generated constructor stub
	}

}
