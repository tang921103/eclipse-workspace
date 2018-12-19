package bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		System.out.println("1");
		addUser();
	}
	public static void  addUser() {
		Configuration config = new Configuration();
		config.configure("hibernate.config.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		User user = new User();
		user.setUsername("adming");
		user.setPassword("124");
		user.setSalary(2000.20f);
		session.save(user);
		tr.commit();
		session.close();
	}
}
