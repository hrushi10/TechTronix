package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Order;

public class AdminViewDAOImp implements AdminViewDAO{

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
	public int getTotalOrders() {
		int totalOrders = 0;
		Connection connection = null;
		String sql = "SELECT COUNT(*) AS total_orders FROM orderDetails"; // Modify this query according to your schema

		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				totalOrders = resultSet.getInt("total_orders");
			}
			
			closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalOrders;
	}

	@Override
	public double getTotalSales() {
		double totalSales = 0.0;
		String sql = "SELECT SUM(total) AS total_sales FROM orderDetails"; // Modify this query according to your schema
		Connection connection = null;

		try {
			connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalSales = resultSet.getDouble("total_sales");
			}
			
			closeConnection(connection);
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return totalSales;
	}

	@Override
	public int getTotalItemsSold() {
		// TODO Auto-generated method stub
		
		int totalSold = 0;
		String qtyList = "";
		String sql = "SELECT qtyList FROM orderDetails"; // Modify this query according to your schema
		Connection connection = null;

		try {
			connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			int count=0;
			// System.out.println(resultSet);
			while(resultSet.next()) {
				
				if(count == 0) {
					qtyList = resultSet.getString("qtyList");
					count++;
				}else {
					qtyList = qtyList+","+ resultSet.getString("qtyList");
	
				}
			}
			//System.out.println(qtyList.trim());
			
			String[] str = qtyList.trim().split(",");
			for(String s: str) {
				System.out.println(s);
				totalSold += Integer.parseInt(s);
			}
			//System.out.println(totalSold);
			
			closeConnection(connection);
		}
		
		

		catch (SQLException e) {
			e.printStackTrace();
		}

		return totalSold;
	}
	

	@Override
	public List<Order> findAllOrders() {
		// TODO Auto-generated method stub
		List<Order> allOrders = new ArrayList<Order>();
		try {
		 String sql = "select * from Orders";
		 
		 Connection con = getConnection();
	
		 PreparedStatement statement = con.prepareStatement(sql);
	
		 ResultSet resultSet =  statement.executeQuery();
		
		while(resultSet.next()) {
			Order order = new Order();
			order.setDate(resultSet.getString("date"));
			order.setId(resultSet.getInt("orderId"));
			order.setAddressId(resultSet.getInt("addressId"));
			order.setPayId(resultSet.getInt("payId"));
			order.setUser(resultSet.getString("user"));
			
			allOrders.add(order);
		}
	}
		catch (SQLException e) {
		e.printStackTrace();
	}
		
		return allOrders;
	}

	@Override
	public List<Order> findOrdersDetails() {
		// TODO Auto-generated method stub
		List<Order> allOrders = new ArrayList<Order>();
		try {
		 String sql = "select * from orderDetails";
		 
		 Connection con = getConnection();
	
		 PreparedStatement statement = con.prepareStatement(sql);
	
		 ResultSet resultSet =  statement.executeQuery();
		
		while(resultSet.next()) {
			
			Order order = new Order();
			order.setItemList(resultSet.getString("itemList"));
			order.setId(resultSet.getInt("orderId"));
			order.setQtyList(resultSet.getString("qtyList"));
			order.setPriceList(resultSet.getString("priceList"));
			order.setTotal(resultSet.getDouble("total"));
			
			allOrders.add(order);
		}
	}
		catch (SQLException e) {
		e.printStackTrace();
	}
		
		return allOrders;
	}

	@Override
	public String[] getSpecific(int id) {
		// TODO Auto-generated method stub
		
		String[] detials = new String[5];
		
		
		try {
			 String sql1 = "select * from orderDetails where orderId = "+id;
			 
			 Connection con = getConnection();
		
			 PreparedStatement statement = con.prepareStatement(sql1);
				
			 ResultSet resultSet =  statement.executeQuery();
			 resultSet.next();
			 detials[0] = ""+id;
			 detials[1] = resultSet.getString("itemList");
			 detials[2] = resultSet.getString("qtyList");
			 detials[3] = resultSet.getString("priceList");
			 detials[4] = resultSet.getString("total");
			 
			
		
		}catch (SQLException e){
				 System.out.println("getDetails in AdminViewDAOIMP has an issue"+e.toString());
			 }

		return detials;
	}
	}


