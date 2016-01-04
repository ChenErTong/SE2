package vo.receiptvo;

import state.ReceiptType;

public class AdjustReceiptVO  extends ReceiptVO{

	
	
	public int exArea;
	public int exRow;
	public int exFrame;
	public int exPosition;
	
	public int aftArea;
	public int aftRow;
	public int aftFrame;
	public int aftPosition;
	public AdjustReceiptVO(String id, ReceiptType type, int exArea, int exRow, int exFrame, int exPosition, int aftArea,
			int aftRow, int aftFrame, int aftPosition) {
		super(id, type);
		this.exArea = exArea;
		this.exRow = exRow;
		this.exFrame = exFrame;
		this.exPosition = exPosition;
		this.aftArea = aftArea;
		this.aftRow = aftRow;
		this.aftFrame = aftFrame;
		this.aftPosition = aftPosition;
	}
	
	

}
