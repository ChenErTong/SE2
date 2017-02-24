package po.receiptpo.orderreceiptpo;

import po.receiptpo.ReceiptPO;
import state.CommodityState;
import state.ReceiptType;

/**
 * 中转中心到达单：中转中心编号、出发地、货物到达状态、订单订单号
 * @author czw
 * @version Oct 23, 2015
 */
public class TransferArrivalListPO extends  ReceiptPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String transferCenterID;
	private String departure;
	private String destination;
	private CommodityState state;
	private String orders;
	
	public TransferArrivalListPO(String ID, ReceiptType type,String transferCenterID, String departure, String destination,
			CommodityState state, String orders) {
		super(ID, type );
		this.transferCenterID = transferCenterID;
		this.departure = departure;
		this.destination = destination;
		this.state = state;
		this.orders=orders;
	}
	public String getTransferCenterID() {
		return transferCenterID;
	}
	public void setTransferCenterID(String transferCenterID) {
		this.transferCenterID = transferCenterID;
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
	public CommodityState getState() {
		return state;
	}
	public void setState(CommodityState state) {
		this.state = state;
	}
	public String getOrders() {
		return orders;
	}


	public void setOrders(String orders) {
		this.orders = orders;
	}
	
}