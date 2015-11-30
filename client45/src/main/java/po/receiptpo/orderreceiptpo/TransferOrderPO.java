package po.receiptpo.orderreceiptpo;

import java.util.ArrayList;

import state.ReceiptType;

/**
 * 中转单：航班（火车）（汽车车次）编号、出发地、目的地、监装员、托运订单订单号
 * @author czw
 * @version Oct 23, 2015
 */
public class TransferOrderPO extends  OrderReceiptPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String facilityID;
	private String departure;
	private String destination;
	private String courierName;
	
	public TransferOrderPO(String ID, ReceiptType type,String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders) {
		super(ID, type,orders );
		this.facilityID = facilityID;
		this.departure = departure;
		this.destination = destination;
		this.courierName = courierName;
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

}
