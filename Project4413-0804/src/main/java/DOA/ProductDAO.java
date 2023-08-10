package DOA;

import java.util.List;

import Model.Product;


public interface ProductDAO {
	
	public  List<Product> findAllProducts();
	
	public  List<Product> sortProductsL_H();
	
	public  List<Product> sortProductsH_L();
	
	public  List<Product> sortProductsName();
	
	//public  abstract List<Product> searchProductsByKeyword(String keyWord);
	
	public  List<String> findAllCategories();

	public  void insert(Product product);

	
	public  void delete(Long pid);
	
	public  List<Product> findProductsByCategory(String category);
	
	public List<Product> findProductsByBrand(String brand);
}
