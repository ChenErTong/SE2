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

	private double money;

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
	this.type=type;
	this.items = items;
}
	public DebitAndPayBillPO(String ID, ReceiptType type) {
		super(ID, type);
	}




	public DebitAndPayBillPO(String iD, double money2, String payerName2, ArrayList<String> bankAccouts2,
			ReceiptType type2, String rentYear2, String salaryMonth2, PayBillItem items2,
			ArrayList<String> transListNumber2) {
		super(iD, type2);
	}
	
	




	public String getCourierID() {
		return courierID;
	}




	public ArrayList<String> getOrderNumbers() {
		return orderNumbers;
	}




	public String getPayerName() {
		return payerName;
	}




	public ArrayList<String> getBankAccouts() {
		return bankAccouts;
	}




	public PayBillItem getItems() {
		return items;
	}




	public String getRentYear() {
		return rentYear;
	}




	public String getSalaryMonth() {
		return salaryMonth;
	}




	public ArrayList<String> getTransListNumber() {
		return transListNumber;
	}




	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ReceiptType getType() {
		return type;
	}

	public void setType(ReceiptType type) {
		this.type = type;
	}
	public ReceiptState getState() {
		return state;
	}
	
	private String courierID;
	private ArrayList<String> orderNumbers;
	private String payerName;
	private ArrayList<String> bankAccouts; 
	private PayBillItem items;
	private String rentYear;
	private String salaryMonth;
	//TODO
	private ArrayList<String> transListNumber;


}
