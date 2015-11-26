package vo.receiptvo;

import java.util.ArrayList;

import state.ReceiptType;

/**
 * 装车单：营业厅编号、目的地、车辆代号、监装员、所有订单订单号
 * @author czw
 * @version Oct 23, 2015
 */
public class LoadingListVO extends ReceiptVO{
	
	public String branchID;
	public String destination;
	public String facilityID;
	public String courierName;
	public ArrayList<String> orders;
	
	public LoadingListVO(String ID,ReceiptType type) {
		super(ID,type );
	}

	public LoadingListVO(String id, ReceiptType type,String branchID, String destination, String facilityID, String courierName,
			ArrayList<String> orders) {
		super(id, type);
		this.branchID = branchID;
		this.destination = destination;
		this.facilityID = facilityID;
		this.courierName = courierName;
		this.orders = orders;
	}
}
