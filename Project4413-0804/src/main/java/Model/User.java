package Model;

public class User {

//	int id;
	private String username;
	private String password;
	private String email;
	private Boolean admin = false;
	
	public User (String name, String password, String email, boolean admin) {
		this.username = name;
		this.password = password;
		this.email = email;
		this.admin = admin;
	}

	public String getName() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setName(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

}