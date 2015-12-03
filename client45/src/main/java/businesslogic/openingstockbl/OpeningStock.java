package businesslogic.openingstockbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.accountbl.AccountInfo;
import businesslogic.accountbl.AccountTrans;
import businesslogic.branchbl.BranchInfo;
import businesslogic.branchbl.BranchTrans;
import businesslogic.facilitybl.FacilityInfo;
import businesslogic.facilitybl.FacilityTrans;
import businesslogic.fundbl.BankAccountInfo;
import businesslogic.fundbl.FundTrans;
import businesslogic.inventorybl.InventoryInfo;
import businesslogic.inventorybl.InventoryTrans;
import businesslogic.transferbl.TransferInfo;
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
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:36:10
 */
public class OpeningStock {
	private OpeningStockDataService openingStockData;
	
	private BranchInfo_OpeningStock branchInfo;
	private TransferInfo_OpeningStock transferInfo;
	private AccountInfo_OpeningStock accountInfo;
	private FacilityInfo_OpeningStock facilityInfo;
	private InventoryInfo_OpeningStock inventoryInfo;
	private BankAccountInfo_OpeningStock bankAccountInfo;
	
	public OpeningStock() {
		branchInfo = new BranchInfo();
		transferInfo = new TransferInfo();
		accountInfo = new AccountInfo();
		facilityInfo = new FacilityInfo();
		inventoryInfo = new InventoryInfo();
		bankAccountInfo=new BankAccountInfo();
		try {
			openingStockData = (OpeningStockDataService) Naming.lookup(RMIConfig.PREFIX + OpeningStockDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	//可能用不到了
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
		ArrayList<TransferPO> transfers=transferInfo.find();
		ArrayList<BranchPO> branchs=branchInfo.find();
		ArrayList<AccountPO> accounts=accountInfo.find();
		ArrayList<FacilityPO> facilities=facilityInfo.find();
		ArrayList<InventoryPO> inventories=inventoryInfo.find();
		ArrayList<BankAccountPO> bankAccounts=bankAccountInfo.find();
		OpeningStockPO po=new OpeningStockPO(ID, date, transfers, branchs, accounts, facilities, inventories, bankAccounts);
		return openingStockData.add(po);
	}

}
