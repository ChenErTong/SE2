package businesslogic.organizationbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.accountbl.AccountInfo;
import businesslogic.branchbl.BranchTrans;
import businesslogic.facilitybl.FacilityInfo;
import businesslogic.inventorybl.InventoryInfo;
import businesslogic.transferbl.InventoryInfo_Transfer;
import businesslogic.transferbl.TransferTrans;
import config.RMIConfig;
import dataservice.branchdataservice.BranchDataService;
import dataservice.transferdataservice.TransferDataService;
import po.BranchPO;
import po.TransferPO;
import state.ResultMessage;
import util.CityTrans;
import vo.BranchVO;
import vo.FacilityVO;
import vo.InventoryVO;
import vo.TransferVO;
import vo.accountvo.AccountVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:37:13
 */
public class Organization {
	private BranchDataService branchData;
	private TransferDataService transferData;
	private AccountInfo_Branch_Transfer accountInfo;
	private FacilityInfo_Branch_Transfer facilityInfo;
	private InventoryInfo_Transfer inventoryInfo;

	public Organization() throws MalformedURLException, RemoteException, NotBoundException {
		accountInfo = new AccountInfo();
		facilityInfo = new FacilityInfo();
		inventoryInfo = new InventoryInfo();
		branchData = (BranchDataService) Naming.lookup(RMIConfig.PREFIX + BranchDataService.NAME);
		transferData = (TransferDataService) Naming.lookup(RMIConfig.PREFIX + TransferDataService.NAME);
	}

	public String getBranchID(String city) throws RemoteException {
		String cityCode = CityTrans.getCodeByCity(city);
		String ID = branchData.getID();
		return cityCode + ID;
	}

	public ResultMessage addBranch(BranchVO vo) throws RemoteException {
		System.out.println(vo.toString());
		BranchPO po = BranchTrans.convertVOtoPO(vo);
		return branchData.add(po);
	}

	public ResultMessage deleteBranch(String organizationID) throws RemoteException {
		return branchData.delete(organizationID);
	}

	public ResultMessage updateBranch(BranchVO vo) throws RemoteException {
		BranchPO po = BranchTrans.convertVOtoPO(vo);
		return branchData.modify(po);
	}

	public ArrayList<BranchVO> showBranch() throws RemoteException {
		ArrayList<BranchPO> branchPOs = branchData.find();
		return BranchTrans.convertPOstoVOs(branchPOs);
	}

	public ArrayList<String> getAllBranchNumbers() throws RemoteException {
		ArrayList<BranchPO> pos = branchData.find();
		ArrayList<String> branchNumbers = new ArrayList<>();
		for (BranchPO branchPO : pos) {
			branchNumbers.add(branchPO.getOrganizationID());
		}
		return branchNumbers;
	}

	public String getTransferID(String city) throws RemoteException {
		String cityCode = CityTrans.getCodeByCity(city);
		return cityCode + transferData.getID();
	}

	public ResultMessage addTransfer(TransferVO transfer) throws RemoteException {
		InventoryVO inventoryVO = inventoryInfo.getTransferInitialInventory(transfer.organizationID);
		transfer.inventories.add(inventoryVO);
		TransferPO transferPO = TransferTrans.convertVOtoPO(transfer);
		return transferData.add(transferPO);
	}

	public ResultMessage deleteTransfer(String organizationID) throws RemoteException {
		return transferData.delete(organizationID);
	}

	public ResultMessage updateTransfer(TransferVO vo) throws RemoteException {
		TransferPO transferPO = TransferTrans.convertVOtoPO(vo);
		return transferData.modify(transferPO);
	}

	public ArrayList<TransferVO> showTransfer() throws RemoteException {
		ArrayList<TransferPO> pos = transferData.find();
		return TransferTrans.convertPOstoVOs(pos);
	}

	public ArrayList<AccountVO> getAccountsByOrganizationID(String organizationID) throws RemoteException {
		return accountInfo.getAccountByOrganizationID(organizationID);
	}

	public ArrayList<FacilityVO> getFacilitiesByBranchID(String branchID) throws RemoteException {
		return facilityInfo.getFacilitiesByBranchID(branchID);
	}

	public ArrayList<InventoryVO> getInventoriesByTransferID(String transferID) throws RemoteException {
		return inventoryInfo.getInventoriesByTransferID(transferID);
	}
}
