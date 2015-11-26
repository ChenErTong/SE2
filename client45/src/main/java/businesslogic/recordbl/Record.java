package businesslogic.recordbl;

/**
 * @author LIUXUANLIN
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.fundbl.FundTrans;
import config.RMIConfig;
import dataservice.funddataservice.DebitAndPayBillDataService;
import dataservice.recorddataservice.BusinessConditionDataService;
import dataservice.recorddataservice.BusinessProcessDataService;
import po.receiptpo.DebitAndPayBillPO;
import state.ReceiptType;
import vo.BussinessConditionVO;
import vo.receiptvo.DebitAndPayBillVO;

public class Record {
	private BusinessProcessDataService businessProcessData;
	private BusinessConditionDataService businessConditionData;
	private DebitAndPayBillDataService DebitAndPayBillData;

	public Record() {
		try {
			businessProcessData = (BusinessProcessDataService) Naming.lookup(RMIConfig.PREFIX + BusinessProcessDataService.NAME);
			businessConditionData = (BusinessConditionDataService) Naming.lookup(RMIConfig.PREFIX + BusinessConditionDataService.NAME);
			DebitAndPayBillData = (DebitAndPayBillDataService) Naming.lookup(RMIConfig.PREFIX + DebitAndPayBillDataService.NAME);
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
			DebitAndPayBillVO vo = FundTrans.convertPOtoVO(po);
			VOs.add(vo);
		}
		return VOs;
	}

	public BussinessConditionVO bussinessCondition(String end) throws RemoteException {
		ArrayList<DebitAndPayBillPO> POs = DebitAndPayBillData.showList(end);
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

}
