package DOA;

import java.util.List;

import Model.User;

//UserDAO.java
public interface UserDAO {
	public User getUserByEmail(String email);
	public void createUser(User user);
}
