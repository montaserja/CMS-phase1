package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import app.ConnectionPool;
import app.DB;
import constants.DBConstants;
import constants.MsgLog;
import constants.OperationCRUD;
import mapperDao.MyMapperCustomerImp;
import model.db.Customer;
import sqlQuery.CustomerQuery;
import sqlQuery.QueryFactory;

public class CustomersDBDAO implements CustomersDAO {
	private ConnectionPool connectionPool;

	public CustomersDBDAO() {
		this.connectionPool = ConnectionPool.getInstance();
	}

	public Boolean isCustomerExists(String email, String password) {
		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS)).selectOneRowTwoConds(DBConstants.CUSTOMERS , DBConstants.EMAIL
				, DBConstants.PASSWORD,email, password);
		
		Connection con = this.connectionPool.getConnection();
		/*ResultSet rs = DB.excute(sql, con,  MsgLog.msgSuccss(DBConstants.Customer, OperationCRUD.Selected),
				MsgLog.msgError(DBConstants.Customer, OperationCRUD.Selected), false);*/
		ResultSet rs = DB.excute(sql, con, "","", false);
		if(rs != null)
			return true;
		return false;
	}

	public void addCustomer(Customer customer) {

		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS)).addCustomer(customer);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.Customer, OperationCRUD.Inserted),
				MsgLog.msgError(DBConstants.Customer, OperationCRUD.Inserted), true);

	}

	public void updateCustomer(Customer customer) {
		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS)).updateCustomer(customer);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.Customer, OperationCRUD.Updated),
				MsgLog.msgError(DBConstants.Customer, OperationCRUD.Updated), true);
	}

	public void deleteCustomer(int customerID) {
		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS))
				.deleteRow(DBConstants.CUSTOMERS, customerID);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con,MsgLog.msgSuccss(DBConstants.Customer, OperationCRUD.Deleted),
				MsgLog.msgError(DBConstants.Customer, OperationCRUD.Deleted), true);
	}

	public ArrayList<Customer> getAllCustomers() {

		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS))
				.selectAllData(DBConstants.CUSTOMERS);
		System.out.println(sql);

		Connection con = this.connectionPool.getConnection();

		ResultSet rs = DB.excute(sql, con,MsgLog.msgSuccss(DBConstants.CUSTOMERS, OperationCRUD.Fteched),
				MsgLog.msgError(DBConstants.CUSTOMERS, OperationCRUD.Fteched), false);

		ArrayList<Customer> customers = MyMapperCustomerImp.getInstance().convertResultSetToArrayListOfCustomer(rs);
		System.out.println(customers);
		return customers;
	}

	public Customer getOneCustomer(int customerID) {

		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS))
				.selectOneRow(DBConstants.CUSTOMERS, DBConstants.ID, customerID);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();

		ResultSet rs = DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.Customer, OperationCRUD.Fteched),
				MsgLog.msgError(DBConstants.Customer, OperationCRUD.Fteched), false);

		Customer customer = MyMapperCustomerImp.getInstance().convertResultSetToCustomer(rs);
		//System.out.println(customer);
		return customer;

	}
	
	public Customer getCustomerByEmail(String email) {
		String sql= ((CustomerQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS))
			.selectOneRowStrVal(DBConstants.CUSTOMERS, DBConstants.EMAIL,email );
			
		
		System.out.println(sql);
		
		Connection con = null;

		con = this.connectionPool.getConnection();
		ResultSet rs = DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.Customer, OperationCRUD.Selected),
				MsgLog.msgError(DBConstants.Customer, OperationCRUD.Selected), false);

		Customer customer = MyMapperCustomerImp.getInstance().convertResultSetToCustomer(rs);
		System.out.println(customer);
		return customer;
		
	}
	
	
	

}
