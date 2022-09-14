package model.db;

public class CustomerVsCoupon {
	private int id;
	private int customerID;
	private int couponID;
	@Override
	public String toString() {
		return "CustomerVsCoupon [id=" + id + ", customerID=" + customerID + ", couponID=" + couponID + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getCouponID() {
		return couponID;
	}
	public void setCouponID(int couponID) {
		this.couponID = couponID;
	}
	public CustomerVsCoupon(int id, int customerID, int couponID) {
		super();
		this.id = id;
		this.customerID = customerID;
		this.couponID = couponID;
	}
	
	

}
