package DTO;

import java.util.Date;

public class Person {
	private int ID;
	private String Lastname;
	private String Firstname;
	private Date HireDate;
	private Date EnrollmentDate;
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getLastname() {
		return Lastname;
	}

	@Override
	public String toString() {
		return ID + " - " + Firstname + " " + Lastname;
	}

	public Person() {
		super();
	}

	public Person(int iD, String lastname, String firstname, Date hireDate, Date enrollmentDate) {
		super();
		ID = iD;
		Lastname = lastname;
		Firstname = firstname;
		HireDate = hireDate;
		EnrollmentDate = enrollmentDate;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public Date getHireDate() {
		return HireDate;
	}

	public void setHireDate(Date hireDate) {
		HireDate = hireDate;
	}

	public Date getEnrollmentDate() {
		return EnrollmentDate;
	}

	public void setEnrollmentDate(Date enrollmentDate) {
		EnrollmentDate = enrollmentDate;
	}

}
