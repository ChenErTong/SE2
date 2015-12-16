package vo.receiptvo.orderreceiptvo;

import state.CommodityState;
import state.ReceiptType;
import vo.receiptvo.ReceiptVO;

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
 
	
	public String transferListID;
	public String departure;
	public CommodityState state;
	public String orderID;

	public BranchArrivalListVO(String id, ReceiptType type, String transferListID, String departure,
			CommodityState state, String orderID) {
		super(id, type);
		this.transferListID = transferListID;
		this.departure = departure;
		this.state = state;
		this.orderID=orderID;
	}

}
