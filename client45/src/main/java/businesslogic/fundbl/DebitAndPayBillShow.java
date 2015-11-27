package businesslogic.fundbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import config.RMIConfig;
import dataservice.funddataservice.DebitAndPayBillDataService;
import po.receiptpo.DebitAndPayBillPO;
import state.ReceiptState;
import state.ReceiptType;
import vo.receiptvo.DebitAndPayBillVO;

public class DebitAndPayBillShow {
	
	private DebitAndPayBillDataService debitAndPayBillData;

	public DebitAndPayBillShow() {
		try {
			debitAndPayBillData = (DebitAndPayBillDataService) Naming
					.lookup(RMIConfig.PREFIX + DebitAndPayBillDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<DebitAndPayBillVO> showPay() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.show(ReceiptType.PAY);
		ArrayList<DebitAndPayBillVO> vos = FundTrans.convertDebitAndPayBillPOstoVOs(pos);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showExpense() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.show(ReceiptType.EXPENSE);
		ArrayList<DebitAndPayBillVO> vos = FundTrans.convertDebitAndPayBillPOstoVOs(pos);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showPayApproving() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.show(ReceiptType.PAY, ReceiptState.APPROVALING);
		ArrayList<DebitAndPayBillVO> vos = FundTrans.convertDebitAndPayBillPOstoVOs(pos);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showExpenseApproving() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.show(ReceiptType.PAY, ReceiptState.APPROVALING);
		ArrayList<DebitAndPayBillVO> vos = FundTrans.convertDebitAndPayBillPOstoVOs(pos);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showPayPass() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.show(ReceiptType.PAY, ReceiptState.SUCCESS);
		ArrayList<DebitAndPayBillVO> vos = FundTrans.convertDebitAndPayBillPOstoVOs(pos);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showExpensePass() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.show(ReceiptType.EXPENSE, ReceiptState.SUCCESS);
		ArrayList<DebitAndPayBillVO> vos = FundTrans.convertDebitAndPayBillPOstoVOs(pos);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showPayFailure() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.show(ReceiptType.PAY, ReceiptState.FAILURE);
		ArrayList<DebitAndPayBillVO> vos = FundTrans.convertDebitAndPayBillPOstoVOs(pos);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showExpenseFailure() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.show(ReceiptType.EXPENSE, ReceiptState.FAILURE);
		ArrayList<DebitAndPayBillVO> vos = FundTrans.convertDebitAndPayBillPOstoVOs(pos);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showPayDraft() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.show(ReceiptType.PAY, ReceiptState.DRAFT);
		ArrayList<DebitAndPayBillVO> vos = FundTrans.convertDebitAndPayBillPOstoVOs(pos);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showExpenseDraft() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.show(ReceiptType.EXPENSE, ReceiptState.DRAFT);
		ArrayList<DebitAndPayBillVO> vos = FundTrans.convertDebitAndPayBillPOstoVOs(pos);
		return vos;
	}
}
