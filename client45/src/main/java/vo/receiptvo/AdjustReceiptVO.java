package vo.receiptvo;

import state.ReceiptType;

public class AdjustReceiptVO  extends ReceiptVO{

	
	public AdjustReceiptVO(String id, ReceiptType type,int exA, int exB, int exC, int exD, int aftA, int aftB,
			int aftC, int aftD) {
		super(id, type);
		this.exA = exA;
		this.exB = exB;
		this.exC = exC;
		this.exD = exD;
		this.aftA = aftA;
		this.aftB = aftB;
		this.aftC = aftC;
		this.aftD = aftD;
	}
	public int exA;
	public int exB;
	public int exC;
	public int exD;
	
	public int aftA;
	public int aftB;
	public int aftC;
	public int aftD;
	

}
