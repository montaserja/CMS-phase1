package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.CouponsDAO;
import dao.CouponsDBDAO;

public class CouponExpirationDailyJob implements Runnable {
	private CouponsDAO couponDAO;
	private boolean quit;

	public CouponExpirationDailyJob() {
		this.quit = false;
		this.couponDAO = new CouponsDBDAO();
	}

	@Override
	public void run() {

		synchronized (this) {
			this.quit = false;

			while (!quit) {
				try {
					Thread.sleep(24 * 1000 * 60 * 60);//24 hours
					Date date = new Date();
					SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
					String currDateStr = sdformat.format(date);

					Date currDate = sdformat.parse(currDateStr);

					System.out.println(currDate);

					System.out.println("Coupon Exipred Task is started...");
					this.couponDAO.deleteExpirationCoupon(currDateStr);

				} catch (ParseException e) {
					System.out.print(e.getMessage());
				} catch (InterruptedException e) {

					System.out.print(e.getMessage());

				}

			}

		}
	}

	public void stop() {
		this.quit = true;
		System.out.println("Coupon Exipred Task is stopped.");
	}
}
