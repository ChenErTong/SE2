package inventory;

import java.util.ArrayList;

import vo.InventoryCheckVO;
import vo.InventoryImportReceiptVO;

public class MockCheck {
	
	public String LotNum="010";
    ArrayList<vo.receiptvo.InventoryImportReceiptVO> iirv=new ArrayList<vo.receiptvo.InventoryImportReceiptVO>();
    ArrayList<InventoryCheckVO> ic=new  ArrayList<InventoryCheckVO>();

	public String getLotNum(){
		return LotNum;
	}
	
	public ArrayList<InventoryCheckVO> checkRecord() {
		InventoryCheckVO icv=new InventoryCheckVO(iirv, LotNum);
		ic.add(icv);
		return ic;
	}

}
