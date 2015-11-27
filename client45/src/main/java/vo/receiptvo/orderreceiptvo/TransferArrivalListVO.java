package vo.receiptvo.orderreceiptvo;

import java.util.ArrayList;

import state.CommodityState;
import state.ReceiptType;

/**
 * 中转中心到达单：中转中心编号、出发地、货物到达状态、订单订单号
 * @author czw
 * @version Oct 23, 2015
 */
public class TransferArrivalListVO extends OrderReceiptVO {
	
	public String transferCenterID;
	public String destination;
	public String departure;
	public CommodityState state;
	
	public TransferArrivalListVO(String id, ReceiptType type,String transferCenterID, String destination, String departure,
			CommodityState state, ArrayList<String> orders) {
		super(id,type,orders);
		this.transferCenterID = transferCenterID;
		this.destination = destination;
		this.departure = departure;
		this.state = state;
	}


}