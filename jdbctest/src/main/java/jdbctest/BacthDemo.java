package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

public class BacthDemo {
	@Test
	public void batchDemo1() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2","root","soft01");
			String sql = "insert into user values(null,?,?)";
			PreparedStatement stat = conn.prepareStatement(sql);
			for(int i = 0;i<200;i++) {
				stat.setString(1, "name_"+i);
				stat.setInt(2, i);
				stat.addBatch();
				if(i%20==0) {
					stat.executeBatch();
					stat.clearBatch();
				}
			}
			stat.executeBatch();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	@Test
	public void batchDemo2() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2","root","soft01");
			String sql = "delete from user where id=?";
			PreparedStatement stat = conn.prepareStatement(sql);
			for(int i =0;i<65;i++) {
				stat.setInt(1, i+600);
				stat.addBatch();
				if(i%20==0) {
					stat.executeBatch();
					stat.clearBatch();
				}
			}
			stat.executeBatch();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
