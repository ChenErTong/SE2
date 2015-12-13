package businesslogic.fundbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.receiptbl.ReceiptInfo;
import config.RMIConfig;
import dataservice.funddataservice.DebitAndPayBillDataService;
import po.receiptpo.DebitAndPayBillPO;
import po.receiptpo.DebitBillPO;
import po.receiptpo.PaymentBillPO;
import state.ReceiptType;
import state.ResultMessage;
import vo.receiptvo.DebitAndPayBillVO;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.PaymentBillVO;

/**
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:34:17
 */
public class DebitAndPayBill {
	private DebitAndPayBillDataService debitAndPayBillData;
	private ReceiptInfo_DebitAndPayBill receiptInfo;

	public DebitAndPayBill() throws MalformedURLException, RemoteException, NotBoundException {
		debitAndPayBillData = getData();
		receiptInfo = new ReceiptInfo();
	}

	public DebitAndPayBillDataService getData() throws MalformedURLException, RemoteException, NotBoundException {
		return (DebitAndPayBillDataService) Naming.lookup(RMIConfig.PREFIX + DebitAndPayBillDataService.NAME);
	}

	public String getExpenseID() throws RemoteException {
		return debitAndPayBillData.getID(ReceiptType.DEBIT);
	}

	public String getPayID() throws RemoteException {
		return debitAndPayBillData.getID(ReceiptType.PAY);
	}

	public DebitAndPayBillVO find(String ID) throws RemoteException {
		DebitAndPayBillPO PO = debitAndPayBillData.find(ID);
		return FundTrans.convertPOtoVO(PO);
	}

	/*
	 * public ResultMessage delete(String ID) throws RemoteException { return
	 * debitAndPayBillData.delete(ID); }
	 */

	// 建立收款单
	//12.11 如果审批通过就改变账户余额
	public ResultMessage addDebitBill(DebitBillVO vo) throws RemoteException {
		DebitBillPO po = FundTrans.convertVOtoPO(vo);
		if (receiptInfo.add(vo) == ResultMessage.SUCCESS)
			return debitAndPayBillData.add(po);
		return ResultMessage.FAIL;
	}

	public ResultMessage addPayBill(PaymentBillVO vo) throws RemoteException {
		PaymentBillPO po = FundTrans.convertVOtoPO(vo);
		if (receiptInfo.add(vo) == ResultMessage.SUCCESS)
			return debitAndPayBillData.add(po);
		return ResultMessage.FAIL;
	}

//	public ResultMessage submit(DebitAndPayBillVO vo) throws RemoteException {
//		vo.receiptState = ReceiptState.APPROVALING;
//		DebitAndPayBillPO po = FundTrans.convertVOtoPO(vo);
//		po.setReceiptState(ReceiptState.APPROVALING);
//		if (receiptInfo.modify(vo) == ResultMessage.SUCCESS)
//			return debitAndPayBillData.modify(po)==null?ResultMessage.FAIL:ResultMessage.SUCCESS;
//		return ResultMessage.FAIL;
//	}
//
//	public ResultMessage save(DebitAndPayBillVO vo) throws RemoteException {
//		DebitAndPayBillPO po = FundTrans.convertVOtoPO(vo);
//		if (receiptInfo.add(vo) == ResultMessage.SUCCESS)
//			return debitAndPayBillData.add(po);
//		return ResultMessage.FAIL;
//	}

	public ResultMessage updateDraft(DebitAndPayBillVO vo) throws RemoteException {
		DebitAndPayBillPO po = FundTrans.convertVOtoPO(vo);
		if (receiptInfo.modify(vo) == ResultMessage.SUCCESS)
			return debitAndPayBillData.modify(po)==null?ResultMessage.FAIL:ResultMessage.SUCCESS;
		return ResultMessage.FAIL;
	}
}
