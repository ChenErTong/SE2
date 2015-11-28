package vo.receiptvo.orderreceiptvo;

import java.util.ArrayList;

import state.ReceiptType;

/**
 * 中转单：航班（火车）（汽车车次）编号、出发地、目的地、监装员、托运订单订单号
 * @author czw
 * @version Oct 23, 2015
 */
public class TransferOrderVO extends OrderReceiptVO {
	public String facilityID;
	public String departure;
	public String destination;
	public String courierName;
	
	public TransferOrderVO(String ID,String facilityID, ReceiptType type,String departure, String destination, String courierName,
			ArrayList<String> orders) {
		super(facilityID,type,orders);
		this.facilityID = facilityID;
		this.departure = departure;
		this.destination = destination;
		this.courierName = courierName;
		this.orders = orders;
	}

}
