package com.app.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.CmsPhase2Application;
import com.app.exceptions.CouponSystemException;
import com.app.exceptions.companyExceptions.CompanyEmailDuplicate;
import com.app.exceptions.companyExceptions.CompanyNameDuplicate;
import com.app.model.Company;
import com.app.services.AdminService;
import com.app.services.Impl.AdminServiceImpl;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(AdminServiceImpl.class);
	
	private final AdminService adminService;

	@Autowired
    AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
	
	@PostMapping(value = "/addCompany" )
	@ResponseBody
	public ResponseEntity<?> addCompany(@RequestBody Company company) {
		try {
			adminService.addCompany(company);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (CouponSystemException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} 
		
		
		
	}
	
	
	@RequestMapping(value = "/a" , method = RequestMethod.GET)
	@ResponseBody
	public String a() {
		
		Logger logger = (Logger) LoggerFactory.getLogger(CmsPhase2Application.class);
		logger.info("aaaaaaaaaaaaaaaaaaaaaaaaaaa");

		return "OK";
		
	}

}
