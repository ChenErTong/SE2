package vo.receiptvo.orderreceiptvo;

import state.CommodityState;
import state.ReceiptType;
import vo.receiptvo.ReceiptVO;

/**
 * 中转中心到达单：中转中心编号、出发地、货物到达状态、订单订单号
 * 
 * @author czw
 * @version Oct 23, 2015
 */
public class TransferArrivalListVO extends ReceiptVO {

	public String transferCenterID;
	public String destination;
	public String departure;
	public CommodityState state;
	public String order;

	public TransferArrivalListVO(String id, ReceiptType type, String transferCenterID, String destination,
			String departure, CommodityState state, String order) {
		super(id, type);
		this.transferCenterID = transferCenterID;
		this.destination = destination;
		this.departure = departure;
		this.state = state;
		this.order = order;
	}

}
