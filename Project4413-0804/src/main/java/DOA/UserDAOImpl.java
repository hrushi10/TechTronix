package DOA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Product;
import Model.User;

//UserDAOImpl.java
public class UserDAOImpl implements UserDAO {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
		}
	}

	// complete this method
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://eecs4413.ceik1relpviq.us-east-2.rds.amazonaws.com:3306/project4413", "admin",
				"mysql4413");

	}

	private void closeConnection(Connection connection) {
		if (connection == null)
			return;
		try {
			connection.close();
		} catch (SQLException ex) {
		}
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		User user = null;
		String sql = "select * from users where email = '" + email + "';";

		Connection connection = null;

		try {
			connection = getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			connection = getConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String name = resultSet.getString("username");
				String retrievedEmail = resultSet.getString("email");
				String password = resultSet.getString("password");
				boolean admin = resultSet.getBoolean("admin");

				user = new User(name, password, retrievedEmail, admin);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return user;
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		String name = user.getName();
		String password = user.getPassword();
		String email = user.getEmail();
		boolean admin = user.getAdmin();
		
		System.out.println(name + " " + password + " " + email + " " + admin);

		String sql = "insert into users values ('" + name + "', '" + 
		password + "', '" + email + "', " + admin + ");";
		Connection connection = null;

		try {
			connection = getConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}
}
