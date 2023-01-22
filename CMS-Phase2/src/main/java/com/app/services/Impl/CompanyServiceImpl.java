package com.app.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Company;
import com.app.repositories.CompanyRepository;
import com.app.services.CompanyService;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepo;
	
	
	public CompanyServiceImpl(final CompanyRepository companyRepo) {
		this.companyRepo = companyRepo;
	}
	
	@Override
	@Transactional
	public boolean isCompanyExist(String email,String password) {
		return companyRepo.findByEmailAndPassword(email, password);
	}
	
	@Override
	@Transactional
	public void addCompany(Company company) {
		companyRepo.save(company);
	}
	
	@Override
	@Transactional
	public void updateCompany(Company company) {
		Optional<Company> companyToUpdate = companyRepo.findById(company.getId());
		if(companyToUpdate.isPresent()) {
			companyToUpdate.get().setEmail(company.getEmail());
			companyToUpdate.get().setName(company.getName());
			companyToUpdate.get().setPassword(company.getPassword());
			companyToUpdate.get().setCoupon(company.getCoupon());
			companyRepo.save(companyToUpdate.get());
		}
	}
	
	@Override
	@Transactional
	public void deleteCompany(Company company) {
		Optional<Company> companyToDelete = companyRepo.findById(company.getId());
		if(companyToDelete.isPresent()) {
			companyRepo.delete(companyToDelete.get());
		}
		
	}
	
	@Override
	@Transactional
	public List<Company> getAllCompanies(){
		return companyRepo.findAll();
		
	}
	
	@Override
	@Transactional
	public Company getOneCompany(int companyId) {
		return companyRepo.findById(companyId).get();
	}

	
	
	
}
