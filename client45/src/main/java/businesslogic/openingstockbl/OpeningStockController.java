package businesslogic.openingstockbl;

import java.util.ArrayList;

import businesslogicservice.openingstockblservice.OpeningStockBLService;
import state.ResultMessage;
import vo.BankAccountVO;
import vo.BranchVO;
import vo.FacilityVO;
import vo.InventoryVO;
import vo.TransferVO;
import vo.accountvo.AccountVO;

public class OpeningStockController implements OpeningStockBLService {

	@Override
	public ResultMessage add(
			ArrayList<TransferVO> commodities, 
			ArrayList<BranchVO> clients0,
			ArrayList<AccountVO> clients1, 
			ArrayList<FacilityVO> clients2, 
			ArrayList<InventoryVO> clients3,
			ArrayList<BankAccountVO> accounts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
