package com.project.service;

public interface VendorAjaxService {

	public String findByEmailAjax(String email);
	
	public String findByGst(String gstNo);
	
	public String findByContactNo(Long contactNo);
	
	public String findByWebsite(String website);
	
}
