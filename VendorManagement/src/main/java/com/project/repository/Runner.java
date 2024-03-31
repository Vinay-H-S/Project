package com.project.repository;

public class Runner {

	public static void main(String[] args) {
		
		AdminServiceRepository adminServiceRepository=new AdminServiceRepositoryImpl();
		adminServiceRepository.updateUpdateByAndUpdatedDate(2);
		
		
	}
	
}
