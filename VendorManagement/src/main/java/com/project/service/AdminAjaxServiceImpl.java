package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.AdminControlEntity;
import com.project.repository.AdminServiceRepository;

@Service(value = "adminservice")
public class AdminAjaxServiceImpl implements AdminAjaxService {

	@Autowired
	private AdminServiceRepository repository;

	public AdminAjaxServiceImpl() {
		System.out.println("Creating the AdminAjaxService");
	}

	@Override
	public String userNameAjax(String userName) {
		System.out.println("invoking the userNameAjax()");
		List<AdminControlEntity> entity = this.repository.findAll();
		for (AdminControlEntity adminControlEntity : entity) {
			if(adminControlEntity.getUserName().equals(userName)) {
				return "";
			}
		}
		return "*User Does't Exist";
	}

	@Override
	public String passwordAjax(String password) {
		System.out.println("invoking the passwordAjax()");
		List<AdminControlEntity> entity = this.repository.findAll();
		for (AdminControlEntity adminControlEntity : entity) {
			if(adminControlEntity.getPassword().equals(password)) {
				return "";
			}
		}
		return "*Incorrect password";
	}

}
