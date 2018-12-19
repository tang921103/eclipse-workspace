package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.DBUtils;
/**
 * DAO类：
 * 			负责封装数据访问逻辑
 * @author soft01
 *
 */
public class UserDAO {
	/**
	 * 插入用户信息到数据库
	 * @throws SQLException 
	 */
	public void save(User user) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into t_user values(null,?,?,?)";
		try {
			conn = DBUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		
	}
	/**
	 * 将所有用户查询出来，每一个用户的信息对应一个User对象，然后返回一个由
	 * 这些User对象组成的集合。
	 * @return
	 * @throws SQLException 
	 */
	public List<User> findAll() throws SQLException{
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql = "select * from t_user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String uname = rs.getString("username");
				String pwd = rs.getString("password");
				String email = rs.getString("email");
				User user = new User();
				user.setId(id);
				user.setUname(uname);
				user.setPassword(pwd);
				user.setEmail(email);
				users.add(user); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return users;
	}
	/**
	 * 删除数据库中的数据
	 * @throws SQLException 
	 */
	public void delete(User user) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getConn();
			String sql = "delete from t_user where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(null, ps, conn);
		}
	}
}
