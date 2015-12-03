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
public class DebitAndPayBillController implements DebitAndPayBillBLService{
    DebitAndPayBill DebitAndPayBL = new DebitAndPayBill();
	@Override
	public String getPayID() {
		try {
			return DebitAndPayBL.getPayID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getExpenseID() {
		try {
			return DebitAndPayBL.getExpenseID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DebitAndPayBillVO find(String ID) {
		try {
			return DebitAndPayBL.find(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public ResultMessage addDebitBill(DebitBillVO vo) {
		try {
			return DebitAndPayBL.addDebitBill(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ResultMessage addPayBill(PaymentBillVO vo) {
		try {
			return DebitAndPayBL.addPayBill(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public ResultMessage submit(DebitAndPayBillVO vo) {
		try {
			return DebitAndPayBL.submit(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage save(DebitAndPayBillVO vo) {
		try {
			return DebitAndPayBL.save(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage updateDraft(DebitAndPayBillVO vo) {
		try {
			return DebitAndPayBL.updateDraft(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage delete(String ID) {
		try {
			return DebitAndPayBL.delete(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}


}
