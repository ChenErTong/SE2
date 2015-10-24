package po.receiptpo;

public class InventoryImportReceiptPO extends  ReceiptPO  {
	  /** @author lxl
		 *  @version Oct 23,2015
		 *      **/
		
	private static final long serialVersionUID = 1L;
	public InventoryImportReceiptPO(String ID, String destination, int a, int b, int c, int d) {
		super(ID);
		this.destination = destination;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	//目的地
		public String destination;
		//区号
		 public int a;
		//排号
		 public int b;
		//架号
		 public int c;
		//位号
		 public int d;	
}
