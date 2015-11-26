package po.receiptpo;

import java.util.ArrayList;

import state.PayBillItem;
import state.ReceiptState;
import state.ReceiptType;

/**
 * @author zsq
 * @version Oct 22,2015
 */
public class DebitAndPayBillPO extends ReceiptPO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5827233260131683793L;
	public ReceiptState getState() {
		return state;
	}
	/**serialVersionUID*/
	private double money;
	private String courierID;
	private String date;
	//TODO
	private ArrayList<String> orderNumbers;
	private String payerName;
	private ArrayList<String> bankAccouts; 
	private PayBillItem items;
	private String rentYear;
	private String salaryMonth;
	//TODO
	private ArrayList<String> transListNumber;
	private ReceiptType type;
	private ReceiptState state;
/**
 * @author zsq
 * @version Oct 22,2015
 */
	public DebitAndPayBillPO(String ID,double money,String courierID,ReceiptType type,ArrayList<String> orderNumbers) {
		super(ID,type);
		this.money = money;
		this.courierID = courierID;
		this.type = type;
		this.orderNumbers = orderNumbers;
	}
	
	
	public DebitAndPayBillPO(String ID, ReceiptType type, double money, String payerName, PayBillItem items) {
	super(ID, type);
	this.money = money;
	this.payerName = payerName;
	this.items = items;
}


	/**
	 * @author zsq
	 * @version Oct 22,2015
	 */

	public DebitAndPayBillPO(String ID,double money,String payerName,ArrayList<String>bankAccouts,ReceiptType type,
			String rentYear,String salaryMonth,PayBillItem items,ArrayList<String> transListNumber){
		super(ID,type);
		this.money = money;
		this.payerName = payerName;
		this.bankAccouts = bankAccouts;
		this.rentYear  = rentYear;
		this.salaryMonth = salaryMonth;
		this.items = items;
		this.type = type;
		this.transListNumber = transListNumber;
	}
	
	
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getCourierID() {
		return courierID;
	}

	public void setCourierID(String courierID) {
		this.courierID = courierID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ArrayList<String> getOrderNumbers() {
		return orderNumbers;
	}
	public void setOrderNumbers(ArrayList<String> orderNumbers) {
		this.orderNumbers = orderNumbers;
	}
	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public ArrayList<String> getBankAccouts() {
		return bankAccouts;
	}

	public void setBankAccouts(ArrayList<String> bankAccouts) {
		this.bankAccouts = bankAccouts;
	}

	public PayBillItem getItems() {
		return items;
	}

	public void setItems(PayBillItem items) {
		this.items = items;
	}
	public String getRentYear() {
		return rentYear;
	}

	public void setRentYear(String rentYear) {
		this.rentYear = rentYear;
	}

	public String getSalaryMonth() {
		return salaryMonth;
	}

	public void setSalaryMonth(String salaryMonth) {
		this.salaryMonth = salaryMonth;
	}
	public ArrayList<String> getTransListNumber() {
		return transListNumber;
	}
	public void setTransListNumber(ArrayList<String> transListNumber) {
		this.transListNumber = transListNumber;
	}
	public ReceiptType getType() {
		return type;
	}

	public void setType(ReceiptType type) {
		this.type = type;
	}

	
	
	


}
