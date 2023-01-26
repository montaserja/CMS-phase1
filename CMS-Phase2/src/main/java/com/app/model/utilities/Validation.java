package com.app.model.utilities;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.exceptions.companyExceptions.CompanyEmailDuplicate;
import com.app.exceptions.companyExceptions.CompanyNameDuplicate;
import com.app.exceptions.companyExceptions.CompanyNotExist;
import com.app.exceptions.couponsExceptions.CouponNotExist;
import com.app.model.Company;
import com.app.model.Coupon;
import com.app.repositories.CompanyRepository;
import com.app.repositories.CouponRepository;

@Component
public interface Validation {
	default void isCompanyNameDuplicate(String companyName,CompanyRepository comapnyRepo) throws CompanyNameDuplicate{
		Optional<Company> company = comapnyRepo.findByName(companyName);
		if(company.isPresent()) {
			throw new CompanyNameDuplicate("Company Name : " + companyName + " already exist");
		}
	}
	
	default void isCompanyEmailDuplicate(String companyEmail,CompanyRepository comapnyRepo) throws CompanyEmailDuplicate{
		Optional<Company> company = comapnyRepo.findByEmail(companyEmail);
		if(company.isPresent()) {
			throw new CompanyEmailDuplicate("Company Email : " + companyEmail + " already exist");
		}
	}
	
	default void isCompanyExists(int companyId , CompanyRepository companyRepo) throws CompanyNotExist{
		Optional<Company> company = companyRepo.findById(companyId);
		
		if(!company.isPresent()) {
			throw new CompanyNotExist("Company with ID : " + companyId + " does not exist!!");
		}
	}
	
	default void isCouponExists(int couponId , CouponRepository couponRepo) throws CouponNotExist{
		Optional<Coupon> coupon = couponRepo.findById(couponId);
		if(!coupon.isPresent()) {
			throw new CouponNotExist("Coupon id not exist!!");
		}
	}
}
