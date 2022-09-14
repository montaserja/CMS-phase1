package mapper.infc;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.db.Customer;

public interface MyMapperCustomerInfc {
	
	public ArrayList<Customer> convertResultSetToArrayListOfCustomer(ResultSet rs);

	public Customer convertResultSetToCustomer(ResultSet rs);

}
