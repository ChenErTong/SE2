package vo.receiptvo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import state.PayBillItem;
import state.ReceiptState;
import state.ReceiptType;
import vo.ValueObject;

public class DebitAndPayBillVO  extends ValueObject{
	public String ID;
	public double money;
	/**收款快递员的用户ID*/
	public String courierID;
	/**收款或者收款日期，系统自动生成*/
	public String date;
	/**对应快递订单条形码号*/
	//TODO

	public ArrayList <String>orderNumbers;

	/**付款人*/
	public String payerName;
	/**付款账户*/
	public ArrayList<String> bankAccouts; 
	/**条目*/
	public PayBillItem items;
	/**备注*/
	public String rentYear;
	public String salaryMonth;
	//TODO
	public ArrayList<String> transListNumber;
	/**区分收款单和付款单*/
	public ReceiptType type;
	/**单据状态*/
	public ReceiptState state;
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
	public DebitAndPayBillVO(String ID,double money,String courierID,ReceiptType type,ArrayList<String> orderNumbers) {
		this.ID = ID;
		this.money = money;
		this.courierID = courierID;
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

	public DebitAndPayBillVO(String ID,double money,String payerName,ArrayList<String>bankAccouts,ReceiptType type,

			String rentYear,String salaryMonth,PayBillItem items,ArrayList<String> transListNumber){
		this.ID = ID;
		this.money = money;
		this.payerName = payerName;
		this.bankAccouts = bankAccouts;
		this.rentYear  = rentYear;
		this.salaryMonth = salaryMonth;
		this.items = items;
		this.type = type;
		this.transListNumber = transListNumber;
		/**自动生成日期*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm--dd HH:mm");
		date = sdf.format(new Date());
	}

	
}
