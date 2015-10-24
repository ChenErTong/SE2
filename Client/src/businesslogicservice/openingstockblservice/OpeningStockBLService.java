package businesslogicservice.openingstockblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo.BankVO;
import vo.BranchVO;
import vo.FacilityVO;
import vo.InventoryVO;
import vo.TransferVO;
import vo.accountvo.AccountVO;

public interface OpeningStockBLService {
	/**建立期初账目，持久化更新涉及的对象的数据**/
	public ResultMessage add(
	ArrayList<TransferVO >commodities,
	ArrayList<BranchVO > brabches,
	ArrayList< AccountVO>accounts,
	ArrayList< FacilityVO > facilities,
	ArrayList< InventoryVO > inventories,
	ArrayList< BankVO > banks);
	/**查找到该期初账目**/
	public ResultMessage find (int id);
}
