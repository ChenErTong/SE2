package po.receiptpo;

import state.ExpressType;
import state.ReceiptType;

public class InventoryExportReceiptPO extends ReceiptPO{
	/** @author lxl
		 *  @version Oct 23,2015
		 *      **/
		
	private static final long serialVersionUID = 1L;
	/**目的地**/
	public String destination;
	public String depture;
	/**装运形式**/
	public ExpressType expressType;
	public String TransferID;
	public String CommoditiesID;
	public int area;
	public int row;
	public int frame;
	public int position;
	
	public InventoryExportReceiptPO(String ID, ReceiptType type,String destination, String depture, ExpressType expressType, String transferID,
			String commoditiesID, int area, int row, int frame, int position) {
		super(ID, type);
		this.destination = destination;
		this.depture = depture;
		this.expressType=expressType;
		this.TransferID = transferID;
		this.CommoditiesID = commoditiesID;
		this.area = area;
		this.row = row;
		this.frame =frame;
		this.position =position;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDepture() {
		return depture;
	}
	public void setDepture(String depture) {
		this.depture = depture;
	}
	public ExpressType getExpressType() {
		return expressType;
	}
	public void setExpressType(ExpressType expressType) {
		this.expressType = expressType;
	}
	public String getTransferID() {
		return TransferID;
	}
	public void setTransferID(String transferID) {
		TransferID = transferID;
	}
	public String getCommoditiesID() {
		return CommoditiesID;
	}
	public void setCommoditiesID(String commoditiesID) {
		CommoditiesID = commoditiesID;
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
	
	
	
}
