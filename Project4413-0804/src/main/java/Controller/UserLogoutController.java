package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogoutController
 */
@WebServlet("/UserLogoutController")
public class UserLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher requestDispatcher;
		if(null == request.getSession().getAttribute("user")){  
			  // User is not logged in. 
			System.out.println("user logged out");
			}else{  
			  // User IS logged in. 
				System.out.println("user still logged in");
			}
		
		request.getSession().invalidate(); // Clear session attributes -- logout user
	
        requestDispatcher = request.getRequestDispatcher("./products?action=login");  // Redirect to the login page
		requestDispatcher.forward(request, response);
		
		
		PrintWriter out = response.getWriter();
		 out.println("<script>");
	        out.println("localStorage.removeItem('cart')");
	        out.println("console.log('this is console in clear script')");
	        out.println("</script>");
	     out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
