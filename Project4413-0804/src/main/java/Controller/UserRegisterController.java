package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DOA.UserDAOImpl;
import Model.User;

/**
 * Servlet implementation class UserRegisterController
 */
@WebServlet("/UserRegisterController")
public class UserRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String msg = " ";
		request.setAttribute("registeredMsg", msg);
		
		UserDAOImpl userDAO = new UserDAOImpl();
		RequestDispatcher requestDispatcher;

		String email = request.getParameter("registerEmail");
		String name = request.getParameter("registerName");
        String password = request.getParameter("registerPassword");
        

        User existingUser = userDAO.getUserByEmail(email);
        String msg2 = "";
        
        if(existingUser != null) {
        	msg2 = "User '" + email + "' already exists!";
        	request.setAttribute("registeredMsg3", msg2); 
        	
        	requestDispatcher = request.getRequestDispatcher("./jsp/signup.jsp");
        	requestDispatcher.forward(request, response);
        }
        
        else {
        	User newUser = new User(name, password, email, false);
        	userDAO.createUser(newUser);
        	
        	msg = "Hi, " + name + ". You have been registered!";
        	msg2 = "Enter your credentials to login";
        	
        	request.setAttribute("registeredMsg1", msg);
        	request.setAttribute("registeredMsg2", msg2);   
        	
        	// Redirect to login page after successful registration
        	requestDispatcher = request.getRequestDispatcher("./jsp/login.jsp");
        	requestDispatcher.forward(request, response);
        }

	}

}
