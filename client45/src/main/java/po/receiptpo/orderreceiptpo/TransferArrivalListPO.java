package po.receiptpo.orderreceiptpo;

import java.util.ArrayList;

import state.CommodityState;
import state.ReceiptType;

/**
 * 中转中心到达单：中转中心编号、出发地、货物到达状态、订单订单号
 * @author czw
 * @version Oct 23, 2015
 */
public class TransferArrivalListPO extends OrderReceiptPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String transferCenterID;
	private String departure;
	private String destination;
	private CommodityState state;
	
	public TransferArrivalListPO(String ID, ReceiptType type,String transferCenterID, String departure, String destination,
			CommodityState state, ArrayList<String> orders) {
		super(ID, type,orders);
		this.transferCenterID = transferCenterID;
		this.departure = departure;
		this.destination = destination;
		this.state = state;
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

	
}