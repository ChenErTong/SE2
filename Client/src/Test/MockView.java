package Test;

import vo.InventoryViewVO;

public class MockView {
	private int importNum=1;
	private int exportNum=1;
	private int Num=1;
	
	
	public int getImportNum(){
		return importNum;
	}
	public int getExportNum(){
		return exportNum;
	}
	public int getNum(){
        return Num;
	}
	public InventoryViewVO viewInventory(String beginDate, String endDate) {
		
		InventoryViewVO ivv=new InventoryViewVO (importNum,exportNum,Num);
		return ivv;
		}
	
	
}
