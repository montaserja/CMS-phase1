package com.app.controllers;

import java.util.List;

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
	
	@PostMapping(value = "/companies" )
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
	
	@GetMapping(value = "/companies/{companyId}")
	@ResponseBody
	public ResponseEntity<?> getCompanyById(@PathVariable("companyId") int companyId){
		try {
			Company company = adminService.getOneCompany(companyId);
			return new ResponseEntity<>(company , HttpStatus.OK);
		} catch (CouponSystemException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} 
	}
	
	@GetMapping(value = "/companies")
	@ResponseBody
	public ResponseEntity<?> getAllCompanies(){
		List<Company> companies = adminService.getAllCompanies();
		return new ResponseEntity<>(companies , HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/companies/{companyId}")
	@ResponseBody
	public ResponseEntity<?> deleteCompany(@PathVariable("companyId") int companyId){
		try {
			adminService.deleteCompany(companyId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (CouponSystemException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} 
	}
	
	@PutMapping(value = "/companies")
	public ResponseEntity<?> updateCompany(@RequestBody Company company){
		try {
			adminService.updateCompany(company);
			return new ResponseEntity<>(company , HttpStatus.OK);
		} catch (CouponSystemException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} 
	}
	
	

}
