package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Company;
import com.app.services.AdminService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	
	private final AdminService adminService;

	@Autowired
    AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
	
	@RequestMapping(value = "/addCompany" , method = RequestMethod.POST)
	public @ResponseBody String addCompany(@RequestBody Company company) {
		return null;
		
	}

}
