package vo.receiptvo;

import java.util.ArrayList;

import state.CommodityState;

/**
 * 营业厅到达单：中转单编号、出发地、货物到达状态、订单订单号
 * @author czw
 * @version Oct 23, 2015
 */
/**
 * 
 * @author Ann
 * @version Oct 25,2015
 */
public class BranchArrivalListVO extends ReceiptVO {
	
	private String transferListID;
	private String departure;
	private CommodityState state;
	private ArrayList<String> orders;
	
	public BranchArrivalListVO(String id, String transferListID, String departure, CommodityState state,
			ArrayList<String> orders) {
		super(id);
		this.transferListID = transferListID;
		this.departure = departure;
		this.state = state;
		this.orders = orders;
	}

	public String getTransferListID() {
		return transferListID;
	}

	public void setTransferListID(String transferListID) {
		this.transferListID = transferListID;
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
	
	

}
