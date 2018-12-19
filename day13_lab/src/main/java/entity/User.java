package entity;

public class User {
	private int id;
	private String uname;
	private String password;
	private String email;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", password=" + password + ", email=" + email + "]";
	}
	public int getId() {
		return id;
	}
	public String getUname() {
		return uname;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
