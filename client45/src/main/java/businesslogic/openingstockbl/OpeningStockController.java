package businesslogic.openingstockbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.logbl.LogController;
import businesslogicservice.openingstockblservice.OpeningStockBLService;
import state.ResultMessage;
import vo.OpeningStockVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:36:15
 */
public class OpeningStockController implements OpeningStockBLService {

	private OpeningStock OpeningStockBL;

	public OpeningStockController() throws MalformedURLException, RemoteException, NotBoundException {
		OpeningStockBL = new OpeningStock();
	}

	/*
	 * @Override public ResultMessage add(ArrayList<TransferVO> transferVOs,
	 * ArrayList<BranchVO> branchVOs, ArrayList<AccountVO> accountVOs,
	 * ArrayList<FacilityVO> facilityVOs, ArrayList<InventoryVO> inventoryVOs,
	 * ArrayList<BankAccountVO> bankAccountVOs) throws RemoteException { return
	 * OpeningStockBL.add(transferVOs, branchVOs, accountVOs, facilityVOs,
	 * inventoryVOs, bankAccountVOs); }
	 */

	// @Override
	// public ResultMessage find(int id) throws RemoteException {
	// // TODO 查找
	// return null;
	// }

	/**
	 * @see OpeningStockBLService#add()
	 */
	public ResultMessage add() throws RemoteException {
		LogController.getInstance().addLog("添加期初账目");
		ResultMessage resultMessage = OpeningStockBL.add();
		return resultMessage;
	}

	/**
	 * @see OpeningStockBLService#show()
	 */
	public ArrayList<OpeningStockVO> show() throws RemoteException {
		return OpeningStockBL.show();
	}

}
