package cn.tedu;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProperDemo {
	public static void main(String[] args) {
		Properties prop = new Properties();
		InputStream ips = ProperDemo.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			prop.load(ips);
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			System.out.println(driver);
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
