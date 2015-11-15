package vo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.BankPO;
import state.PayBillItem;
import state.ReceiptState;
import state.ReceiptType;

public class DebitAndPayBillVO {
	private String ID;
	private double money;
	/**收款快递员的用户ID*/
	private String courierID;
	/**收款或者收款日期，系统自动生成*/
	private String date;
	/**对应快递订单条形码号*/
	//TODO
	private ArrayList orderNumbers;
	/**付款人*/
	private String payerName;
	/**付款账户*/
	private ArrayList<BankPO> bankAccouts; 
	/**条目*/
	private PayBillItem items;
	/**备注*/
	private String rentYear;
	private String salaryMonth;
	//TODO
	private ArrayList transListNumber;
	/**区分收款单和付款单*/
	private ReceiptType type;
	/**单据状态*/
	private ReceiptState state;
/**
 * 建立收款单构造器
 * @param ID 收款单ID
 * @param money 收款金额
 * @param courierID 收款快递员
 * @param state 单据状态
 * @param type 单据类型
 * @param orderNumbers 此收款单包含的所有订单条形码号
 * @author zsq
 * @version Oct 22,2015
 */
	public DebitAndPayBillVO(String ID,double money,String courierID,ReceiptType type,ArrayList orderNumbers) {
		this.ID = ID;
		this.money = money;
		this.courierID = courierID;
		this.state = ReceiptState.APPROVALING;
		this.type = type;
		this.orderNumbers = orderNumbers;
		// TODO Auto-generated constructor stub
		/**自动生成日期*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm--dd HH:mm");
		date = sdf.format(new Date());
		
	}
	/**
	 * 建立付款单构造器
	 * @param ID 付款单ID
	 * @param money 付款金额
	 * @param payerName 付款人姓名
	 * @param bankAccouts 付款账号
	 * @param type 单据类型
	 * @param rentYear 租金备注，当不是此条目下为NULL
	 * @param salaryMonth 薪水备注，当不是此条目下为NULL
	 * @param items 付款条目
	 * @param transListNumber 运单号备注，当不是此条目下为NULL
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public DebitAndPayBillVO(String ID,double money,String payerName,ArrayList<BankPO>bankAccouts,ReceiptType type,
			String rentYear,String salaryMonth,PayBillItem items,ArrayList transListNumber){
		this.ID = ID;
		this.money = money;
		this.payerName = payerName;
		this.bankAccouts = bankAccouts;
		this.rentYear  = rentYear;
		this.salaryMonth = salaryMonth;
		this.items = items;
		this.type = type;
		this.state = ReceiptState.APPROVALING;
		this.transListNumber = transListNumber;
		/**自动生成日期*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm--dd HH:mm");
		date = sdf.format(new Date());
	}
	public double getMoney() {
		return money;
	}
	
	public String getCourierID() {
		return courierID;
	}

	public String getDate() {
		return date;
	}
	
	public String getPayerName() {
		return payerName;
	}
	
	public ArrayList<BankPO> getBankAccouts() {
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
	
	public ArrayList getTransListNumber() {
		return transListNumber;
	}
	
	public ReceiptType getType() {
		return type;
	}
	
	public ReceiptState getState() {
		return state;
	}
	public String getID() {
		return ID;
	}

	
}
