package App;

public interface  sqlSheltot {
	public final static String CREATE_DB = "CREATE DATABASE COUPONS;";
	public final static String CREATE_COMPANIES = "CREATE TABLE COUPONS.COMPANIES(\r\n"
			+ "ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,\r\n"
			+ "NAME varchar(255),\r\n"
			+ "EMAIL varchar(255),\r\n"
			+ "PASSWORD varchar(255));";
	public final static String CREATE_CUSTOMERS = "CREATE TABLE COUPONS.CUSTOMERS(\r\n"
			+ "ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,\r\n"
			+ "FIRST_NAME varchar(255),\r\n"
			+ "LAST_NAME varchar(255),\r\n"
			+ "EMAIL varchar(255),\r\n"
			+ "PASSWORD varchar(255));";
	public final static String CREATE_CATEGORIES = "CREATE TABLE COUPONS.CATEGORIES(\r\n"
			+ "ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,\r\n"
			+ "NAME varchar(255)\r\n"
			+ ");";
	
	public final static String CREATE_COUPON = "CREATE TABLE COUPONS.COUPON(\r\n"
			+ "ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,\r\n"
			+ "COMPANY_ID int NOT NULL ,\r\n"
			+ "CATEGORIE_ID int NOT NULL ,\r\n"
			+ "TITLE varchar(45) ,\r\n"
			+ "START_DATE DATE,\r\n"
			+ "END_DATE DATE,\r\n"
			+ "AMOUNT int,\r\n"
			+ "PRICE DOUBLE,\r\n"
			+ "IMAGE varchar(255),\r\n"
			+ "DESCRIPTION varchar(255),\r\n"
			+ "FOREIGN KEY (COMPANY_ID) REFERENCES COUPONS.COMPANIES(ID),\r\n"
			+ "FOREIGN KEY (CATEGORIE_ID) REFERENCES COUPONS.CATEGORIES(ID)\r\n"
			+ ");";
	
	public final static String CREATE_CUSTOMERS_VS_COUPONS = "CREATE TABLE COUPONS.CUSTOMERS_VS_COUPONS(\r\n"
			+ "CUSTOMER_ID int NOT NULL ,\r\n"
			+ "COUPON_ID int NOT NULL,\r\n"
			+ "PRIMARY KEY (CUSTOMER_ID,COUPON_ID),\r\n"
			+ "FOREIGN KEY (CUSTOMER_ID) REFERENCES COUPONS.CUSTOMERS(ID),\r\n"
			+ "FOREIGN KEY (COUPON_ID) REFERENCES COUPONS.COUPON(ID)\r\n"
			+ ");";
}
