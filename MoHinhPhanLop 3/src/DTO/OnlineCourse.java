package DTO;

public class OnlineCourse {
	private int CourseID;
	private String url;

	public int getCourseID() {
		return CourseID;
	}

	public void setCourseID(int courseID) {
		CourseID = courseID;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "OnlineCourse [CourseID=" + CourseID + ", url=" + url + "]";
	}

	public OnlineCourse(int courseID, String url) {
		super();
		CourseID = courseID;
		this.url = url;
	}

	public OnlineCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
}
