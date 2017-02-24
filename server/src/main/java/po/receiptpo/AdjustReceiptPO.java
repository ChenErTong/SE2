package po.receiptpo;

import state.ReceiptType;

public class AdjustReceiptPO extends ReceiptPO {

	/**
	 * @author lxl
	 * @version Oct 23,2015
	 **/

	private static final long serialVersionUID = 1L;

	

	public int exArea;
	public int exRow;
	public int exFrame;
	public int exPosition;

	public int aftArea;
	public int aftRow;
	public int aftFrame;
	public int aftPosition;
	public AdjustReceiptPO(String ID, ReceiptType type, int exArea, int exRow, int exFrame, int exPosition, int aftArea,
			int aftRow, int aftFrame, int aftPosition) {
		super(ID, type);
		this.exArea = exArea;
		this.exRow = exRow;
		this.exFrame = exFrame;
		this.exPosition = exPosition;
		this.aftArea = aftArea;
		this.aftRow = aftRow;
		this.aftFrame = aftFrame;
		this.aftPosition = aftPosition;
	}
	public int getExArea() {
		return exArea;
	}
	public void setExArea(int exArea) {
		this.exArea = exArea;
	}
	public int getExRow() {
		return exRow;
	}
	public void setExRow(int exRow) {
		this.exRow = exRow;
	}
	public int getExFrame() {
		return exFrame;
	}
	public void setExFrame(int exFrame) {
		this.exFrame = exFrame;
	}
	public int getExPosition() {
		return exPosition;
	}
	public void setExPosition(int exPosition) {
		this.exPosition = exPosition;
	}
	public int getAftArea() {
		return aftArea;
	}
	public void setAftArea(int aftArea) {
		this.aftArea = aftArea;
	}
	public int getAftRow() {
		return aftRow;
	}
	public void setAftRow(int aftRow) {
		this.aftRow = aftRow;
	}
	public int getAftFrame() {
		return aftFrame;
	}
	public void setAftFrame(int aftFrame) {
		this.aftFrame = aftFrame;
	}
	public int getAftPosition() {
		return aftPosition;
	}
	public void setAftPosition(int aftPosition) {
		this.aftPosition = aftPosition;
	}

	

}
