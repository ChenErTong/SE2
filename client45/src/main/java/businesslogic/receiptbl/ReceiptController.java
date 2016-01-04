package businesslogic.receiptbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.logbl.LogController;
import businesslogicservice.receiptblservice.ReceiptBLService;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import vo.receiptvo.ReceiptVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:37:54
 */
public class ReceiptController implements ReceiptBLService {
	Receipt ReceiptBL;

	public ReceiptController() throws MalformedURLException, RemoteException, NotBoundException {
		ReceiptBL = new Receipt();
	}

	/**
	 * @see ReceiptBLService#updateReceipt(ReceiptVO)
	 */
	public ResultMessage updateReceipt(ReceiptVO receiptVO) throws RemoteException {
		LogController.getInstance().addLog("更新单据信息");
		return ReceiptBL.updateReceipt(receiptVO);
	}

	/**
	 * @see ReceiptBLService#passReceipt(ArrayList)
	 */
	public ResultMessage passReceipt(ArrayList<ReceiptVO> VOs) throws RemoteException {
		LogController.getInstance().addLog("通过单据");
		return ReceiptBL.passReceipt(VOs);
	}

	/**
	 * @see ReceiptBLService#dontPassReceipt(ArrayList)
	 */
	public ResultMessage dontPassReceipt(ArrayList<ReceiptVO> VOs) throws RemoteException {
		LogController.getInstance().addLog("否决单据");
		return ReceiptBL.dontPassReceipt(VOs);
	}

	/**
	 * @see ReceiptBLService#show(ReceiptType, ReceiptState)
	 */
	public <T extends ReceiptVO> ArrayList<T> show(ReceiptType type, ReceiptState state) throws RemoteException {
		return ReceiptBL.show(type, state);
	}

}
