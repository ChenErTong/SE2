package vo.receiptvo;

public class AdjustReceiptVO  extends ReceiptVO{

	
	public AdjustReceiptVO(String id, String exA, String exB, String exC, String exD, String aftA, String aftB,
			String aftC, String aftD) {
		super(id);
		this.exA = exA;
		this.exB = exB;
		this.exC = exC;
		this.exD = exD;
		this.aftA = aftA;
		this.aftB = aftB;
		this.aftC = aftC;
		this.aftD = aftD;
	}
	public String exA;
	public String exB;
	public String exC;
	public String exD;
	
	public String aftA;
	public String aftB;
	public String aftC;
	public String aftD;
	

}
