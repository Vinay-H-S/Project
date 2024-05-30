package com.project.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.project.service.AdminAjaxService;

@RestController
@EnableWebMvc
@RequestMapping("/")
public class AdminAjaxController {
	
	@Autowired
	@Qualifier(value = "adminservice")
	private AdminAjaxService ajaxService;

	public AdminAjaxController() {
		System.out.println("Creating the AdminAjaxController()");
	}

	@GetMapping(value = "/userAjax/{userName:.+}")
	public String userNameAjax(@PathVariable String userName) {
		System.out.println("Running the userNameAjax()");
		return this.ajaxService.userNameAjax(userName);
	}
	
	@GetMapping(value = "/passwordAjax/{password}")
	public String passwordAjax(@PathVariable String password) {
		System.out.println("running the PasswordAjax()");
		return this.ajaxService.passwordAjax(password);
	}

}
