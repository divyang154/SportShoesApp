package mainapp.sportyshoesapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainapp.sportyshoesapp.model.Category;
import mainapp.sportyshoesapp.model.Products;
import mainapp.sportyshoesapp.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public void saveProducts(String productName, Double productCost, Category category) {
		Products product = new Products();
		product.setCategory(category);
		product.setCost(productCost);
		product.setProductName(productName);
		product.setCreatedOn(new Date());
		product.setUpdatedOn(new Date());
		productRepository.save(product);

	}

	public List<Products> findAll() {

		return productRepository.findAll();
	}

	public Products findProduct(Integer productId) {
		return productRepository.findById(productId).get();
	}

	public void deleteProduct(Integer productId) {
		productRepository.deleteById(productId);

	}

	public void updateProduct(Integer id, String productName, Double productCost, Category category) {
		Products product = productRepository.findById(id).get();
		product.setCategory(category);
		product.setCost(productCost);
		product.setProductName(productName);
		productRepository.save(product);
	}

	public List<Products> getProductList(String[] productIdList) {

		List<Products> productList = new ArrayList<Products>();

		for (String productId : productIdList) {

			Products product = productRepository.getOne(Integer.parseInt(productId));
			productList.add(product);
		}

		return productList;
	}

	public Double getProductTotal(String[] productIdList) {

		Double totalCost = 0.0;

		for (String productId : productIdList) {

			Products product = productRepository.getOne(Integer.parseInt(productId));
			totalCost = totalCost + product.getCost();
		}

		return totalCost;
	}

	public List<Products> getProductList(Integer categoryId) {
		List<Products> productList = productRepository.findProductsByCategory(categoryId);
		return productList;
	}

}
