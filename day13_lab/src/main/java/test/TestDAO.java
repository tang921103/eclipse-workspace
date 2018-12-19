package test;

import java.sql.SQLException;
import java.util.List;

import dao.UserDAO;
import entity.User;

public class TestDAO {

	public static void main(String[] args) throws SQLException {
		UserDAO dao = new UserDAO();
		List<User> users = dao.findAll();
		System.out.println(users);
	}
}
