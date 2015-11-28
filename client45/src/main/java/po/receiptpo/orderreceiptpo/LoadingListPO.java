package po.receiptpo.orderreceiptpo;

import java.util.ArrayList;

import state.ReceiptType;

/**
 * 装车单：营业厅编号、汽运编号、目的地、车辆代号、监装员、押运员，所有订单订单号
 * @author czw
 * @version Oct 23, 2015
 */
public class LoadingListPO extends OrderReceiptPO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String branchID;
	private String transferNumber;
	private String distination;
	private String carID;
	private String monitorName;
	private String courierName;
	private double money;

	public LoadingListPO(String ID, ReceiptType type, String branchID, String transferNumber, String distination,
			String carID, String monitorName, String courierName, ArrayList<String> orders, double money) {
		super(ID, type,orders);
		this.branchID = branchID;
		this.transferNumber = transferNumber;
		this.distination = distination;
		this.carID = carID;
		this.monitorName = monitorName;
		this.courierName = courierName;
		this.money = money;
	}

	public String getBranchID() {
		return branchID;
	}

	public String getTransferNumber() {
		return transferNumber;
	}

	public String getDistination() {
		return distination;
	}

	public String getCarID() {
		return carID;
	}

	public String getMonitorName() {
		return monitorName;
	}

	public String getCourierName() {
		return courierName;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
}
