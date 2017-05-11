package crunch.kevin.springmvc.dao;

import java.util.Date;
import java.util.List;

import crunch.kevin.springmvc.javabean.Payments;

public interface PaymentsDao {

	public void newPayment(Payments payment);
	public List<Payments> getPaymentbyCustomerNumber(int number);
	public List<Payments> getPaymentbyPaymentDate(Date date);
	
}
