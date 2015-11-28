package vo.receiptvo;

import state.ReceiptType;

public class InventoryExportReceiptVO extends ReceiptVO {
	/**目的地**/
	public String destination;
	public String depture;
	/**装运形式**/
	public String Transfer;
	public String TransferID;
	public String CommoditiesID;
	public int a;
	public int b;
	public int c;
	public int d;
	public InventoryExportReceiptVO(String id, ReceiptType type, String destination, String depture, String transfer,
			String transferID, String commoditiesID, int a, int b, int c, int d) {
		super(id, type);
		this.destination = destination;
		this.depture = depture;
		Transfer = transfer;
		TransferID = transferID;
		CommoditiesID = commoditiesID;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
}
