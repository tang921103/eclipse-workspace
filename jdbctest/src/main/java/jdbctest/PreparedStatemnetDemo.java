package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class PreparedStatemnetDemo {
	@Test
	public void demo1() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2","root","soft01");
			String sql = "insert into user values(null,?,?)";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, "王五");
			stat.setInt(2, 46);
			stat.executeUpdate();
			stat.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void demo2() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2","root","soft01");
			String sql = "select ? from user where id=?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1,"name");
			stat.setInt(2, 4);
			ResultSet rs = stat.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);
			}
		} catch (ClassNotFoundException e) {
						e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
