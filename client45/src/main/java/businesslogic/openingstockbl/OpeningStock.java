package businesslogic.openingstockbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.accountbl.AccountTrans;
import businesslogic.branchbl.BranchTrans;
import businesslogic.facilitybl.FacilityTrans;
import businesslogic.fundbl.FundTrans;
import businesslogic.inventorybl.InventoryTrans;
import businesslogic.transferbl.TransferTrans;
import config.RMIConfig;
import dataservice.openingstockdataservice.OpeningStockDataService;
import po.BankAccountPO;
import po.BranchPO;
import po.FacilityPO;
import po.InventoryPO;
import po.OpeningStockPO;
import po.TransferPO;
import po.accountpo.AccountPO;
import state.ResultMessage;
import vo.BankAccountVO;
import vo.BranchVO;
import vo.FacilityVO;
import vo.InventoryVO;
import vo.OpeningStockVO;
import vo.TransferVO;
import vo.accountvo.AccountVO;

public class OpeningStock {
	private OpeningStockDataService openingStockData;

	public OpeningStock() {
		try {
			openingStockData = (OpeningStockDataService) Naming
					.lookup(RMIConfig.PREFIX + OpeningStockDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public ResultMessage add(ArrayList<TransferVO> transferVOs, ArrayList<BranchVO> branchVOs,
			ArrayList<AccountVO> accountVOs, ArrayList<FacilityVO> facilityVOs, ArrayList<InventoryVO> inventoryVOs,
			ArrayList<BankAccountVO> bankAccountVOs) throws RemoteException {

		ArrayList<TransferPO> transfers = TransferTrans.convertVOstoPOs(transferVOs);
		ArrayList<BranchPO> branchs = BranchTrans.convertVOstoPOs(branchVOs);
		ArrayList<AccountPO> accounts = AccountTrans.convertVOstoPOs(accountVOs);
		ArrayList<FacilityPO> facilities = FacilityTrans.convertVOstoPOs(facilityVOs);
		ArrayList<InventoryPO> inventories = InventoryTrans.convertInventoryVOstoPOs(inventoryVOs);
		ArrayList<BankAccountPO> bankAccounts = FundTrans.convertVOstoPOs(bankAccountVOs);
		String ID = openingStockData.getID();
		String date = null;
		OpeningStockPO po = new OpeningStockPO(ID, date, transfers, branchs, accounts, facilities, inventories,
				bankAccounts);
		return openingStockData.add(po);
	}

	public OpeningStockVO find(String id) throws RemoteException {
		OpeningStockPO po = openingStockData.findOpeningStock(id);
		OpeningStockVO vo = OpeningStockTrans.convertPOtoVO(po);
		return vo;
	}

}
