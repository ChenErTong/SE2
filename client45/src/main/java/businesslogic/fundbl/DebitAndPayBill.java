package businesslogic.fundbl;

/**
 * @author LIUXUANLIN
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import config.RMIConfig;
import dataservice.funddataservice.DebitAndPayBillDataService;
import po.receiptpo.DebitAndPayBillPO;
import po.receiptpo.DebitBillPO;
import state.PayBillItem;
import state.ReceiptCondition;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import vo.receiptvo.DebitAndPayBillVO;
import vo.receiptvo.DebitBillVO;

public class DebitAndPayBill {
	private DebitAndPayBillDataService debitAndPayBillData;

	public DebitAndPayBill() {
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

	public String getExpenseID() throws RemoteException {
		return debitAndPayBillData.getExpenseID();
	}

	public String getPayID() throws RemoteException {
		return debitAndPayBillData.getPayID();
	}

	public DebitAndPayBillVO find(String ID) throws RemoteException {
		DebitAndPayBillPO PO = debitAndPayBillData.find(ID);
		return FundTrans.convertPOtoVO(PO);
	}

	// 建立收款单
	public ResultMessage addDebitBill(double money, String courierID, ReceiptType type, ArrayList<String> orderNumbers)
			throws RemoteException {
		// 疑问
		String ID = getExpenseID();
		DebitBillVO vo = new DebitBillVO(ID, type, courierID, money, orderNumbers);
		DebitBillPO po = FundTrans.convertVOtoPO(vo);
		return debitAndPayBillData.add(po);
	}

	/*// 建立付款单

	public ResultMessage addPayBill(double money, String payerName, ArrayList<String> bankAccouts,
			ReceiptType type, String rentYear, String salaryMonth, PayBillItem items, ArrayList<String> transListNumber)
					throws RemoteException {
		// 疑问
		String ID = null;
		
		
		DebitAndPayBillVO vo = new DebitAndPayBillVO(ID, money, payerName, bankAccouts, type, rentYear, salaryMonth,
				items, transListNumber);
		DebitAndPayBillPO po = FundTrans.convertVOtoPO(vo);
		return debitAndPayBillData.add(po);
	}*/
	public ResultMessage addPayBill(double money, String payerName, String accountID, ReceiptType type,
			PayBillItem items, String transferReceiptID) throws RemoteException {
				return null;
	}

	public ResultMessage submit(DebitAndPayBillPO po) throws RemoteException {
		po.setReceiptCondition(ReceiptCondition.SUBITTED);
		return debitAndPayBillData.modify(po);
	}

	public ResultMessage save(DebitAndPayBillPO po) throws RemoteException {
		debitAndPayBillData.add(po);
		return debitAndPayBillData.add(po);
	}

	public ResultMessage updateDraft(DebitAndPayBillPO po) throws RemoteException {
		debitAndPayBillData.modify(po);
		return debitAndPayBillData.modify(po);
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
