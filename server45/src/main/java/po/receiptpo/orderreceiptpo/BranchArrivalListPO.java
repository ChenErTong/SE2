package po.receiptpo.orderreceiptpo;

import po.receiptpo.ReceiptPO;
import state.CommodityState;
import state.ReceiptType;

/**
 * 营业厅到达单：中转单编号、出发地、货物到达状态、订单订单号
 * @author czw
 * @version Oct 23, 2015
 */
public class BranchArrivalListPO extends  ReceiptPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String transferListID;
	private String departure;
	private CommodityState state;
	private String orders;
	
	public BranchArrivalListPO(String ID, ReceiptType type,String transferListID, String departure, 
			CommodityState state, String orders) {
		super(ID, type );
		this.transferListID = transferListID;
		this.departure = departure;
		this.state = state;
		this.orders=orders;
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


	public String getOrders() {
		return orders;
	}


	public void setOrders(String orders) {
		this.orders = orders;
	}

}
