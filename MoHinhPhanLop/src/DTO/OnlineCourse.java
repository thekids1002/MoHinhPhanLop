package DTO;

public class OnlineCourse  extends Course {
	
	public OnlineCourse(int courseID, String title, int credits, int departmentID, String url) {
		super(courseID, title, credits, departmentID);
		this.url = url;
	}

	private String url;

	
	@Override
	public String toString() {
		return "OnlineCourse [CourseID=" + getCourseID() + ", url=" + url + "]";
	}



	public String getUrl() {
		return url;
	}


	public OnlineCourse( String url) {
		this.url = url;
	}



	public void setUrl(String url) {
		this.url = url;
	}

	
}
