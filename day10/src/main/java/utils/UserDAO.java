package utils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	public List<User> showAll() throws SQLException {
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql = "select * from users";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				User u = new User();
				u.setId(id);
				u.setUsername(username);
				u.setPassword(password);
				u.setEmail(email);
				users.add(u);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e ;
		}finally {
			DBUtils.close(rs, ps, conn);
		}
	}
	public void add(User u) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql = "insert into users values(null,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3,u.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
		DBUtils.close(rs, ps, conn);
		}
	}
	public void delete(User u ) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql = "delete from users where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(rs, ps, conn);
		}
	}
	public User find(User u) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql = "select * from users where username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,u.getUsername());
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				return user;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		
	}
}
