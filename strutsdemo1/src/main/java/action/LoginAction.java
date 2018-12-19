package action;

public class LoginAction {
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		System.out.println("setUsername");
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		System.out.println("setPassword");
	}

	public String login() {
		System.out.println(username);
		System.out.println(password);
		return "loginok";
	}
}
