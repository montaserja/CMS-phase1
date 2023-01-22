package com.app.services;

import java.util.List;

import com.app.model.Company;

public interface CompanyService {
	public boolean isCompanyExist(String email,String password) ;
	public void addCompany(Company company);
	public void updateCompany(Company company);
	public void deleteCompany(Company company);
	public List<Company> getAllCompanies();
	public Company getOneCompany(int companyId);

}
