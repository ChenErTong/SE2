package vo.receiptvo;

import state.ReceiptType;
import vo.CommodityVO;

public class InventoryImportReceiptVO extends ReceiptVO{
	
	public CommodityVO commodityVO;
	public int area;
	public int row;
	public int frame;
	public int position;
	public String transferID;
	public InventoryImportReceiptVO(String id, ReceiptType type, CommodityVO commodityVO, int area, int row, int frame,
			int position,String transferID) {
		super(id, type);
		this.commodityVO = commodityVO;
		this.area = area;
		this.row = row;
		this.frame = frame;
		this.position = position;
		this.transferID = transferID;
	}

	
	

}