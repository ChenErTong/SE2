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

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:36:19
 */
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

	public static ArrayList<OpeningStockVO> convertPOstoVOs(ArrayList<OpeningStockPO> pos) {
		ArrayList<OpeningStockVO> vos = new ArrayList<OpeningStockVO>();
		for (OpeningStockPO po : pos) {
			OpeningStockVO vo = convertPOtoVO(po);
			vos.add(vo);
		}
		return vos;
	}
}
