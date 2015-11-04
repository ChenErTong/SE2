package businesslogicservice.inventoryblservice;

import java.util.ArrayList;

import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import state.ResultMessage;
import vo.InventoryCheckVO;
import vo.InventoryVO;
import vo.InventoryViewVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.TransferArrivalListVO;

public class InventoryBLService_Stub implements InventoryBLService{
	/** 出库数量 **/
	public int exportNumber;
	/** 入库数量）**/
	public int importNumber;
	/**库存情况**/
	public ArrayList<InventoryVO> InventoryCondition;  
    /** 商品列表 */
	public ArrayList<InventoryImportReceiptVO> receipts;
	/** 批次 */
	public String date;
	/** 批号 */
	public String lotNum;
	
	String importID;
	String exportID;
	String adjustID;
	
	ResultMessage resultadd;
	ResultMessage resultimport;
	ResultMessage resultminus;
	ResultMessage resultexport;
	
	 String importDestination;int a; int b; int c; int d;
	
	String exportDestination; String transfer;
	
	int exA;int exB;int exC;int exD; int aftA; int aftB;
	int aftC; int aftD;
	public InventoryBLService_Stub(int exportNumber, int importNumber, ArrayList<InventoryVO> inventoryCondition,
			ArrayList<InventoryImportReceiptVO> receipts, String date, String lotNum, String importID, String exportID,
			String adjustID, ResultMessage resultadd,ResultMessage resultimport,
			ResultMessage resultminus,ResultMessage resultexport, String importDestination,
			int a, int b, int c, int d, String exportDestination, String transfer,  int exA, int exB, int exC,
			int exD, int aftA, int aftB, int aftC, int aftD) {
		super();
		this.exportNumber = exportNumber;
		this.importNumber = importNumber;
		InventoryCondition = inventoryCondition;
		this.receipts = receipts;
		this.date = date;
		this.lotNum = lotNum;
		this.importID = importID;
		this.exportID = exportID;
		this.adjustID = adjustID;
		 this.resultadd=resultadd;
		 this.resultimport=resultimport;
		 this.resultminus=resultminus;
		 this.resultexport= resultexport;
		this.importDestination = importDestination;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.exportDestination = exportDestination;
		this.transfer = transfer;
		this.exA = exA;
		this.exB = exB;
		this.exC = exC;
		this.exD = exD;
		this.aftA = aftA;
		this.aftB = aftB;
		this.aftC = aftC;
		this.aftD = aftD;
	}

	

	
	@Override
	public InventoryViewVO viewInventory(String beginDate, String endDate) {
		// TODO Auto-generated method stub
		return new InventoryViewVO(exportNumber,  importNumber,  a,  b,  c,  d);
	}
    @Override
	public InventoryCheckVO checkRecord() {
		// TODO Auto-generated method stub
		return new InventoryCheckVO(receipts, adjustID);
	}
	

	@Override
	public String getImportID() {
		// TODO Auto-generated method stub
		return importID;
	}

	@Override
	public ResultMessage addCommodities(TransferArrivalListVO receipt) {
		// TODO Auto-generated method stub
		return resultadd;
	}

	@Override
	public InventoryImportReceiptPO buildImport() {
		// TODO Auto-generated method stub
		return new InventoryImportReceiptPO(importID,  importDestination, a,  b,  c,  d);
	}

	@Override
	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) {
		// TODO Auto-generated method stub
		return resultimport;
	}

	@Override
	public String getExportID() {
		// TODO Auto-generated method stub
		return exportID;
	}

	@Override
	public ResultMessage minusCommodities(TransferArrivalListVO receipt) {
		return resultminus;
		// TODO Auto-generated method stub
		
	}

	@Override
	public InventoryExportReceiptPO buildExport() {
		// TODO Auto-generated method stub
		return new InventoryExportReceiptPO(importID, exportDestination, transfer);
	}

	@Override
	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt) {
		// TODO Auto-generated method stub
		return resultexport;
	}

	@Override
	public String getAdjustID() {
		// TODO Auto-generated method stub
		return adjustID;
	}

	@Override
	public AdjustReceiptPO adjust() {
		// TODO Auto-generated method stub
		return new AdjustReceiptPO(adjustID,  exA,  exB,  exC,  exD,  aftA,  aftB, aftC,  aftD);
	}
	
}