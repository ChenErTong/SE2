package businesslogic.fundbl;
/**
 * @author LIUXUANLIN
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.fundblservice.DebitAndPayBillBLService;
import state.PayBillItem;
import state.ReceiptType;
import state.ResultMessage;
import vo.receiptvo.DebitAndPayBillVO;

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
	public ResultMessage addDebitBill(double money, String courierID, ReceiptType type, ArrayList<String> orderNumbers) {
		try {
			return DebitAndPayBL.addDebitBill(money, courierID, type, orderNumbers);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ResultMessage addPayBill(double money, String payerName, String accountID, ReceiptType type,
			PayBillItem items, String transferReceiptID,String remarks) {
		try {
			return DebitAndPayBL.addPayBill(money, payerName, accountID, type, items, transferReceiptID,remarks);
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
