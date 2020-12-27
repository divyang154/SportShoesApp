package mainapp.sportyshoesapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mainapp.sportyshoesapp.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

	@Query("from Products p where p.category.categoryId=:categoryId")
	public List<Products> findProductsByCategory(@Param("categoryId") Integer categoryId);
}
