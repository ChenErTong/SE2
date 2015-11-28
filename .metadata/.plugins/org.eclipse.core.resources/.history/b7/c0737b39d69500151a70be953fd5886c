package businesslogic.recordbl;

/**
 * @author LIUXUANLIN
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.accountbl.Account;
import businesslogic.fundbl.FundTrans;
import config.RMIConfig;
import dataservice.accountdataservice.AccountDataService;
import dataservice.funddataservice.DebitAndPayBillDataService;
import po.accountpo.AccountPO;
import po.receiptpo.DebitAndPayBillPO;
import po.receiptpo.DebitBillPO;
import state.ReceiptType;
import vo.BussinessConditionVO;
import vo.BussinessOneDayVO;
import vo.receiptvo.DebitAndPayBillVO;
import vo.receiptvo.DebitBillVO;

public class Record {
	private DebitAndPayBillDataService DebitAndPayBillData;
	private AccountDataService AccountData;

	public Record() {
		try {
			DebitAndPayBillData = (DebitAndPayBillDataService) Naming.lookup(RMIConfig.PREFIX + DebitAndPayBillDataService.NAME);
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
		ArrayList<DebitAndPayBillVO> VOs = FundTrans.convertDebitAndPayBillPOstoVOs(POs);
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
			if (type == ReceiptType.DEBIT) {
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
	public BussinessOneDayVO bussinessOneDay(String WorkPlace,String date) throws RemoteException {
		ArrayList<AccountPO> AccountPos=AccountData.find();
		String ID = null;
		for (AccountPO po : AccountPos) {
			if(WorkPlace==po.getBranchID()){
				 ID= po.getID();
			}
	 }
		ArrayList<DebitBillPO> POs = DebitAndPayBillData.showDate(date);
		ArrayList<DebitBillVO> VOs=new ArrayList<DebitBillVO>();
		double income = 0;

		for (DebitAndPayBillPO po : POs) {
			ReceiptType type = po.getType();
			// 如果是收款单
			if (type == ReceiptType.DEBIT) {
			}
		}
		for (DebitBillPO po : POs) {

				income = income + po.getMoney();
              if( po.getCourierID()==ID){
            	  VOs.add(FundTrans.convertDebitPOtoDebitVO(po));
              }
		 }
		BussinessOneDayVO bussinessOneDayvo=new BussinessOneDayVO(VOs,income);
		return bussinessOneDayvo;
		 
	}
}

