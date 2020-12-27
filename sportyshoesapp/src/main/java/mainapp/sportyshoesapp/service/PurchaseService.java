package mainapp.sportyshoesapp.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mainapp.sportyshoesapp.model.Products;
import mainapp.sportyshoesapp.model.Purchase;
import mainapp.sportyshoesapp.model.User;
import mainapp.sportyshoesapp.repository.PurchaseRepository;

@Service
public class PurchaseService {

	@Autowired
	PurchaseRepository purchaseRepository;
	@Autowired
	ProductService prodService;
	@Autowired
	CategoryService categoryService;

	public void savePurchases(User user, List<String> prodIdList,Double totalCost) {
		Purchase purchase = new Purchase();
		if (user != null) {
			purchase.setCreatedBy(user.getUserId());
			purchase.setUpdatedBy(user.getUserId());
			purchase.setUser(user);
		}

		Set<Products> prodSet = new HashSet<Products>();
		for (String prodId : prodIdList) {
			Products products = prodService.findProduct(Integer.parseInt(prodId));
			prodSet.add(products);
		}

		purchase.setProduct(prodSet);
		purchase.setUpdatedOn(new Date());
		purchase.setCreatedOn(new Date());
		purchase.setDateOfPurchase(new Date());
		purchase.setTotalCost(totalCost);
		purchaseRepository.save(purchase);
	}

	public List<Purchase> getPurchasesBasedOnCategoryAndReport(String categoryId, String dateSelected) {

		DateFormat dateFromat = new SimpleDateFormat("yyyy-MM-dd");
		List<Purchase> newPurchaseList = new ArrayList<Purchase>();
		Date selectedDate = null;
		try {
			selectedDate = dateFromat.parse(dateSelected);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Integer catId = Integer.parseInt(categoryId);
		List<Products> prodList = prodService.getProductList(catId);
		List<Integer> prodIdList = new ArrayList<Integer>();

		for (Products products : prodList) {
			prodIdList.add(products.getProductId());
		}

		List<Purchase> purchaseList = purchaseRepository.findPurchaseByCategoryAndDate(selectedDate);
		Integer productId = null;
		for (Purchase purchase : purchaseList) {
			Set<Products> prodSet = purchase.getProduct();
			for (Products products : prodSet) {
				Integer prodInt = new Integer(products.getProductId());
				if (prodIdList.contains(prodInt)) {
					newPurchaseList.add(purchase);
					break;
				}
			}
		}

		System.out.println("Purchase List" + purchaseList);
		return newPurchaseList;

	}

}
