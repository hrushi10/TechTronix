package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DOA.ProductDAO;
import DOA.ProductDAOImp;
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
		ServletContext context =  config.getServletContext();
		context.setAttribute("categoryList", categoryList);
		List<Product> productList = productDao.findAllProducts();
		context.setAttribute("productList", productList);

	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
	//	String keyWord = request.getParameter("keyWord");
		if (action != null) {
			switch (action) {
			case "allproducts":
				findAllProducts(request, response);
			//	url = base + "listOfBooks.jsp";
				break;
			case "category":
				findProductsByCategory(request, response, category);
				//url = base + "category.jsp?category=" + category;
				break;
			case "sortL_H":
				sortProductsL_H(request, response);
		//		url = base + "searchResult.jsp";
				break;
			case "sortH_L":
				sortProductsH_L(request, response);
			//	url = base + "searchResult.jsp";
				break;
			case "allCategories":
				findAllCategories(request, response);
	//			url = base + "searchResult.jsp";
				break;
			case "brand":
				findAllBrandategories(request, response,brand);
			//	url = base + "searchResult.jsp";
				

			}
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}

	private void findAllBrandategories(HttpServletRequest request, HttpServletResponse response, String brand) {
		// TODO Auto-generated method stub
		try {
			// calling DAO method to retrieve a list of all books 
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
			// calling DAO method to retrieve a list of all books 
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
			// calling DAO method to retrieve a list of all books 
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
			// calling DAO method to retrieve a list of all books 
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
			// calling DAO method to retrieve a list of all books 
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
			// calling DAO method to retrieve a list of all books 
			ProductDAO proDao = new ProductDAOImp();
			
			List<Product> productList = proDao.findAllProducts();
			request.setAttribute("productList", productList);

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}



}
