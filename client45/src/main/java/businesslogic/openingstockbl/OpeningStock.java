package businesslogic.openingstockbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.openingstockdataservice.OpeningStockDataService;
import dataservice.userdataservice.UserDataService;
import po.TransferPO;
import state.ResultMessage;
import vo.BankAccountVO;
import vo.BranchVO;
import vo.FacilityVO;
import vo.InventoryVO;
import vo.TransferVO;
import vo.accountvo.AccountVO;

public class OpeningStock{
	private OpeningStockDataService openingStockData;
	public OpeningStock() {
		try {
			openingStockData=(OpeningStockDataService)Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/" + OpeningStockDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	public ResultMessage add(
			ArrayList<TransferVO> transferVOs, 
			ArrayList<BranchVO> branchVOs,
			ArrayList<AccountVO> accountVOs, 
			ArrayList<FacilityVO> facilityVOs, 
			ArrayList<InventoryVO> inventoryVOs,
			ArrayList<BankAccountVO> bankAccountVOs) {
		
		return null;
	}

	public ResultMessage find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
