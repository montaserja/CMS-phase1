package com.app.model.utilities;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.exceptions.companyExceptions.CompanyEmailDuplicate;
import com.app.exceptions.companyExceptions.CompanyNameDuplicate;
import com.app.model.Company;
import com.app.repositories.CompanyRepository;

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
}
