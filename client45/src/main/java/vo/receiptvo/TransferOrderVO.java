package vo.receiptvo;

import java.util.ArrayList;

import state.ReceiptType;

/**
 * 中转单：航班（火车）（汽车车次）编号、出发地、目的地、监装员、托运订单订单号
 * @author czw
 * @version Oct 23, 2015
 */
public class TransferOrderVO extends ReceiptVO {
	private String facilityID;
	private String departure;
	private String destination;
	private String courierName;
	private ArrayList<String> orders;
	
	public TransferOrderVO(String ID,ReceiptType type) {
		super(ID,type);
	}
	public TransferOrderVO(String facilityID, ReceiptType type,String departure, String destination, String courierName,
			ArrayList<String> orders) {
		super(facilityID,type);
		this.facilityID = facilityID;
		this.departure = departure;
		this.destination = destination;
		this.courierName = courierName;
		this.orders = orders;
	}
	public String getFacilityID() {
		return facilityID;
	}
	public void setFacilityID(String facilityID) {
		this.facilityID = facilityID;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
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
