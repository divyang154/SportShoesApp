package mainapp.sportyshoesapp.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mainapp.sportyshoesapp.model.Category;
import mainapp.sportyshoesapp.service.CategoryService;

@Controller
@RequestMapping("/categoryApp")
public class CategoryController {

	@Autowired
	CategoryService categoryservice;

	@GetMapping("")
	public String hello(ModelMap model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		List<Category> categoryList = categoryservice.getAllCategory();
		model.put("categoryList", categoryList);
		return "manageCategory";
	}

	@RequestMapping("/category")
	String getAllCategory() {
		return "manageCategory";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findCategory/{id}")
	String getProductById(ModelMap model, @PathVariable int id) {
		Category category = categoryservice.findByCategoryId(id);
		model.put("category", category);
		return "manageUpdateUser";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/category")
	String saveProducts(ModelMap model, @RequestParam("categoryName") String categoryName) {
		Category category = new Category();
		category.setCategoryName(categoryName);
		category.setCreatedOn(new Date());
		category.setUpdatedOn(new Date());
		categoryservice.addCategory(category);
		List<Category> categoryList = categoryservice.getAllCategory();
		model.put("categoryList", categoryList);
		return "manageCategory";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/categoryUpdate/{id}")
	String updateProducts(ModelMap model, @PathVariable int id, @RequestParam("categoryName") String categoryName) {
		categoryservice.updateCategory(id, categoryName);
		List<Category> categoryList = categoryservice.getAllCategory();
		model.put("categoryList", categoryList);
		return "manageCategory";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/categoryDelete/{id}")
	String deleteProducts(ModelMap model, @PathVariable int id) {
		categoryservice.deleteCategory(id);
		List<Category> categoryList = categoryservice.getAllCategory();
		model.put("categoryList", categoryList);
		return "manageCategory";
	}
	
}
