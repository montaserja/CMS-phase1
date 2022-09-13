package mapper.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.db.Coupon;
import model.db.Customer;

public class MyMapperCustomer implements mapper.infc.MyMapperCustomer {

	public ArrayList<Customer> convertResultSetToArrayListOfCustomer(ResultSet rs) {
		ArrayList<Customer> customers = new ArrayList<Customer>();

		return customers;
	}

	public Customer convertResultSetToCustomer(ResultSet rs) {

		try {
			ArrayList<Coupon> coupons = null;
			return new Customer(rs.getInt("ID"), rs.getString("FIRST_NAME"), rs.getString(0), rs.getString(0),
					rs.getString(0), coupons);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
