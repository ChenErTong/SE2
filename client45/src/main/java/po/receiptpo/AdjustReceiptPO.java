package po.receiptpo;

import state.ReceiptType;

public class AdjustReceiptPO extends ReceiptPO{
	
	  /** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
	 
	private static final long serialVersionUID = 1L;
	public AdjustReceiptPO(String ID, ReceiptType type,int exA, int exB, int exC, int exD, int aftA, int aftB,
			int aftC, int aftD) {
		super(ID, type);
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
	public int getExA() {
		return exA;
	}
	public void setExA(int exA) {
		this.exA = exA;
	}
	public int getExB() {
		return exB;
	}
	public void setExB(int exB) {
		this.exB = exB;
	}
	public int getExC() {
		return exC;
	}
	public void setExC(int exC) {
		this.exC = exC;
	}
	public int getExD() {
		return exD;
	}
	public void setExD(int exD) {
		this.exD = exD;
	}
	public int getAftA() {
		return aftA;
	}
	public void setAftA(int aftA) {
		this.aftA = aftA;
	}
	public int getAftB() {
		return aftB;
	}
	public void setAftB(int aftB) {
		this.aftB = aftB;
	}
	public int getAftC() {
		return aftC;
	}
	public void setAftC(int aftC) {
		this.aftC = aftC;
	}
	public int getAftD() {
		return aftD;
	}
	public void setAftD(int aftD) {
		this.aftD = aftD;
	}
	
}
