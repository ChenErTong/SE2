package businesslogicservice.openingstockblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo.BankAccountVO;
import vo.BranchVO;
import vo.FacilityVO;
import vo.InventoryVO;
import vo.TransferVO;
import vo.accountvo.AccountVO;

public class OpeningStockBLService_Driver {
	@SuppressWarnings("unused")
	public void drive( OpeningStockBLService openingstockBLService){
		ArrayList<TransferVO> commodities=new ArrayList<TransferVO>();
		ArrayList<BranchVO> brabches=new ArrayList<BranchVO> ();
		ArrayList<AccountVO> accounts=new ArrayList<AccountVO>();
		ArrayList<FacilityVO> facilities=new ArrayList<FacilityVO>();
		ArrayList<InventoryVO> inventories=new ArrayList<InventoryVO>();
		ArrayList<BankAccountVO> banks=new ArrayList<BankAccountVO>();
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
			ArrayList<BankAccountVO> banks = null;
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
