package businesslogic.fundbl;

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
	DebitAndPayBill DebitAndPayBL = new DebitAndPayBill();

	@Override
	public String getPayID() throws RemoteException {
		return DebitAndPayBL.getPayID();
	}

	@Override
	public String getExpenseID() throws RemoteException {
		return DebitAndPayBL.getExpenseID();
	}

	@Override
	public DebitAndPayBillVO find(String ID) throws RemoteException {
		return DebitAndPayBL.find(ID);
	}

	@Override
	public ResultMessage addDebitBill(DebitBillVO vo) throws RemoteException {
		return DebitAndPayBL.addDebitBill(vo);
	}

	@Override
	public ResultMessage addPayBill(PaymentBillVO vo) throws RemoteException {
		return DebitAndPayBL.addPayBill(vo);
	}

	@Override
	public ResultMessage submit(DebitAndPayBillVO vo) throws RemoteException {
		return DebitAndPayBL.submit(vo);
	}

	@Override
	public ResultMessage save(DebitAndPayBillVO vo) throws RemoteException {
		return DebitAndPayBL.save(vo);
	}

	@Override
	public ResultMessage updateDraft(DebitAndPayBillVO vo) throws RemoteException {
		return DebitAndPayBL.updateDraft(vo);
	}

	/*
	 * @Override public ResultMessage delete(String ID) { try { return
	 * DebitAndPayBL.delete(ID); } catch (RemoteException e) {
	 * e.printStackTrace(); } return null; }
	 */

}
