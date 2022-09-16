package DTO;

public class StudentGrade {
	private int EnrollmentID;
	private int CourseID;
	private int StudentID;
	private float Grade;

	public int getEnrollmentID() {
		return EnrollmentID;
	}

	public void setEnrollmentID(int enrollmentID) {
		EnrollmentID = enrollmentID;
	}

	public int getCourseID() {
		return CourseID;
	}

	public void setCourseID(int courseID) {
		CourseID = courseID;
	}

	public int getStudentID() {
		return StudentID;
	}

	public void setStudentID(int studentID) {
		StudentID = studentID;
	}

	public StudentGrade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentGrade(int enrollmentID, int courseID, int studentID, float grade) {
		super();
		EnrollmentID = enrollmentID;
		CourseID = courseID;
		StudentID = studentID;
		Grade = grade;
	}

	@Override
	public String toString() {
		return "StudentGrade [EnrollmentID=" + EnrollmentID + ", CourseID=" + CourseID + ", StudentID=" + StudentID
				+ ", Grade=" + Grade + "]";
	}

	public float getGrade() {
		return Grade;
	}

	public void setGrade(float grade) {
		Grade = grade;
	}

}
