package Model;

public class User {
	
private String username;
private String password;
private String emial;
private Boolean admin=false;

public String getUsername() {
	return username;
}

public String getPassword() {
	return password;
}

public String getEmial() {
	return emial;
}

public Boolean getAdmin() {
	return admin;
}

public void setUsername(String username) {
	this.username = username;
}

public void setPassword(String password) {
	this.password = password;
}

public void setEmial(String emial) {
	this.emial = emial;
}

public void setAdmin(Boolean admin) {
	this.admin = admin;
}



}
