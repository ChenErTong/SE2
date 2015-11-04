package businesslogicservice.openingstockblservice;

import java.util.ArrayList;

import businesslogicservice.openingstockblservice.OpeningStockBLService;
import businesslogicservice.openingstockblservice.OpeningStockBLService_Stub;
import businesslogicservice.inventoryblservice.InventoryBLService_Driver;
import businesslogicservice.inventoryblservice.InventoryBLService_Stub;
import state.ResultMessage;
import vo.BankVO;
import vo.BranchVO;
import vo.FacilityVO;
import vo.InventoryVO;
import vo.TransferVO;
import vo.accountvo.AccountVO;

public class OpeningStockBLService_Driver {
	public void drive( OpeningStockBLService openingstockBLService){
		ArrayList<TransferVO> commodities=new ArrayList<TransferVO>();
		ArrayList<BranchVO> brabches=new ArrayList<BranchVO> ();
		ArrayList<AccountVO> accounts=new ArrayList<AccountVO>();
		ArrayList<FacilityVO> facilities=new ArrayList<FacilityVO>();
		ArrayList<InventoryVO> inventories=new ArrayList<InventoryVO>();
		ArrayList<BankVO> banks=new ArrayList<BankVO>();
		int id = 10086;
		
		
		ResultMessage addResult=openingstockBLService.add(commodities, brabches, accounts, facilities, inventories, banks);
	    System.out.println("添加信息SUCCESS");
	


	    ResultMessage findResult=openingstockBLService.find(id); 
	   System.out.println("查询SUCCESS");
}
	 public static void main(String[] args){
		 ArrayList<TransferVO> commoditiesl = null;
		 ArrayList<BranchVO> brabches = null;
			ArrayList<AccountVO> accounts = null; 
			ArrayList<FacilityVO> facilities = null;
			ArrayList<InventoryVO> inventories = null;
			ArrayList<BankVO> banks = null;
			ResultMessage resultadd = null;
			ResultMessage resultfind = null;
			int id = 10086;
		 OpeningStockBLService_Stub openingstockblservice_stub=new OpeningStockBLService_Stub( commoditiesl,  brabches,
					 accounts, facilities,  inventories,
					 banks,  resultadd,  resultfind,  id);
		 OpeningStockBLService_Driver openingstockblservice_driver=new OpeningStockBLService_Driver();
		 openingstockblservice_driver.drive(openingstockblservice_stub);
}
}
