package vo.receiptvo.orderreceiptvo;

import java.util.ArrayList;

import state.CommodityState;
import state.ReceiptType;

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
public class BranchArrivalListVO extends OrderReceiptVO {

	public String transferListID;
	public String departure;
	public CommodityState state;

	public BranchArrivalListVO(String id, ReceiptType type, String transferListID, String departure,
			CommodityState state, ArrayList<String> orders) {
		super(id, type, orders);
		this.transferListID = transferListID;
		this.departure = departure;
		this.state = state;
	}

}