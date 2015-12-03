package businesslogicservice.openingstockblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo.BankAccountVO;
import vo.BranchVO;
import vo.FacilityVO;
import vo.InventoryVO;
import vo.OpeningStockVO;
import vo.TransferVO;
import vo.accountvo.AccountVO;

public interface OpeningStockBLService {
	/**建立期初账目，持久化更新涉及的对象的数据**/
	public ResultMessage add(
	ArrayList<TransferVO >commodities,
	ArrayList<BranchVO > clients0,
	ArrayList< AccountVO>clients1,
	ArrayList< FacilityVO > clients2,
	ArrayList< InventoryVO > clients3,
	ArrayList< BankAccountVO > accounts);
	/**查找到该期初账目**/
	public ResultMessage add();
	public ResultMessage find (int id);
	public ArrayList<OpeningStockVO> show();
}
