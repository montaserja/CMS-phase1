package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import app.ConnectionPool;
import app.DB;
import constants.DBConstants;
import constants.MsgLog;
import constants.OperationCRUD;
import mapperDao.MyMapperCompanyImp;
import model.db.Company;
import sqlQuery.CompanyQuery;
import sqlQuery.QueryFactory;

public class CompaniesDBDAO implements CompaniesDAO {
	private ConnectionPool connectionPool;

	public CompaniesDBDAO() {
		this.connectionPool = ConnectionPool.getInstance();
	}

	public Boolean isCompanyExists(String email, String password) {
		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.COMPANIES)).selectOneRowTwoConds(DBConstants.COMPANIES , DBConstants.EMAIL
				, DBConstants.PASSWORD,email, password);
		
		Connection con = this.connectionPool.getConnection();
		/*ResultSet rs = DB.excute(sql, con,  MsgLog.msgSuccss(DBConstants.Company, OperationCRUD.Selected),
				MsgLog.msgError(DBConstants.Company, OperationCRUD.Selected), false);*/
		ResultSet rs = DB.excute(sql, con,"","", false);
		if(rs != null)
			return true;
		return false;
	}

	public void addCompany(Company company) {
		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.COMPANIES)).addCompany(company);
		System.out.println(sql);

		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.Company, OperationCRUD.Inserted),
				MsgLog.msgError(DBConstants.Company, OperationCRUD.Inserted), true);

	}

	public void updateCompany(Company company) {
		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.COMPANIES)).updateCompany(company);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.Company, OperationCRUD.Updated),
				MsgLog.msgError(DBConstants.Company, OperationCRUD.Updated), true);

	}

	public void deleteCompany(int companyID) {
		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.COMPANIES))
				.deleteRow(DBConstants.COMPANIES, companyID);
		System.out.println(sql);

		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.Company, OperationCRUD.Deleted),
				MsgLog.msgError(DBConstants.Company, OperationCRUD.Deleted), true);

	}

	public ArrayList<Company> getAllCompanies() {

		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.COMPANIES))
				.selectAllData(DBConstants.COMPANIES);
		System.out.println(sql);

		Connection con = this.connectionPool.getConnection();
		ResultSet rs = DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.COMPANIES, OperationCRUD.Fteched),
				MsgLog.msgError(DBConstants.COMPANIES, OperationCRUD.Fteched), false);

		ArrayList<Company> companies = MyMapperCompanyImp.getInstance().convertResultSetToArrayListOfCompany(rs);
		System.out.println(companies);
		return companies;

	}

	public Company getOneCompany(int companyID) {
		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.COMPANIES))
				.selectOneRow(DBConstants.COMPANIES, DBConstants.ID, companyID);
		System.out.println(sql);
		Connection con = null;

		con = this.connectionPool.getConnection();
		ResultSet rs = DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.Company, OperationCRUD.Fteched),
				MsgLog.msgError(DBConstants.Company, OperationCRUD.Fteched), false);

		Company company = MyMapperCompanyImp.getInstance().convertResultSetToCompany(rs);
		System.out.println(company);
		return company;

	}
	
	public Company getCompanyBystr(String str , DBConstants type) {
		String sql= null;
		
		if(type == DBConstants.NAME)
			sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.COMPANIES))
				.selectOneRowStrVal(DBConstants.COMPANIES, DBConstants.NAME,str );
		else if(type == DBConstants.EMAIL)
			sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.COMPANIES))
			.selectOneRowStrVal(DBConstants.COMPANIES, DBConstants.EMAIL,str );
			
		
		System.out.println(sql);
		
		Connection con = null;

		con = this.connectionPool.getConnection();
		ResultSet rs = DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.Company, OperationCRUD.Selected),
				MsgLog.msgError(DBConstants.Company, OperationCRUD.Selected), false);

		Company company = MyMapperCompanyImp.getInstance().convertResultSetToCompany(rs);
		//System.out.println(company);
		return company;
		
	}
	


}
