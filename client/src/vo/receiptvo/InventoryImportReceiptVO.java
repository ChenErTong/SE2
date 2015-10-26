package vo.receiptvo;

public class InventoryImportReceiptVO extends ReceiptVO{
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
	
	public InventoryImportReceiptVO(String id, String destination, int a, int b, int c, int d) {
		super(id);
		this.destination = destination;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public String getDestination() {
		return destination;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getC() {
		return c;
	}

	public int getD() {
		return d;
	}
}