package vo.receiptvo;

public class InventoryExportReceiptVO extends ReceiptVO {
	/**目的地**/
	public String destination;
	/**装运形式**/
	public String Transfer;
	public InventoryExportReceiptVO(String ID,String destination, String transfer) {
		super(ID);
		this.destination = destination;
		Transfer = transfer;
	}
}
