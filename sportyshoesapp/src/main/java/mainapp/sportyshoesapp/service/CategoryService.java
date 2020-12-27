package mainapp.sportyshoesapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainapp.sportyshoesapp.model.Category;
import mainapp.sportyshoesapp.repository.CategoryRepository;;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryrepository;

	public List<Category> getAllCategory() {
		return categoryrepository.findAll();
	}

	public void addCategory(Category category) {
		category.setCreatedOn(new Date());
		category.setUpdatedOn(new Date());
		categoryrepository.save(category);
	}

	public void updateCategory(Integer categoryId, String categoryNameUpdated) {
//		
		Category category=categoryrepository.findById(categoryId).get();
		category.setCategoryName(categoryNameUpdated);
		categoryrepository.save(category);
	}

	public void deleteCategory(Integer categoryId) {
		categoryrepository.deleteById(categoryId);

	}

	public Category findByCategoryId(Integer categoryId) {
		return categoryrepository.findById(categoryId).get();
	}
}
