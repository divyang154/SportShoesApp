package mainapp.sportyshoesapp.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mainapp.sportyshoesapp.model.Category;
import mainapp.sportyshoesapp.model.Products;
import mainapp.sportyshoesapp.service.CategoryService;
import mainapp.sportyshoesapp.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	CategoryService categoryservice;
	@Autowired
	ProductService productService;

	@GetMapping({ "" })
	public String getLogin(ModelMap model) {
		List<Category> categoryList = categoryservice.getAllCategory();
		List<Products> productList = productService.findAll();
		model.put("productList", productList);
		model.put("categoryList", categoryList);
		return "manageProducts";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/productAdd")
	String saveProducts(ModelMap model, @RequestParam("productName") String productName,
			@RequestParam("productCost") Double productCost, @RequestParam("categorySelect") int categorySelect) {
		Category category = categoryservice.findByCategoryId(categorySelect);
		productService.saveProducts(productName, productCost, category);
		List<Products> productList = productService.findAll();
		List<Category> categoryList = categoryservice.getAllCategory();
		model.put("categoryList", categoryList);
		model.put("productList", productList);
		return "manageProducts";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/productDelete/{id}")
	String deleteProducts(ModelMap model, @PathVariable int id) {
		productService.deleteProduct(id);
		List<Category> categoryList = categoryservice.getAllCategory();
		List<Products> productList = productService.findAll();
		model.put("productList", productList);
		model.put("categoryList", categoryList);
		return "manageProducts";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findProduct/{id}")
	String findProduct(ModelMap model, @PathVariable int id) {
		Products product = productService.findProduct(id);
		List<Category> categoryList = categoryservice.getAllCategory();
		model.put("categoryList", categoryList);
		model.put("product", product);
		return "updateProduct";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/productsUpdate/{id}")
	String updateProducts(ModelMap model, @PathVariable int id, @RequestParam("productName") String productName,
			@RequestParam("productCost") Double productCost, @RequestParam("categorySelect") int categorySelect) {

		Category category = categoryservice.findByCategoryId(categorySelect);
		productService.updateProduct(id, productName, productCost, category);
		List<Category> categoryList = categoryservice.getAllCategory();
		List<Products> productList = productService.findAll();
		model.put("productList", productList);
		model.put("categoryList", categoryList);
		return "manageProducts";

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/showProducts")
	public String displayProducts(ModelMap model) {
		List<Category> categoryList = categoryservice.getAllCategory();
		List<Products> productList = productService.findAll();
		model.put("productList", productList);
		model.put("categoryList", categoryList);
		return "chooseProducts";
	}

}
