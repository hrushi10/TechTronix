package DAO;

import java.util.List;

import Model.Order;


public interface AdminViewDAO {
	public int getTotalOrders();
	public double getTotalSales();
	public int getTotalItemsSold();
	
	public List<Order> findAllOrders();
	public List<Order> findOrdersDetails();
	public String[] getSpecific(int id);
}
