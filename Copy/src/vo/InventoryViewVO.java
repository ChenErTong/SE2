package vo;

public class InventoryViewVO {

	  /** @author lxl
		 *  @version Oct 23,2015
		 *      **/
		
	/** 出库数量 **/
	public int exportNumber;
	/** 入库数量）**/
	public int importNumber;
	/**区**/
	public int A;
	/**排**/
	public int B;
	/**架**/
	public int C;
	/**位**/
	public int D;
	
	public InventoryViewVO(int exportNumber, int importNumber, int a, int b, int c, int d) {
		super();
		this.exportNumber = exportNumber;
		this.importNumber = importNumber;
		A = a;
		B = b;
		C = c;
		D = d;
	}
	
	
	
	
}
