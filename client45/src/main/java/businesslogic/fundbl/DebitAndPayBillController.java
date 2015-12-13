package businesslogic.fundbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.logbl.LogController;
import businesslogicservice.fundblservice.DebitAndPayBillBLService;
import state.ResultMessage;
import vo.receiptvo.DebitAndPayBillVO;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.PaymentBillVO;

/**
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:34:31
 */
public class DebitAndPayBillController implements DebitAndPayBillBLService {
	DebitAndPayBill DebitAndPayBL ;

	public DebitAndPayBillController() throws MalformedURLException, RemoteException, NotBoundException {
		DebitAndPayBL = new DebitAndPayBill();
	}
	/**
	 * @see DebitAndPayBillBLService#getPayID()
	 */
	public String getPayID() throws RemoteException {
		return DebitAndPayBL.getPayID();
	}

	/**
	 * @see DebitAndPayBillBLService#getExpenseID()
	 */
	public String getExpenseID() throws RemoteException {
		return DebitAndPayBL.getExpenseID();
	}

	/**
	 * @see DebitAndPayBillBLService#find(String)
	 */
	public DebitAndPayBillVO find(String ID) throws RemoteException {
		return DebitAndPayBL.find(ID);
	}

	/**
	 * @see DebitAndPayBillBLService#addDebitBill(DebitBillVO)
	 */
	public ResultMessage addDebitBill(DebitBillVO vo) throws RemoteException {
		LogController.getInstance().addLog("添加收款单");
		return DebitAndPayBL.addDebitBill(vo);
	}

	/**
	 * @see DebitAndPayBillBLService#addPayBill(PaymentBillVO)
	 */
	public ResultMessage addPayBill(PaymentBillVO vo) throws RemoteException {
		LogController.getInstance().addLog("添加付款单");
		return DebitAndPayBL.addPayBill(vo);
	}

	/**
	 * @see DebitAndPayBillBLService#updateDraft(DebitAndPayBillVO)
	 */
	public ResultMessage updateDraft(DebitAndPayBillVO vo) throws RemoteException {
		LogController.getInstance().addLog("更新收款单");
		return DebitAndPayBL.updateDraft(vo);
	}

}
