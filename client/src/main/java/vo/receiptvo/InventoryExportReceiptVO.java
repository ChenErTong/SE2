package vo.receiptvo;

import state.ReceiptType;
import vo.CommodityVO;

public class InventoryExportReceiptVO extends ReceiptVO {
	//中转中心
	public String transferID;
	//货物编号
	public CommodityVO commodityVO;
	//区
	public int area;
	//排
	public int row;
	//架
	public int frame;
	//位
	public int position;
	public InventoryExportReceiptVO(String id, ReceiptType type,
			String transferID, CommodityVO commodityVO, int area, int row, int frame, int position) {
		super(id, type);
		this.transferID=transferID;
		this.commodityVO = commodityVO;
		this.area=area;
		this.row=row;
		this.frame=frame;
		this.position=position;
	}
	
}
