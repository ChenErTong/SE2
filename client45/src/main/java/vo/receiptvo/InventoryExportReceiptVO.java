package vo.receiptvo;

import state.ExpressType;
import state.ReceiptType;

public class InventoryExportReceiptVO extends ReceiptVO {
	/**目的地**/
	public String destination;
	//出发地
	public String depture;
	/**装运形式**/
	public ExpressType expressType;
	//装运编号
	public String TransferID;
	//货物编号
	public String CommoditiesID;
	//区
	public int area;
	//排
	public int row;
	//架
	public int frame;
	//位
	public int position;
	public InventoryExportReceiptVO(String id, ReceiptType type, String destination, String depture, ExpressType expressType,
			String transferID, String commoditiesID, int area, int row, int frame, int position) {
		super(id, type);
		this.destination = destination;
		this.depture = depture;
		this.expressType=expressType;
		this.TransferID = transferID;
		this.CommoditiesID = commoditiesID;
		this.area=area;
		this.row=row;
		this.frame=frame;
		this.position=position;
	}
	
}
