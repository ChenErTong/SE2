package businesslogic.organizationbl;

import java.util.ArrayList;

import po.BranchPO;
import po.FacilityPO;
import po.InventoryPO;
import po.OrganizationPO;
import po.TransferPO;
import po.accountpo.AccountPO;
import state.OrganizationType;
import vo.BranchVO;
import vo.OrganizationVO;
import vo.TransferVO;

public class OrganizationTrans {
	public static OrganizationVO transPOtoVO(OrganizationPO po){
		String organizationID=po.getID();
		String address = po.getAddress();
		String date = po.getDate();
		OrganizationType organizationType = po.getOrganizationType();
		if(organizationType==OrganizationType.BRANCH){
			BranchPO branchPO=(BranchPO)po;
			ArrayList<AccountPO> accounts =branchPO.getAccounts();
			ArrayList<FacilityPO> facilities = branchPO.getFacilities();
			return new BranchVO(organizationID, date, address, accounts, facilities);
		}
		else {
			TransferPO transferPO = (TransferPO)po;
			ArrayList<AccountPO> accounts =transferPO.getAccounts();
			ArrayList<InventoryPO> inventories = transferPO.getInventories();
			return new TransferVO(organizationID, address, date, accounts, inventories);
		}
	}
}
