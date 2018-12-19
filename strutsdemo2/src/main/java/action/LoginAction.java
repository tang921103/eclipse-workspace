package action;

import bean.User;

public class LoginAction {
	private User user;

	public User getUser() {
		System.out.println("getUser");
		return user;
	}

	public void setUser(User user) {
		System.out.println("setUser");
		this.user = user;
	}
	public String login() {
		System.out.println(user);
		return "ok";
	}
}
