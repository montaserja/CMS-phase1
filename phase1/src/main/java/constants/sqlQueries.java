package constants;

public interface sqlQueries {
	public final static String nameDB = "CMS";
	public final static String CREATE_DB = "CREATE DATABASE " + nameDB + ";";
	public final static String CREATE_COMPANIES = "CREATE TABLE CMS.COMPANIES(\r\n"
			+ "ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,\r\n" + "NAME varchar(255),\r\n" + "EMAIL varchar(255),\r\n"
			+ "PASSWORD varchar(255));";
	public final static String CREATE_CUSTOMERS = "CREATE TABLE CMS.CUSTOMERS(\r\n"
			+ "ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,\r\n" + "FIRST_NAME varchar(255),\r\n"
			+ "LAST_NAME varchar(255),\r\n" + "EMAIL varchar(255),\r\n" + "PASSWORD varchar(255));";
	public final static String CREATE_CATEGORIES = "CREATE TABLE CMS.CATEGORIES(\r\n"
			+ "ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,\r\n" + "NAME varchar(255)\r\n" + ");";

	public final static String CREATE_COUPON = "CREATE TABLE CMS.COUPONS(\r\n"
			+ "ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,\r\n" + "COMPANY_ID int NOT NULL ,\r\n"
			+ "CATEGORY_ID int NOT NULL ,\r\n" + "TITLE varchar(45) ,\r\n" + "START_DATE DATE,\r\n"
			+ "END_DATE DATE,\r\n" + "AMOUNT int,\r\n" + "PRICE DOUBLE,\r\n" + "IMAGE varchar(255),\r\n"
			+ "DESCRIPTION varchar(255),\r\n" + "FOREIGN KEY (COMPANY_ID) REFERENCES CMS.COMPANIES(ID),\r\n"
			+ "FOREIGN KEY (CATEGORY_ID) REFERENCES CMS.CATEGORIES(ID)\r\n" + ");";

	public final static String CREATE_CUSTOMERS_VS_COUPONS = "CREATE TABLE CMS.CUSTOMERS_VS_COUPONS(\r\n"
			+ "CUSTOMER_ID int NOT NULL ,\r\n" + "COUPON_ID int NOT NULL,\r\n"
			+ "PRIMARY KEY (CUSTOMER_ID,COUPON_ID),\r\n" + "FOREIGN KEY (CUSTOMER_ID) REFERENCES CMS.CUSTOMERS(ID),\r\n"
			+ "FOREIGN KEY (COUPON_ID) REFERENCES CMS.COUPONS(ID)\r\n" + ");";

	public final static String DELETE_CATEGORIES = "DROP DATABASE CMS.CATEGORIES;";
	public final static String CATEGORY_1 = "INSERT INTO CMS.CATEGORIES (NAME)VALUES(\"food\");";
	public final static String CATEGORY_2 = "INSERT INTO CMS.CATEGORIES (NAME)VALUES(\"appliances\");";
	public final static String CATEGORY_3 = "INSERT INTO CMS.CATEGORIES (NAME)VALUES(\"vacations\");";
	public final static String CATEGORY_4 = "INSERT INTO CMS.CATEGORIES (NAME)VALUES(\"restaurants\");";

}
