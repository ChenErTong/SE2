package businesslogic.organizationbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.accountbl.AccountInfo;
import businesslogic.facilitybl.FacilityInfo;
import businesslogic.inventorybl.InventoryInfo;
import businesslogic.organizationbl.transferbl.InventoryInfo_Transfer;
import vo.FacilityVO;
import vo.InventoryVO;
import vo.accountvo.AccountVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:37:13
 */
public class Organization {
	
	private AccountInfo_Branch_Transfer accountInfo;
	private FacilityInfo_Branch_Transfer facilityInfo;
	private InventoryInfo_Transfer inventoryInfo;
	
	public Organization() throws MalformedURLException, RemoteException, NotBoundException {
		accountInfo = new AccountInfo();
		facilityInfo = new FacilityInfo();
		inventoryInfo = new InventoryInfo();
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
