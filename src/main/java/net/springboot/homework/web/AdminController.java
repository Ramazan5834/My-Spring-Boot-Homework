package net.springboot.homework.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.springboot.homework.entities.Bill;
import net.springboot.homework.entities.Product;
import net.springboot.homework.entities.SoldProduct;
import net.springboot.homework.service.BillService;
import net.springboot.homework.service.ProductService;
import net.springboot.homework.service.SoldProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private SoldProductService soldProductService;
	
	@Autowired
	private BillService billService;

	@GetMapping("/listAdminProducts")
	public String listProducts(Model theModel) {
		List<Product> theProducts = productService.getAllProducts();
		theModel.addAttribute("products", theProducts);
		return "listAdminProducts";
	}

	
	@GetMapping("/showNewProductForm")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "newProduct";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.saveProduct(product);
		return "redirect:/admin/listAdminProducts";
	}
	
	@GetMapping("/showUpdateProductForm/{id}")
	public String showUpdateProductForm(@PathVariable ( value = "id") long id, Model model) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "updateProduct";
	}
	
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id) { 
		this.productService.deleteProductById(id);
		return "redirect:/admin/listAdminProducts";
	}
	
	@GetMapping("/unconfirmedBills")
	public String unconfirmedBills(Model theModel) { 
		List<Bill> bills = billService.getAllBills();
		List<Bill> unconfirmedBills = new ArrayList<Bill>();
		for(Bill bill:bills) {
			if(bill.getAdmin_confirmed() == false) {
				unconfirmedBills.add(bill);
			}
		}
		theModel.addAttribute("unconfirmedBills",unconfirmedBills);
		return "unconfirmedBills";
	}
	
	@GetMapping("/confirmBill/{id}")
	public String confirmBill(@PathVariable (value = "id") long id) {
		Bill bill = billService.getBillById(id);
		bill.setAdmin_confirmed(true);
		billService.saveBill(bill);
		return "redirect:/admin/unconfirmedBills";
	}
	
	@GetMapping("/billHistory")
	public String billHistory(Model theModel) {
		List<Bill> bills = billService.getAllBills();
		List<Bill> confirmedBills = new ArrayList<Bill>();
		for(Bill bill:bills) {
			if(bill.getAdmin_confirmed() == true) {
				confirmedBills.add(bill);
			}
		}
		theModel.addAttribute("confirmedBills",confirmedBills);
		return "billHistory";
	}
	
	@GetMapping("/cancelTheBill/{id}")
	public String cancelTheBill(@PathVariable (value = "id") long id) {
		List<SoldProduct> soldProducts = soldProductService.getAllSoldProducts();
		List<SoldProduct> selectSoldProducts = new ArrayList<SoldProduct>();
		for (SoldProduct soldProduct : soldProducts) {
			if (soldProduct.getBill_id() == id) {
				selectSoldProducts.add(soldProduct);
				soldProductService.deleteSoldProductById(soldProduct.getId());
			}
		}

		billService.deleteBillById(id);

		for (SoldProduct selectSoldProduct : selectSoldProducts) {
			Product product = productService.getProductById(selectSoldProduct.getProduct_id());
			product.setStock(product.getStock() + selectSoldProduct.getPiece());
			productService.saveProduct(product);
		}


		return "redirect:/admin/listAdminProducts";
	}
}
