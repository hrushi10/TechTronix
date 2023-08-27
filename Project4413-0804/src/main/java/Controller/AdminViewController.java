package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;

import DAO.AdminViewDAOImp;
import DAO.ProductDAO;
import DAO.ProductDAOImp;
import Model.Order;

/**
 * Servlet implementation class AdminViewController
 */
@WebServlet("/AdminViewController")
public class AdminViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher requestDispatcher ;
		
		try {
			// calling DAO method to retrieve list of all Category
			AdminViewDAOImp proDao = new AdminViewDAOImp();
			
		//	int x = (int) request.getAttribute("countCheck");
		//	System.out.println("adminCOntroller has x = "+x);
			List<Order> orderList = new ArrayList<>();
			orderList = proDao.findAllOrders();
			List<Order> orderDetails = proDao.findOrdersDetails();
			
			
		//	System.out.println("this is orderLists detials = "+orderList.get(0).getId());
			
			request.setAttribute("orderList", orderList);
			request.setAttribute("orderDetails", orderDetails);
			
			
			AdminViewDAOImp adminDAO = new AdminViewDAOImp();
			
			double total_sales = adminDAO.getTotalSales();
			request.setAttribute("totalSales", total_sales);
			
			int total_orders = adminDAO.getTotalOrders();
			request.setAttribute("totalOrders", total_orders);
			
			int totalItemsSold = adminDAO.getTotalItemsSold();
			request.setAttribute("totalItemsSold", totalItemsSold);
			
			

		} catch (Exception e) {
			System.out.println(e);
		}
		
		AdminViewDAOImp proDao = new AdminViewDAOImp();
		
		String aj = request.getParameter("comm");
		String id = request.getParameter("id");
		
		
		if (aj!= null && aj.equals("ajax")) {
			
			int A = Integer.parseInt(id);
		 String[] details = proDao.getSpecific(A);   
			 
			 
			 JSONObject jsonObject = new JSONObject();
		        jsonObject.put("orderID", details[0]);
		        jsonObject.put("itemList", details[1]);
		        jsonObject.put("qtyList", details[2]);
		        jsonObject.put("priceList", details[3]);
		        jsonObject.put("total", details[4]);
		        
		        // Send the JSON response
		        response.setContentType("application/json");
		        response.getWriter().write(jsonObject.toString());
		}else {
			 requestDispatcher = request.getRequestDispatcher("./jsp/analytics.jsp");
			
			requestDispatcher.forward(request, response);
		}
		
		
		
		
		
	//	Connection con = DriverManager.getConnection("jdbc:mysql://eecs4413.ceik1relpviq.us-east-2.rds.amazonaws.com:3306/project4413", "admin", "mysql4413");

	}

}
