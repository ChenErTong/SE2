package businesslogic.recordbl;

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
import dataservice.recorddataservice.RecordDataService;
import po.receiptpo.DebitAndPayBillPO;
import state.ReceiptType;
import vo.BussinessConditionVO;
import vo.receiptvo.DebitAndPayBillVO;

public class Record {
	private RecordDataService recordData;
	private DebitAndPayBillDataService DebitAndPayBillData;

	public Record() {
		try {
			recordData = (RecordDataService) Naming.lookup(RMIConfig.PREFIX + RecordDataService.NAME);
			DebitAndPayBillData = (DebitAndPayBillDataService) Naming.lookup(RMIConfig.PREFIX + RecordDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<DebitAndPayBillVO> bussinessProcess(String begin, String end) throws RemoteException {
		ArrayList<DebitAndPayBillPO> POs = DebitAndPayBillData.showList(begin, end);
		ArrayList<DebitAndPayBillVO> VOs = new ArrayList<>();
		for (DebitAndPayBillPO po : POs) {
			DebitAndPayBillVO vo = poTOvo(po);
			VOs.add(vo);
		}
		return VOs;
	}

	public BussinessConditionVO bussinessCondition(String end) throws RemoteException {
		ArrayList<DebitAndPayBillPO> POs = DebitAndPayBillData.showList( end);
		double income = 0;
		double expense = 0;
		double profit = 0;
		for (DebitAndPayBillPO po : POs) {
			ReceiptType type = po.getType();
			// 如果是收款单
			if (type == ReceiptType.EXPENSE) {
				income = income + po.getMoney();
			}
			// 如果是付款单
			if (type == ReceiptType.PAY) {
				expense = expense + po.getMoney();
			}
		}
		profit = income - expense;
		BussinessConditionVO vo = new BussinessConditionVO(end, income, expense, profit);
		return vo;

	}

	public DebitAndPayBillVO poTOvo(DebitAndPayBillPO po) {
		ReceiptType type = po.getType();
		// 如果是收款单
		if (type == ReceiptType.EXPENSE) {
			DebitAndPayBillVO vo1 = new DebitAndPayBillVO(po.getID(), po.getMoney(), po.getCourierID(), po.getType(),
					po.getOrderNumbers());
			return vo1;
		}
		// 如果是付款单
		if (type == ReceiptType.PAY) {
			DebitAndPayBillVO vo2 = new DebitAndPayBillVO(po.getID(), po.getMoney(), po.getPayerName(),
					po.getBankAccouts(), po.getType(), po.getRentYear(), po.getSalaryMonth(), po.getItems(),
					po.getTransListNumber());
			return vo2;
		}
		return null;
	}

}
