package vo.receiptvo;

import java.util.ArrayList;

/**
 * 装车单：营业厅编号、目的地、车辆代号、监装员、所有订单订单号
 * @author czw
 * @version Oct 23, 2015
 */
public class LoadingListVO extends ReceiptVO{
	
	private String branchID;
	private String destination;
	private String facilityID;
	private String courierName;
	private ArrayList<String> orders;
	
	public LoadingListVO(String ID) {
		super(ID);
	}

	public LoadingListVO(String id, String branchID, String destination, String facilityID, String courierName,
			ArrayList<String> orders) {
		super(id);
		this.branchID = branchID;
		this.destination = destination;
		this.facilityID = facilityID;
		this.courierName = courierName;
		this.orders = orders;
	}

	public String getBranchID() {
		return branchID;
	}

	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(String facilityID) {
		this.facilityID = facilityID;
	}

	public String getCourierName() {
		return courierName;
	}

	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}

	public ArrayList<String> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<String> orders) {
		this.orders = orders;
	}

	
}
