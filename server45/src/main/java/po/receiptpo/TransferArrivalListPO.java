package po.receiptpo;

import java.util.ArrayList;

import state.CommodityState;

/**
 * 中转中心到达单：中转中心编号、出发地、货物到达状态、订单订单号
 * @author czw
 * @version Oct 23, 2015
 */
public class TransferArrivalListPO extends ReceiptPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String transferCenterID;
	private String departure;
	private CommodityState state;
	private ArrayList<String> orders;
	public TransferArrivalListPO(String id) {
		super(id);
	}
	public TransferArrivalListPO(String ID, String transferCenterID, String departure, CommodityState state,
			ArrayList<String> orders) {
		super(ID);
		this.transferCenterID = transferCenterID;
		this.departure = departure;
		this.state = state;
		this.orders = orders;
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
	public CommodityState getState() {
		return state;
	}
	public void setState(CommodityState state) {
		this.state = state;
	}
	public ArrayList<String> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<String> orders) {
		this.orders = orders;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
