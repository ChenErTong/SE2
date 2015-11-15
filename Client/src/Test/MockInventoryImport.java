package Test;

import po.receiptpo.InventoryImportReceiptPO;
import state.ResultMessage;
import vo.InventoryImportReceiptVO;
import vo.InventoryVO;

public class MockInventoryImport {
     
	private  ResultMessage SUCCESS ;
	
	public String getImportID() {	
		return "1";
	}
	
	public String getCommodities() {
		
		return "nanjing520";
	}
	public String getDestination(){
		return "nanjing";
	}
   public InventoryVO addPlace(){
	   
	   InventoryVO iv=new InventoryVO(1, 1, 1, 1);
	   return iv;
   }
    
	public InventoryImportReceiptPO buildImport() {
		InventoryVO iv=new InventoryVO(1, 1, 1, 1);
		int a=iv.getA();
		int b=iv.getB();
		int c=iv.getC();
		int d=iv.getD();
		String ID="1";
		String destination="nanjing";
		String CommoditiesID="nanjing520";
		InventoryImportReceiptPO iir=new InventoryImportReceiptPO(ID,destination,CommoditiesID,a,b,c,d);
	    return iir;
		
	}

	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) {
		
		return SUCCESS;
	}

	

}
