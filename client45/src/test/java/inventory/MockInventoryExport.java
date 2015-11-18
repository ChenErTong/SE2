package inventory;

import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import state.ResultMessage;
import vo.InventoryExportReceiptVO;
import vo.InventoryImportReceiptVO;
import vo.InventoryVO;

public class MockInventoryExport {
	private  ResultMessage SUCCESS = null;
	
	public String getExportID() {
		
		return "1";
	}

	public String getCommodities() {
		
		return "nanjing520";
	}
	public String getDestination(){
		
		return "nanjing";
	}
   public InventoryVO minusPlace(){
	   InventoryVO iv=new InventoryVO(1, 1, 1, 1);
	   return iv;
   }
   public String getTransfer(){ 
	   return "car";
   }
   
   public String getTransferID(){
	   return "TransID";
   }
    
	public InventoryExportReceiptPO buildImport() {
		InventoryVO iv=new InventoryVO(1, 1, 1, 1);
		int a=iv.getA();
		int b=iv.getB();
		int c=iv.getC();
		int d=iv.getD();
		String ID="1";
		String destination="nanjing";
		String CommoditiesID="nanjing520";
		String Transfer="car";
		String TransferID= "TransID";
		InventoryExportReceiptPO ier=new InventoryExportReceiptPO(ID, destination, Transfer, TransferID, CommoditiesID, a, b, c, d);
	    return ier;
		
	}

	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt){
		return SUCCESS;
	}	
}