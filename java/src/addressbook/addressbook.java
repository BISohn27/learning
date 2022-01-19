package addressbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class addressbook {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
	public void createTable() {
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE ADDRESSBOOK(NUMBER INT PRIMARY KEY AUTO_INCREMENT,DEPARTMENT VARCHAR(100) NOT NULL, NAME VARCHAR(100) NOT NULL,POSITION VARCHAR(100) NOT NULL, PHONE VARCHAR(50) NOT NULL");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {}
		}
	}
	
	public void insert(String department, String name, String position, String phone ) {
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("INSERT INTO ADDRESSBOOK VALUES(?,?,?,?)");
			pstmt.setString(1, department);
			pstmt.setString(2, name);
			pstmt.setString(3, position);
			pstmt.setString(4, phone);
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {}
		}
	}
	
	public void updateDepartment(String department,String name) {
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("UPDATE ADDRESSBOOK SET DEPARTMENT = ? WHERE NAME = ?");
			pstmt.setString(1, department);
			pstmt.setString(2, name);
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {}
		}
	}
	
	public void updatePosition(String position,String name) {
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("UPDATE ADDRESSBOOK SET POSITION = ? WHERE NAME = ?");
			pstmt.setString(1, position);
			pstmt.setString(2, name);
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {}
		}
	}
	
	public void updatePhone(String phone,String name) {
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("UPDATE ADDRESSBOOK SET PHONE = ? WHERE NAME = ?");
			pstmt.setString(1, phone);
			pstmt.setString(2, name);
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {}
		}
	}
	
	public void delete(String name, String phone) {
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("DELETE FROM ADDRESSBOOK WHERE NAME = ? AND PHONE = ?");
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {}
		}
	}
}
