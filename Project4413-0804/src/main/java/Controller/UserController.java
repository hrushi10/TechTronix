package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DOA.UserDAO;
import DOA.UserDAOImpl;
import Model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/jsp/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAOImpl userDAO = new UserDAOImpl();

		String email = request.getParameter("loginEmail");
		User existingUser = userDAO.getUserByEmail(email);

		if (existingUser == null) {
			// User doesn't exist, redirect to registration page
			response.sendRedirect("signup.jsp");
			
		} else {
			// User exists, redirect to login page
	        String password = request.getParameter("loginPassword");

	        User user = userDAO.getUserByEmail(email);
	        String userName = user.getName();

	        if (user != null && user.getPassword().equals(password)) {
	            // Successful login, set user in session and redirect
	            request.getSession().setAttribute("user", user);
	            response.sendRedirect("catalog.jsp");
	            System.out.println("user logged in");
	        } else {
	            // Failed login, redirect back to login page with error message
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	        }
		}
	}
}
