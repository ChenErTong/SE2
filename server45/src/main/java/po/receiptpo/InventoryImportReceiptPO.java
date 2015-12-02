package po.receiptpo;

import po.CommodityPO;
import state.ReceiptType;

public class InventoryImportReceiptPO extends ReceiptPO {
	/**
	 * @author lxl
	 * @version Oct 23,2015
	 **/

	private static final long serialVersionUID = 1L;

	private CommodityPO commodityPO;
	private int area;
	private int row;
	private int frame;
	private int position;
	public InventoryImportReceiptPO(String ID, ReceiptType type,  CommodityPO commodityPO, int area, int row, int frame, int position) {
		super(ID, type);
		this.area = area;
		this.row = row;
		this.frame = frame;
		this.position = position;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getFrame() {
		return frame;
	}
	public void setFrame(int frame) {
		this.frame = frame;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public CommodityPO getCommodityPO() {
		return commodityPO;
	}
	public void setCommodityPO(CommodityPO commodityPO) {
		this.commodityPO = commodityPO;
	}

	
}
