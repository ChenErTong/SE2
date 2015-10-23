package po;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.receiptpo.ReceiptPO;
import state.PayBillItem;
import state.ReceiptState;
import state.ReceiptType;

/**
 * �տ�͸���ĳ־û�����
 * @author zsq
 * @version Oct 22,2015
 */
public class DebtAndPayBillPO extends ReceiptPO{
	/**serialVersionUID*/
	private static final long serialVersionUID = 1L;
	/**�տ�򸶿���*/
	private double money;
	/**�տ���Ա���û�ID*/
	private String courierID;
	/**�տ�����տ����ڣ�ϵͳ�Զ�����*/
	private String date;
	/**��Ӧ��ݶ����������*/
	//TODO
	private ArrayList orderNumbers;
	/**������*/
	private String payerName;
	/**�����˻�*/
	private ArrayList<BankPO> bankAccouts; 
	/**��Ŀ*/
	private PayBillItem items;
	/**��ע*/
	private String rentYear;
	private String salaryMonth;
	//TODO
	private ArrayList transListNumber;
	/**�����տ�͸��*/
	private ReceiptType type;
	/**����״̬*/
	private ReceiptState state;
/**
 * �����տ������
 * @param ID �տID
 * @param money �տ���
 * @param courierID �տ���Ա
 * @param state ����״̬
 * @param type ��������
 * @param orderNumbers ���տ���������ж����������
 * @author zsq
 * @version Oct 22,2015
 */
	public DebtAndPayBillPO(String ID,double money,String courierID,ReceiptType type,ArrayList orderNumbers) {
		super(ID);
		this.money = money;
		this.courierID = courierID;
		this.state = ReceiptState.APPROVALING;
		this.type = type;
		this.orderNumbers = orderNumbers;
		// TODO Auto-generated constructor stub
		/**�Զ���������*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm--dd HH:mm");
		date = sdf.format(new Date());
	}
	/**
	 * �������������
	 * @param ID ���ID
	 * @param money ������
	 * @param payerName ����������
	 * @param bankAccouts �����˺�
	 * @param type ��������
	 * @param rentYear ���ע�������Ǵ���Ŀ��ΪNULL
	 * @param salaryMonth нˮ��ע�������Ǵ���Ŀ��ΪNULL
	 * @param items ������Ŀ
	 * @param transListNumber �˵��ű�ע�������Ǵ���Ŀ��ΪNULL
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public DebtAndPayBillPO(String ID,double money,String payerName,ArrayList<BankPO>bankAccouts,ReceiptType type,
			String rentYear,String salaryMonth,PayBillItem items,ArrayList transListNumber){
		super(ID);
		this.money = money;
		this.payerName = payerName;
		this.bankAccouts = bankAccouts;
		this.rentYear  = rentYear;
		this.salaryMonth = salaryMonth;
		this.items = items;
		this.type = type;
		this.state = ReceiptState.APPROVALING;
		this.transListNumber = transListNumber;
		/**�Զ���������*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm--dd HH:mm");
		date = sdf.format(new Date());
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

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public ArrayList<BankPO> getBankAccouts() {
		return bankAccouts;
	}

	public void setBankAccouts(ArrayList<BankPO> bankAccouts) {
		this.bankAccouts = bankAccouts;
	}

	public PayBillItem getItems() {
		return items;
	}

	public void setItems(PayBillItem items) {
		this.items = items;
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

	public void setState(ReceiptState state) {
		this.state = state;
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
}