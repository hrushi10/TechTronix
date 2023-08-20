package Controller;

import javax.servlet.*;           
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.google.gson.Gson;

import Model.CartItem;
import Model.OrderData;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@WebServlet("/ProcessCheckout")
public class ProcessCheckoutServlet extends HttpServlet  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Connection connectToDatabase() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://eecs4413.ceik1relpviq.us-east-2.rds.amazonaws.com:3306/project4413", "admin", "mysql4413");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        StringBuilder jsonData = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();
        
        while ((line = reader.readLine()) != null) {
            jsonData.append(line);
        }
        
        Gson gson = new Gson();
        OrderData order = gson.fromJson(jsonData.toString(), OrderData.class);
        
        
        
        double totalCost = 0.0; // Initialize the total cost
        
        for (CartItem item : order.getCartItems()) {
            totalCost += item.getPrice() * item.getQuantity();
        }
        
        if (order == null) {
            try (PrintWriter out = response.getWriter()) {
                out.print("{\"message\":\"Order data is missing or not in the expected format.\"}");
            }
            return;
        } else if (order.getCustomerName() == null || order.getCustomerName().trim().isEmpty()) {
            try (PrintWriter out = response.getWriter()) {
                out.print("{\"message\":\"Order not processed. Customer name is missing.\"}");
            }
            return;
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.print("{\"message\":\"Order processed successfully for: " + order.getCustomerName() + "\"}");
            }
        }

        Connection con = null;
        
       String userName = (String) request.getSession().getAttribute("userEmail");
       
       
       
       System.out.println(userName);
           
        try {
            con = connectToDatabase();

            String insertAddress = "INSERT INTO address (user, address, city, state, country, zip) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmtAddress = con.prepareStatement(insertAddress, Statement.RETURN_GENERATED_KEYS);
 System.out.println("this is carfd numebr"+order.getCardNumber());
            stmtAddress.setString(1, userName);
            stmtAddress.setString(2, order.getAddress());
            stmtAddress.setString(3, order.getCity());
            stmtAddress.setString(4, order.getState());
            stmtAddress.setString(5, order.getCountry());
            stmtAddress.setString(6, order.getZip());
            stmtAddress.executeUpdate();
           
            ResultSet rs = stmtAddress.getGeneratedKeys();
            
            int lastAddressId = -1;
            if (rs.next()) {
            	lastAddressId = rs.getInt(1);
            }
            
            String itemList = "";
            String qtyList = "";
            String priceList = "";
            
            
            	for (CartItem item : order.getCartItems()) {
            	
            	itemList = itemList + " "+item.getName();
            	qtyList = qtyList + " "+ item.getQuantity();
            	priceList = priceList + " "+ item.getPrice();

            }

            
            String insertOrder = "INSERT INTO orderDetails (itemList, qtyList, total, date, priceList) VALUES (?, ?, ?, now(), ?)";

            PreparedStatement stmtOrder = con.prepareStatement(insertOrder, Statement.RETURN_GENERATED_KEYS);

            stmtOrder.setString(1, itemList);
            stmtOrder.setString(2, qtyList);
            stmtOrder.setDouble(3, totalCost);
            //stmtOrder.setObject(4, 'NOW()');
            stmtOrder.setString(4, priceList);
            stmtOrder.executeUpdate();
            
            ResultSet io = stmtOrder.getGeneratedKeys();
            
            int lastOrderId = -1;
            if (io.next()) {
                lastOrderId = io.getInt(1);
            }
            
            String insertPayment = "INSERT INTO payment (user, cardName, cardNumber, exp, cvv, addressId) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement stmtPayment = con.prepareStatement(insertPayment, Statement.RETURN_GENERATED_KEYS);

            stmtPayment.setString(1, userName);
            stmtPayment.setString(2, order.getCardName());
            stmtPayment.setString(3, order.getCardNumber());
            stmtPayment.setString(4, order.getExpiration());
            stmtPayment.setString(5, order.getCvv());
            stmtPayment.setInt(6, lastAddressId);
            stmtPayment.executeUpdate();
            
            ResultSet ip = stmtPayment.getGeneratedKeys();
            
            int lastPayId = -1;
            if (ip.next()) {
            	lastPayId = ip.getInt(1);
            }
            
            String makeOrder= "INSERT INTO Orders (orderId, user, addressId, payId) VALUES ( ?, ?, ?, ?)";
            
            System.out.println("orderId "+ lastOrderId+" lastAddress "+lastAddressId+" laypayId "+lastPayId);
            // 12,10,4
            PreparedStatement stmtMerger = con.prepareStatement(makeOrder, Statement.RETURN_GENERATED_KEYS);
            
            stmtMerger.setInt(1, lastOrderId);
            stmtMerger.setString(2, userName);
            stmtMerger.setInt(3, lastAddressId);
            stmtMerger.setInt(4, lastPayId);
        
            stmtMerger.executeUpdate();
            

            response.setStatus(HttpServletResponse.SC_OK); // Send success status

        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"success\": false, \"message\": \"Database error: " + e.getMessage() + "\"}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"success\": false, \"message\": \"Class not found error: " + e.getMessage() + "\"}");
        } finally {
            // Close the connection
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
