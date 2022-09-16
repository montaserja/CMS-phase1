package mapper.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import constants.DBConstants;
import model.db.Coupon;
import model.db.Customer;

public class MyMapperCustomerImp implements mapper.infc.MyMapperCustomerInfc {
	public static MyMapperCustomerImp instance;

	public static MyMapperCustomerImp getInstance() {
		if (instance == null)
			return new MyMapperCustomerImp();
		return instance;
	}

	public ArrayList<Customer> convertResultSetToArrayListOfCustomer(ResultSet rs) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try {
			do {
				customers.add(convertResultSetToCustomer(rs));// first element

			} while (rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	public Customer convertResultSetToCustomer(ResultSet rs) {

		try {
			ArrayList<Coupon> coupons = null;
			return new Customer(rs.getInt(DBConstants.ID.toString()), rs.getString(DBConstants.FIRST_NAME.toString()),
					rs.getString(DBConstants.LAST_NAME.toString()), rs.getString(DBConstants.EMAIL.toString()),
					rs.getString(DBConstants.PASSWORD.toString()), coupons);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(NullPointerException e) {
			//do nothing
		}
		return null;
	}

}
