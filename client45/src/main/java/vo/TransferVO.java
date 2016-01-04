package vo;

import java.util.ArrayList;

import state.OrganizationType;
import vo.accountvo.AccountVO;

public class TransferVO extends OrganizationVO {
	
	/**
	 * 员工信息
	 */
	public ArrayList<AccountVO> accounts;
	
	/**
	 * 仓库信息
	 */
	public ArrayList<InventoryVO> inventories;

	public TransferVO(String organizationID, String address,String date, ArrayList<AccountVO> accounts,
			ArrayList<InventoryVO> inventories) {
		super(organizationID, address, accounts.size(),OrganizationType.TRANSFER);
		this.accounts = accounts;
		this.inventories = inventories;
	}

	public TransferVO(String organizationID, String address, OrganizationType organizationType) {
		super(organizationID, address,0, OrganizationType.TRANSFER);
		this.accounts = new ArrayList<AccountVO>();
		this.inventories = new ArrayList<InventoryVO>();
	}
	
	
}
