package model.bean;

public class User {

	private int id_user;
	private String username;
	private String fullname;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(int id_user, String username, String fullname, String password) {
		super();
		this.id_user = id_user;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
	}

	public User() {
	}

	public User(int id_user, String username, String fullname) {
		this.id_user = id_user;
		this.username = username;
		this.fullname = fullname;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}
