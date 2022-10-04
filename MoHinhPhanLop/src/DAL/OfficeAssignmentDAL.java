package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import DTO.OfficeAssignment;
import DTO.Person;

public class OfficeAssignmentDAL {
	Connection conn;

	public OfficeAssignmentDAL() {
		super();
		conn = DBConnect.getConnection();
	}

	public ArrayList<OfficeAssignment> readOfficeAssignments() {
		try {

			Statement stmt = conn.createStatement();
			ArrayList<OfficeAssignment> listOfficeAssignments = new ArrayList<>();
			String query = "SELECT * FROM `officeassignment` ";
			ResultSet rs = stmt.executeQuery(query);
			if (rs != null) {
				int i = 1;
				while (rs.next()) {
					int id = rs.getInt("InstructorID");
					String location = rs.getString("Location");
					Date timestamp = rs.getDate("Timestamp");
					OfficeAssignment officeassignment = new OfficeAssignment(id, location, timestamp);
					listOfficeAssignments.add(officeassignment);
				}
			}
			
			return listOfficeAssignments;
		} catch (Exception e) {
		}
		return null;
	}

	public boolean addOfficeAssignment(OfficeAssignment o) {
		try {
			String sql = "INSERT INTO `officeassignment`( `InstructorID`, `Location`, `Timestamp` ) VALUES (?,?,?)";

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, o.getInstructorID());
			pstm.setString(2, o.getLocation());
			pstm.setDate(3, new java.sql.Date(o.getTimestamp().getTime()));
			int i = pstm.executeUpdate();
			
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean editOfficeAssignment(OfficeAssignment s) {
		try {
			String sql = "UPDATE `officeassignment` SET `Location`= ? ,`Timestamp`= ? WHERE InstructorID = ?";

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, s.getLocation());
			pstm.setDate(2, new java.sql.Date(s.getTimestamp().getTime()));
			pstm.setInt(3, s.getInstructorID());
			int i = pstm.executeUpdate();
			
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteOfficeAssignment(int id) {
		try {
			String sql = "DELETE FROM `officeassignment` WHERE InstructorID = ? ";

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			int i = pstm.executeUpdate();
			
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
