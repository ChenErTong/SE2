package po.receiptpo;

public class AdjustReceiptPO extends ReceiptPO{
	
	  /** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
	 
	private static final long serialVersionUID = 1L;
	public AdjustReceiptPO(String ID, int exA, int exB, int exC, int exD, int aftA, int aftB,
			int aftC, int aftD) {
		super(ID);
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
