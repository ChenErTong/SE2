package po.receiptpo;

public class InventoryExportReceiptPO extends ReceiptPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**目的地**/
	public String destination;
	/**装运形式**/
	public String Transfer;
	public InventoryExportReceiptPO(String ID, String destination, String transfer) {
		super(ID);
		this.destination = destination;
		Transfer = transfer;
	}
	
}
