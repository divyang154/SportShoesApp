package mainapp.sportyshoesapp.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mainapp.sportyshoesapp.model.Category;
import mainapp.sportyshoesapp.model.Products;
import mainapp.sportyshoesapp.model.Purchase;
import mainapp.sportyshoesapp.model.User;
import mainapp.sportyshoesapp.service.CategoryService;
import mainapp.sportyshoesapp.service.ProductService;
import mainapp.sportyshoesapp.service.PurchaseService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	ProductService productServ;
	@Autowired
	PurchaseService purchaseServ;
	@Autowired
	CategoryService categoryServ;

	@RequestMapping(method = RequestMethod.POST, value = "/purchaseProduct")
	String saveProducts(ModelMap model, @RequestParam("selected") String[] selected, HttpSession session) {

		List<Products> productList = productServ.getProductList(selected);
		Double totalCost = productServ.getProductTotal(selected);
		System.out.println("sop" + selected.toString());
		session.setAttribute("prodIdList", Arrays.asList(selected));
		session.setAttribute("totalCost", totalCost);
		model.put("productList", productList);
		model.put("totalCost", totalCost);
		return "addToCart";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/makePayment")
	String makePayment(ModelMap model, HttpSession session) {
		return "Payment";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addPurchase")
	String addPurchase(ModelMap model, HttpSession session) {
		List<String> prodIdList = (List<String>) session.getAttribute("prodIdList");
		User user = (User) session.getAttribute("loggedInUser");
		Double totalCost = (Double)session.getAttribute("totalCost");
		purchaseServ.savePurchases(user, prodIdList,totalCost);
		return "UserPanel";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/purchaseReports")
	String viewPurchaseReports(ModelMap model, HttpSession session) {
		List<Category> categoryList = categoryServ.getAllCategory();
		model.put("categoryList", categoryList);
		return "purchaseReports";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/searchPurchaseReport")
	String searchPurchaseReports(ModelMap model,HttpSession session,@RequestParam("categorySelect") String categorySelect,@RequestParam("dateSelected") String dateSelected) {
		List<Category> categoryList = categoryServ.getAllCategory();
		List<Purchase>purchaseList=purchaseServ.getPurchasesBasedOnCategoryAndReport(categorySelect, dateSelected);
		model.put("categoryList", categoryList);
		model.put("purchaseList", purchaseList);
		model.put("selectedDate", dateSelected);
		return "purchaseReports";
	}
}
