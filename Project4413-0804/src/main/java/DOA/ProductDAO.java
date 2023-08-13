package DOA;

import java.util.List;

import Model.Product;


public interface ProductDAO {
	
	public  List<Product> findAllProducts();
	
	//public  abstract List<Product> searchProductsByKeyword(String keyWord);
	
	public  List<String> findAllCategories();
	
	public  List<String> findAllBrands();

	
	public  void insert(Product product);

	public  void delete(int pid);
	
	
	public  List<Product> findProductsByCategory(String cat);
	
	public List<Product> findProductsByBrand(String bra);
	
	
	public  List<Product> sortProductsL_H();
	
	public  List<Product> sortProductsH_L();
	
	public  List<Product> sortProductsName();
	
	public int findId(String name); 
}
