package dao;

import java.util.ArrayList;

import constants.DBConstants;
import model.db.Company;

public interface CompaniesDAO {
	
	public Boolean isCompanyExists(String email, String password);

	public void addCompany(Company company);

	public void updateCompany(Company company);

	public void deleteCompany(int companyID);

	public ArrayList<Company> getAllCompanies();

	public Company getOneCompany(int companyID);
	
	public Company getCompanyBystr(String name , DBConstants type);
	
}
