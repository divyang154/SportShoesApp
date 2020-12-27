package mainapp.sportyshoesapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mainapp.sportyshoesapp.model.Products;
import mainapp.sportyshoesapp.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{

	@Query("from Purchase p where p.dateOfPurchase=:selectedDate")
	public List<Purchase> findPurchaseByCategoryAndDate(@Param("selectedDate") Date selectedDate);

}
