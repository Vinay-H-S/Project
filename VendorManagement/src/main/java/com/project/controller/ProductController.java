package com.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.project.dto.OrderDTO;
import com.project.dto.ProductDTO;
import com.project.entity.VendorManagementEntity;
import com.project.repository.VendorManagementRepository;
import com.project.service.OrderService;
import com.project.service.ProductService;

@Controller
@RequestMapping("/")
@EnableWebMvc
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private VendorManagementRepository vendorManagementRepository;

	@Autowired
	private OrderService orderService;

	public ProductController() {
		System.out.println("running tht productController()");
	}

	@RequestMapping(path = "/addproducts/{vendorId}")
	public String addProductPage(@PathVariable int vendorId, ProductDTO dto, Model model) {
		System.out.println("invoking addProductPage() in ProductController");
		model.addAttribute("vendorId", vendorId);
		VendorManagementEntity entites = this.vendorManagementRepository.getVendorEntityById(vendorId);
		model.addAttribute("entites", entites);
		return "addproduct";
	}

	@RequestMapping(path = "/products/{vendorId}")
	public String addProducts(@Valid ProductDTO dto, Model model, @PathVariable int vendorId) {
		System.out.println("invoking the addProducts in productController");

		boolean save = this.productService.validateAndSave(dto);
		if (save) {
			return "redirect:/login";
		}
		return "addproduct";
	}

	@RequestMapping(path = "/getProductsDetails")
	public String readProducts(Model model) {
		System.out.println("invoking the readProducts in productController()");
		List<ProductDTO> entities = this.productService.getAllProducts();
		model.addAttribute("products", entities);
		return "producttable";
	}

	@RequestMapping(path = "/order/{productId}")
	public String order(Model model, @PathVariable int productId) {
		System.out.println("invoking the order in productController");
		ProductDTO productDTO = this.productService.findAllProductEntityById(productId);
		model.addAttribute("entites", productDTO);
		return "producttable";
	}

	@GetMapping(value = "/placeOrder")
	public void placeOrder(@RequestParam int productId, Model model) {
		System.out.println("invoking the placeOrder in productController");
		ProductDTO productDTO = this.productService.findAllProductEntityById(productId);
		model.addAttribute("entites", productDTO);
		System.err.println(productDTO);
	}

	@RequestMapping(path = "/placeitem/{productId}")
	public String placeYourOrder(@Valid OrderDTO dto, Model model, @PathVariable int productId) {
		System.out.println("invoking the placeYourOrder in productController");
		ProductDTO productDTO = this.productService.findAllProductEntityById(productId);
		model.addAttribute("entites", productDTO);
		this.orderService.validateAndSave(dto);
		return "producttable";
	}

}
