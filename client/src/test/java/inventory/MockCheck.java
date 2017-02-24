package inventory;

import java.util.ArrayList;

import vo.InventoryCheckVO;


public class MockCheck {
	
	public String LotNum="010";
    ArrayList<vo.receiptvo.InventoryImportReceiptVO> iirv=new ArrayList<vo.receiptvo.InventoryImportReceiptVO>();
    ArrayList<InventoryCheckVO> ic=new  ArrayList<InventoryCheckVO>();

	public String getLotNum(){
		return LotNum;
	}
	
	public ArrayList<InventoryCheckVO> checkRecord() {
		return null;
	}

}
