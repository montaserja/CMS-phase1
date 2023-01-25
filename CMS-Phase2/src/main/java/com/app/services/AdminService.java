package com.app.services;

import java.util.List;

import com.app.exceptions.companyExceptions.CompanyEmailDuplicate;
import com.app.exceptions.companyExceptions.CompanyNameDuplicate;
import com.app.model.Company;
import com.app.model.Coupon;
import com.app.model.Customer;

public interface AdminService {
	public void addCompany(Company company)throws CompanyNameDuplicate,CompanyEmailDuplicate;
	public void updateCompany(Company company);
	public void deleteCompany(Company company);
	public List<Company> getAllCompanies();
	public Company getOneCompany(int companyId);
	public Coupon getCouponById(int couponId);
	public List<Coupon> getAllCoupons();
	public void updateCoupon(int companyId, Coupon coupon);
	public void deleteCoupon(int couponId);
	public void createCustomer(Customer customer);
	public Customer getOneCustomer(int customerId);
	public List<Customer> getAllCustomers();
	public void updateCustomer(Customer customer);
	public void deleteCustomer(long customerId);
}
