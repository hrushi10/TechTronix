package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import Model.Product;


public class ProductDAOImp implements ProductDAO{

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
		}
	}

	// complete this method
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://eecs4413.ceik1relpviq.us-east-2.rds.amazonaws.com:3306/project4413", "admin", "mysql4413");

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
	public List<Product> findAllProducts() {
		
		List<Product> result = new ArrayList<Product>();
		String sql = "select * from products;";
Connection connection = null;
		
				
		try {
			connection = getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet =  statement.executeQuery();
					
			result = makeList(resultSet);
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		
		
		return result;
	}

	@Override
	public List<Product> sortProductsL_H()  {
		
		List<Product> result = new ArrayList<Product>();
		String sql = "select * from products order by price;";
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
			ResultSet resultSet =  statement.executeQuery();
					
			result = makeList(resultSet);
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		
		
		return result;
	}

	@Override
	public List<Product> sortProductsH_L(){
		
		List<Product> result = new ArrayList<Product>();
		String sql = "select * from products order by price desc;";
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
			ResultSet resultSet =  statement.executeQuery();
					
			result = makeList(resultSet);
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		
		
		return result;
	}

	@Override
	public List<Product> sortProductsName() {
		// TODO Auto-generated method 

		{
			
			List<Product> result = new ArrayList<Product>();
			
			String sql = "select * from products order by name;";
			
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
				ResultSet resultSet =  statement.executeQuery();
						
				result = makeList(resultSet);
				
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				closeConnection(connection);
			}
			
			
			return result;
		}
	}

	@Override
	public List<String> findAllCategories() {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<String>();
		
		String sql = "select distinct(category) from products ;";
		
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
			ResultSet resultSet =  statement.executeQuery();
					
			while (resultSet.next()) {
																
				result.add(resultSet.getString("category"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		
		return result;
	}

	

	@Override
	public List<Product> findProductsByCategory(String cat) {
		// TODO Auto-generated method stub
		

		List<Product> result = new ArrayList<Product>();
		
		String sql = "select* from products where category like '"+cat+"' ;";
		
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
			ResultSet resultSet =  statement.executeQuery();
					
			result = makeList(resultSet);
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		
		
		return result;
	}
	
	
	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int pid) {
		// TODO Auto-generated method stub
		
	}
	
	
@Override
public List<Product> findProductsByBrand(String br) {
	// TODO Auto-generated method stub
	

	List<Product> result = new ArrayList<Product>();
	
	String sql = "select * from products where brand like '"+br+"';";
	
	Connection connection = null;
	
	
	
	try {
		connection = getConnection();
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet =  statement.executeQuery();
	
		result = makeList(resultSet);
		
	} catch (SQLException ex) {
		ex.printStackTrace();
	} finally {
		closeConnection(connection);
	}
	
	
	return result;
}

@Override
public List<String> findAllBrands() {
	// TODO Auto-generated method stub
	List<String> result = new ArrayList<String>();
	
	String sql = "select distinct(brand) from products ;";
	
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
		ResultSet resultSet =  statement.executeQuery();
				
		while (resultSet.next()) {
															
			result.add(resultSet.getString("brand"));
		}
	} catch (SQLException ex) {
		ex.printStackTrace();
	} finally {
		closeConnection(connection);
	}
	
	return result;
}


private List<Product> makeList(ResultSet rs){
	
	List<Product> result = new ArrayList<Product>();
	
	try {
		while (rs.next()) {
			
			Product product = new Product();
			
			
			// populate book and author beans with needed info, and then set author to book
			int id = rs.getInt("id");
			String name = rs.getString("name");
			double price = rs.getDouble("price");
			String image = rs.getString("image");
			String category = rs.getString("category");
			String brand = rs.getString("brand");
			String description = rs.getString("description");

			product.setId(id);
			product.setImage(image);
			product.setCategory(category);
			product.setDescription(description);
			product.setName(name);
			product.setPrice(price);
			product.setBrand(brand);
												
			result.add(product);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	
}

@Override
public int findId(String name) {
	// TODO Auto-generated method stub
	int id=0;
	
	String sql = "select id from products where name like '"+name+"' ;";
	
	Connection connection = null;
	
	try {
		connection = getConnection();
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet rs =  statement.executeQuery();
	
		id = rs.getInt("id");;
		
	} catch (SQLException ex) {
		ex.printStackTrace();
	} finally {
		closeConnection(connection);
	}
	
	return id;
}


}


