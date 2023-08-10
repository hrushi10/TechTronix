package DOA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.Product;


public class ProductDAOImp implements ProductDAO{

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
		}
	}

	// complete this method
	private Connection getConnection() throws SQLException {
		
		 return DriverManager.getConnection("jdbc:sqlite:C:\\Users\\patel\\Desktop\\Summer 2023\\EECS 4413\\Labs\\4413 lab6\\Books.db ");
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection = getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet =  statement.executeQuery();
					
			while (resultSet.next()) {
				
				Product product = new Product();
				
				
				// populate book and author beans with needed info, and then set author to book
				Long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				Long price = resultSet.getLong("price");
				String image = resultSet.getString("image");
				String category = resultSet.getString("category");
				String brand = resultSet.getString("brand");
				String desc = resultSet.getString("description");

				product.setId(id);
				product.setImg(image);
				product.setCategory(category);
				product.setDesc(desc);
				product.setName(name);
				product.setPrice(price);
				product.setBrand(brand);
													
				result.add(product);
			}
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
		String sql = "select * from products order by price asc;";
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
				
				Product product = new Product();
				
				
				// populate book and author beans with needed info, and then set author to book
				Long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				Long price = resultSet.getLong("price");
				String image = resultSet.getString("image");
				String category = resultSet.getString("category");
				String brand = resultSet.getString("brand");
				String desc = resultSet.getString("description");

				product.setId(id);
				product.setImg(image);
				product.setCategory(category);
				product.setDesc(desc);
				product.setName(name);
				product.setPrice(price);
				product.setBrand(brand);
													
				result.add(product);
			}
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
					
			while (resultSet.next()) {
				
				Product product = new Product();
				
				
				// populate book and author beans with needed info, and then set author to book
				Long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				Long price = resultSet.getLong("price");
				String image = resultSet.getString("image");
				String category = resultSet.getString("category");
				String brand = resultSet.getString("brand");
				String desc = resultSet.getString("description");

				product.setId(id);
				product.setImg(image);
				product.setCategory(category);
				product.setDesc(desc);
				product.setName(name);
				product.setPrice(price);
				product.setBrand(brand);
													
				result.add(product);
			}
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
						
				while (resultSet.next()) {
					
					Product product = new Product();
					
					
					// populate book and author beans with needed info, and then set author to book
					Long id = resultSet.getLong("id");
					String name = resultSet.getString("name");
					Long price = resultSet.getLong("price");
					String image = resultSet.getString("image");
					String category = resultSet.getString("category");
					String brand = resultSet.getString("brand");
					String desc = resultSet.getString("description");

					product.setId(id);
					product.setImg(image);
					product.setCategory(category);
					product.setDesc(desc);
					product.setName(name);
					product.setPrice(price);
					product.setBrand(brand);
														
					result.add(product);
				}
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
		
		return null;
	}

	

	@Override
	public List<Product> findProductsByCategory(String cat) {
		// TODO Auto-generated method stub
		

		List<Product> result = new ArrayList<Product>();
		
		String sql = "select* from products where category ="+cat+" ;";
		
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
				
				Product product = new Product();
				
				
				// populate book and author beans with needed info, and then set author to book
				Long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				Long price = resultSet.getLong("price");
				String image = resultSet.getString("image");
				String category = resultSet.getString("category");
				String brand = resultSet.getString("brand");
				String desc = resultSet.getString("description");

				product.setId(id);
				product.setImg(image);
				product.setCategory(category);
				product.setDesc(desc);
				product.setName(name);
				product.setPrice(price);
				product.setBrand(brand);
													
				result.add(product);
			}
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
	public void delete(Long pid) {
		// TODO Auto-generated method stub
		
	}
	
	
@Override
public List<Product> findProductsByBrand(String br) {
	// TODO Auto-generated method stub
	

	List<Product> result = new ArrayList<Product>();
	
	String sql = "select * from products where brand = "+br+";";
	
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
			
			Product product = new Product();
			
			
			// populate book and author beans with needed info, and then set author to book
			Long id = resultSet.getLong("id");
			String name = resultSet.getString("name");
			Long price = resultSet.getLong("price");
			String image = resultSet.getString("image");
			String category = resultSet.getString("category");
			String brand = resultSet.getString("brand");
			String desc = resultSet.getString("description");

			product.setId(id);
			product.setImg(image);
			product.setCategory(category);
			product.setDesc(desc);
			product.setName(name);
			product.setPrice(price);
			product.setBrand(brand);
												
			result.add(product);
		}
	} catch (SQLException ex) {
		ex.printStackTrace();
	} finally {
		closeConnection(connection);
	}
	
	
	return result;
}




}


