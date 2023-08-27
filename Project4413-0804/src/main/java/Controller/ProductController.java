package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import DAO.ProductDAOImp;
import Model.Product;


/**
 * Servlet implementation class ProductController
 */
@WebServlet("/products")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ProductDAOImp productDao = new ProductDAOImp();
		// calling DAO method to retrieve category List from Database, for left column display
		List<String> categoryList =  productDao.findAllCategories();
		List<String> brandList =  productDao.findAllBrands();
		ServletContext context =  config.getServletContext();
		context.setAttribute("categoryList", categoryList);
		List<Product> productList = productDao.findAllProducts();
		context.setAttribute("productList", productList);
		context.setAttribute("categoryList", categoryList);
		context.setAttribute("brandList", brandList);
		int countCheck = 1000; 
		context.setAttribute("countCheck", countCheck);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String base = "/jsp/";
		String url = base + "catalog.jsp";
		String action = request.getParameter("action");
		String category = request.getParameter("category");
		String brand = request.getParameter("brand");
		RequestDispatcher requestDispatcher ;

	
		if (action != null) { // check where to go using the action parameter
			switch (action) {
			case "allproducts":
				findAllProducts(request, response);
				 requestDispatcher = request.getRequestDispatcher(url);

					requestDispatcher.forward(request, response);
				break;
				
			case "category":
				findProductsByCategory(request, response, category);
				
				 requestDispatcher = request.getRequestDispatcher(url);

				requestDispatcher.forward(request, response);
				break;
			case "sortName":
				sortProductsName(request, response, category);
				
				 requestDispatcher = request.getRequestDispatcher(url);

				requestDispatcher.forward(request, response);
				break;
			case "sortL_H":
				
				sortProductsL_H(request, response);
				 requestDispatcher = request.getRequestDispatcher(url);

				requestDispatcher.forward(request, response);
				break;
			case "sortH_L":
				sortProductsH_L(request, response);
			
				 requestDispatcher = request.getRequestDispatcher(url);

				requestDispatcher.forward(request, response);
				break;
			case "allCategories":
				findAllCategories(request, response);
	
				 requestDispatcher = request.getRequestDispatcher(url);
				requestDispatcher.forward(request, response);
				break;
			case "brand":
				findByBrand(request, response,brand);
			
				 requestDispatcher = request.getRequestDispatcher(url);
			
				requestDispatcher.forward(request, response);
				break;
			case "cart":
				requestDispatcher = request.getRequestDispatcher("./jsp/cart.jsp");
			
				requestDispatcher.forward(request, response);
				
				break;
			case "login":
				requestDispatcher = request.getRequestDispatcher("./jsp/login.jsp");
			
				requestDispatcher.forward(request, response);
				
				break;
			case "signup":
				requestDispatcher = request.getRequestDispatcher("./jsp/signup.jsp");
			
				requestDispatcher.forward(request, response);
				
				break;
			case "logout":
				requestDispatcher = request.getRequestDispatcher("./UserLogoutController");
			
				requestDispatcher.forward(request, response);
				
				break;
			case "checkout":
				requestDispatcher = request.getRequestDispatcher("./jsp/checkout.jsp");
				
				requestDispatcher.forward(request, response);
				
				break;
				
			case "processCheckout":
				requestDispatcher = request.getRequestDispatcher("./ProcessCheckout");
				
				requestDispatcher.forward(request, response);
				
				break;
				
			case "analytics":
				requestDispatcher = request.getRequestDispatcher("./AdminViewController");
				
				requestDispatcher.forward(request, response);
				
				break;
			case "thankyou":
                requestDispatcher = request.getRequestDispatcher("./jsp/thankyou.jsp");
                
                requestDispatcher.forward(request, response);
                
                break;
			
				
			
		}
		}else { // if first time visiting controller direct it to catalog
			 
			requestDispatcher = request.getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
			
//			int x =	(int) request.getSession().getServletContext().getAttribute("countCheck");
//			
//			System.out.println("this is x "+x);
//			if(x == 0) {
//				PrintWriter out = response.getWriter();
//
//		        // Embed JavaScript code in the response
//		       
//		        out.println("<script>");
//		        out.println("localStorage.removeItem('cart')");
//		        out.println("console.log('this is console in clear script')");
//		        out.println("</script>");
//		     out.close();
//		     
//		     x++;
//			}
			
			
			
			
		//	request.getSession().getServletContext().setAttribute("countCheck", x);
			
				}
	
}



	private void sortProductsName(HttpServletRequest request, HttpServletResponse response, String category) {
		// TODO Auto-generated method stub
		try {
			// calling DAO method to retrieve list of all Category
			ProductDAO proDao = new ProductDAOImp();
			
			List<Product> productList = proDao.sortProductsName();
			request.setAttribute("productList", productList);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void findByBrand(HttpServletRequest request, HttpServletResponse response, String brand) {
		// TODO Auto-generated method stub
		try {
			// calling DAO method to retrieve a list of all products with requested brand
			ProductDAO proDao = new ProductDAOImp();
			
			List<Product> productList = proDao.findProductsByBrand(brand);
			request.setAttribute("productList", productList);

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	private void findAllCategories(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			// calling DAO method to retrieve list of all Category
			ProductDAO proDao = new ProductDAOImp();
			
			List<String> productList = proDao.findAllCategories();
			request.setAttribute("productList", productList);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void sortProductsH_L(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			// calling DAO method to retrieve a list of all products sorted in desc.
			ProductDAO proDao = new ProductDAOImp();
			
			List<Product> productList = proDao.sortProductsH_L();
			request.setAttribute("productList", productList);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void sortProductsL_H(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			// calling DAO method to retrieve a list of all products sorted in asc.
			ProductDAO proDao = new ProductDAOImp();
			
			List<Product> productList = proDao.sortProductsL_H();
			request.setAttribute("productList", productList);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void findProductsByCategory(HttpServletRequest request, HttpServletResponse response, String category) {
		// TODO Auto-generated method stub
		try {
			// calling DAO method to retrieve of all products with requested Category
			ProductDAO proDao = new ProductDAOImp();
			
			List<Product> productList = proDao.findProductsByCategory(category);
			request.setAttribute("productList", productList);

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	private void findAllProducts(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			// calling DAO method to retrieve a list of all products
			ProductDAO proDao = new ProductDAOImp();
			
			List<Product> productList = proDao.findAllProducts();
			request.setAttribute("productList", productList);

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}



}
