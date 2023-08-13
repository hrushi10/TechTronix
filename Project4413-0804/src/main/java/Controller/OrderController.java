package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DOA.ProductDAOImp;
import Model.Product;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
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

//    public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		ProductDAOImp productDao = new ProductDAOImp();
//		// get and store the retervied product from jsp 
//		List<Product> productList = productDao.findAllProducts();
//		// used to store the list of productid in database
//		List<String> orderedPro = new ArrayList<>();
//	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		// Variables to insert order details
		double total=0.0;
		String items="";
		String qtys="";
		
		// Variables to insert payment
		String userName="";
		String cardName="";
		String cardNumber="";
		String exp="";
		String cvv="";
		
		// Variables to insert Address
		
		
//		while() {
//			//to make the items string and qtys string from the request.getparamets
//		}
		
		String insertSql = "insert into orderDetails (itemList,qtyList,total,date) values ("+items+","+qtys+","+total+",now());";
	//	String insertPayment = "insert into payment (username,card_name,card_number,exp,cvv) values ("+userName+","+cardName+","+cardNumber+","+exp+","+cvv+","++");";
		Connection connection = null;
		
		try {
			connection = getConnection();
			
			PreparedStatement statement = connection.prepareStatement(insertSql);
			statement.executeQuery();
					
		//	PreparedStatement statement1 = connection.prepareStatement(insertPayment);
			statement.executeQuery();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		
	}
	
	

}
