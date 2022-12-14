package DTO;

import java.util.Date;

public class Department {
	private int DepartmentID;
	private String Name;
	private Double Budget;
	private Date StartDate;
	private int Administrator;

	public int getDepartmentID() {
		return DepartmentID;
	}

	public void setDepartmentID(int departmentID) {
		DepartmentID = departmentID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Double getBudget() {
		return Budget;
	}

	public void setBudget(Double budget) {
		Budget = budget;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public int getAdministrator() {
		return Administrator;
	}

	public void setAdministrator(int administrator) {
		Administrator = administrator;
	}

	@Override
	public String toString() {
		return DepartmentID + " - " + Name;
	}

	public Department(int departmentID, String name, Double budget, Date startDate, int administrator) {
		super();
		DepartmentID = departmentID;
		Name = name;
		Budget = budget;
		StartDate = startDate;
		Administrator = administrator;
	}

	public Department() {
		super();
	}
}
