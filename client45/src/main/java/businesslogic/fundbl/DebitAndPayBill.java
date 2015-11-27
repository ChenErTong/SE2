package businesslogic.fundbl;

/**
 * @author LIUXUANLIN
 */
/**
 * @author Ann
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
import po.receiptpo.PaymentBillPO;
import state.PayBillItem;
import state.ReceiptCondition;
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
		String ID = getExpenseID();
		DebitBillVO vo = new DebitBillVO(ID, type, courierID, money, orderNumbers);
		DebitBillPO po = FundTrans.convertVOtoPO(vo);
		return debitAndPayBillData.add(po);
	}

	public ResultMessage addPayBill(double money, String payerName, String accountID, ReceiptType type,
			PayBillItem items, String transferReceiptID, String remarks) throws RemoteException {
		String ID = getPayID();
		PaymentBillPO po = new PaymentBillPO(ID, type, money, payerName, items, accountID, remarks);
		return debitAndPayBillData.add(po);
	}

	public ResultMessage submit(DebitAndPayBillVO vo) throws RemoteException {
		DebitAndPayBillPO po = FundTrans.convertVOtoPO(vo);
		po.setReceiptCondition(ReceiptCondition.SUBITTED);
		return debitAndPayBillData.modify(po);
	}

	public ResultMessage save(DebitAndPayBillVO vo) throws RemoteException {
//		debitAndPayBillData.add(po);
		DebitAndPayBillPO po = FundTrans.convertVOtoPO(vo);
		return debitAndPayBillData.add(po);
	}

	public ResultMessage updateDraft(DebitAndPayBillVO vo) throws RemoteException {
//		debitAndPayBillData.modify(po);
		DebitAndPayBillPO po = FundTrans.convertVOtoPO(vo);
		return debitAndPayBillData.modify(po);
	}



}
