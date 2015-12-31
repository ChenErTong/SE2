package vo.receiptvo.orderreceiptvo;

import java.math.BigDecimal;
import java.util.ArrayList;

import state.ReceiptType;

/**
 * 装车单：营业厅编号、汽运编号、目的地、车辆代号、监装员、押运员，所有订单订单号
 * @author czw
 * @version Oct 23, 2015
 */
public class LoadingListVO extends OrderReceiptVO{
	
	public String branchID;
	public String transferNumber;
	public String distination;
	public String carID;
	public String monitorName;
	public BigDecimal money;
	
	public LoadingListVO(String id, ReceiptType type, String branchID, String transferNumber,
			String distination, String carID, String monitorName, ArrayList<String> orders, BigDecimal money) {
		super(id, type, orders);
		this.branchID = branchID;
		this.transferNumber = transferNumber;
		this.distination = distination;
		this.carID = carID;
		this.monitorName = monitorName;
		this.money = money;
	}
	
}
