package businesslogic.openingstockbl;

import java.util.ArrayList;

import po.BankAccountPO;
import po.BranchPO;
import po.FacilityPO;
import po.InventoryPO;
import po.OpeningStockPO;
import po.TransferPO;
import po.accountpo.AccountPO;
import vo.OpeningStockVO;

public class OpeningStockTrans {
	public static OpeningStockVO convertPOtoVO(OpeningStockPO po) {
		if (po == null)
			return null;
		else {
			String ID = po.getID();
			String date = po.getDate();
			ArrayList<TransferPO> transfers = po.getTransfers();
			ArrayList<BranchPO> branchs = po.getBranchs();
			ArrayList<AccountPO> accounts = po.getAccounts();
			ArrayList<FacilityPO> facilities = po.getFacilities();
			ArrayList<InventoryPO> inventories = po.getInventories();
			ArrayList<BankAccountPO> bankAccounts = po.getBankAccounts();
			return new OpeningStockVO(ID, date, transfers, branchs, accounts, facilities, inventories, bankAccounts);
		}
	}
}