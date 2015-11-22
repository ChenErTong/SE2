package inventory;

import java.util.ArrayList;

import vo.InventoryVO;
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
		ArrayList<InventoryVO> vos=new ArrayList<InventoryVO>();
		InventoryViewVO ivv=new InventoryViewVO (importNum,exportNum,Num,vos);
		return ivv;
		}
	
	
}
