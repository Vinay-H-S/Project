package com.project.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.project.service.VendorAjaxService;

@RestController
@RequestMapping("/")
@EnableWebMvc
public class VendorAjaxController {

	@Autowired
	@Qualifier(value = "ajaxService")
	private VendorAjaxService service;

	public VendorAjaxController() {
		System.out.println("creating the VendorAjaxController");
	}

	@GetMapping(value = "/emailAjax/{email:.+}")
	public String emailAjax(@PathVariable String email) {
		System.out.println("Email Ajax  Running :" + email);
		return this.service.findByEmailAjax(email);
	}

	@GetMapping(value = "/gstAjax/{gstNo:.+}")
	public String gstAjax(@PathVariable String gstNo) {
		System.out.println("GstAjax is Running :" + gstNo);
		return this.service.findByGst(gstNo);
	}

	@GetMapping(value = "/contactNoAjax/{contactNo}")
	public String contactNoAjax(@PathVariable Long contactNo) {
		System.out.println("ContactNoAjax is Running :" + contactNo);
		return this.service.findByContactNo(contactNo);
	}
	
	@GetMapping(value = "/websiteAjax/{website}")
	public String websiteAjax(@PathVariable String website) {
		System.out.println("Webisite is Running :"+ website);
		return this.service.findByWebsite(website);
	}

}
