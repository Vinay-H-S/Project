package com.project.resources;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class VendorLoginController {
	

	public VendorLoginController() {
		System.out.println("Creating the VendorLoginController");
	}
	
//	@GetMapping(value = "/loginMailAjax/{email:.+}")
//	public String ajaxEmailLogin(@PathVariable String email) {
//		System.out.println("invoking the ajaxEmailLogin");
//		
//	}
}
