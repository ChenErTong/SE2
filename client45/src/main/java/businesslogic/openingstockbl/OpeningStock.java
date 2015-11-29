package businesslogic.openingstockbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.accountbl.AccountTrans;
import businesslogic.branchbl.BranchTrans;
import businesslogic.facilitybl.FacilityTrans;
import businesslogic.fundbl.FundTrans;
import businesslogic.inventorybl.InventoryTrans;
import businesslogic.transferbl.TransferTrans;
import config.RMIConfig;
import dataservice.accountdataservice.AccountDataService;
import dataservice.branchdataservice.BranchDataService;
import dataservice.facilitydataservice.FacilityDataService;
import dataservice.funddataservice.BankAccountDataService;
import dataservice.inventorydataservice.InventoryDataService;
import dataservice.openingstockdataservice.OpeningStockDataService;
import dataservice.transferdataservice.TransferDataService;
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
	//TODO 依赖倒置
	private OpeningStockDataService openingStockData;
	private BranchDataService branchData;
	private TransferDataService transferData;
	private AccountDataService accountData;
	private FacilityDataService facilityData;
	private InventoryDataService inventoryData;
	private BankAccountDataService bankAccountData;
	
	
	public OpeningStock() {
		try {
			openingStockData = (OpeningStockDataService) Naming.lookup(RMIConfig.PREFIX + OpeningStockDataService.NAME);
			accountData = (AccountDataService)Naming.lookup(RMIConfig.PREFIX+AccountDataService.NAME);
			branchData = (BranchDataService) Naming.lookup(RMIConfig.PREFIX + BranchDataService.NAME);
			transferData = (TransferDataService) Naming.lookup(RMIConfig.PREFIX + TransferDataService.NAME);
			facilityData = (FacilityDataService) Naming.lookup(RMIConfig.PREFIX + FacilityDataService.NAME);
			inventoryData = (InventoryDataService) Naming.lookup(RMIConfig.PREFIX + InventoryDataService.NAME);
			bankAccountData = (BankAccountDataService) Naming.lookup(RMIConfig.PREFIX + BankAccountDataService.NAME);
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM--dd");
		date = sdf.format(new Date());
		OpeningStockPO po = new OpeningStockPO(ID, date, transfers, branchs, accounts, facilities, inventories,
				bankAccounts);
		return openingStockData.add(po);
	}

	public OpeningStockVO find(String id) throws RemoteException {
		OpeningStockPO po = openingStockData.find(id);
		OpeningStockVO vo = OpeningStockTrans.convertPOtoVO(po);
		return vo;
	}

	public ArrayList<OpeningStockVO> show() throws RemoteException {
		ArrayList<OpeningStockPO> pos = openingStockData.find();
		ArrayList<OpeningStockVO> vos = OpeningStockTrans.convertPOstoVOs(pos);
		return vos;
	}

	public ResultMessage add() throws RemoteException {
		String ID = openingStockData.getID();
		String date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM--dd");
		date = sdf.format(new Date());
		ArrayList<TransferPO> transfers=transferData.find();
		ArrayList<BranchPO> branchs=branchData.find();
		ArrayList<AccountPO> accounts=accountData.find();
		ArrayList<FacilityPO> facilities=facilityData.find();
		ArrayList<InventoryPO> inventories=inventoryData.find();
		ArrayList<BankAccountPO> bankAccounts=bankAccountData.find();
		OpeningStockPO po=new OpeningStockPO(ID, date, transfers, branchs, accounts, facilities, inventories, bankAccounts);
		return openingStockData.add(po);
	}

}
