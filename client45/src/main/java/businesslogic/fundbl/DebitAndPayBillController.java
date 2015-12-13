package businesslogic.fundbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

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
		return DebitAndPayBL.addDebitBill(vo);
	}

	/**
	 * @see DebitAndPayBillBLService#addPayBill(PaymentBillVO)
	 */
	public ResultMessage addPayBill(PaymentBillVO vo) throws RemoteException {
		return DebitAndPayBL.addPayBill(vo);
	}

//	/**
//	 * @see DebitAndPayBillBLService#submit(DebitAndPayBillVO)
//	 */
//	public ResultMessage submit(DebitAndPayBillVO vo) throws RemoteException {
//		return DebitAndPayBL.submit(vo);
//	}
//
//	/**
//	 * @see DebitAndPayBillBLService#save(DebitAndPayBillVO)
//	 */
//	public ResultMessage save(DebitAndPayBillVO vo) throws RemoteException {
//		return DebitAndPayBL.save(vo);
//	}

	/**
	 * @see DebitAndPayBillBLService#updateDraft(DebitAndPayBillVO)
	 */
	public ResultMessage updateDraft(DebitAndPayBillVO vo) throws RemoteException {
		return DebitAndPayBL.updateDraft(vo);
	}

	/*
	 * @Override public ResultMessage delete(String ID) { try { return
	 * DebitAndPayBL.delete(ID); } catch (RemoteException e) {
	 * e.printStackTrace(); } return null; }
	 */

}
