package businesslogic.fundbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.accountbl.AccountInfo;
import businesslogic.recordbl.DebitAndPayBillShowInfo_Record;
import dataservice.funddataservice.DebitAndPayBillDataService;
import po.receiptpo.DebitAndPayBillPO;
import po.receiptpo.DebitBillPO;
import state.ReceiptType;
import vo.BussinessConditionVO;
import vo.BussinessOneDayVO;
import vo.receiptvo.DebitAndPayBillVO;
import vo.receiptvo.DebitBillVO;

public class DebitAndPayBillShowInfo implements DebitAndPayBillShowInfo_Record {
	DebitAndPayBill debitAndPayBill;
	DebitAndPayBillDataService debitAndPayBillData;
	public DebitAndPayBillShowInfo() {
		debitAndPayBill = new DebitAndPayBill();
		debitAndPayBillData = debitAndPayBill.getData();
	}
	@Override
	public ArrayList<DebitAndPayBillVO> getBusinessProcess(String startDate, String endDate) throws RemoteException {
		ArrayList<DebitAndPayBillPO> POs = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> VOs = new ArrayList<>();
		for (DebitAndPayBillPO debitAndPayBillPO : POs) {
			if(inDate(debitAndPayBillPO, startDate, endDate)){
				DebitAndPayBillVO vo = FundTrans.convertPOtoVO(debitAndPayBillPO);
				VOs.add(vo);
			}
		}
		return VOs;
	}
	@Override
	public BussinessConditionVO getBussinessCondition(String endDate) throws RemoteException {
		ArrayList<DebitAndPayBillPO> POs = debitAndPayBillData.find();
		double income = 0;
		double expense = 0;
		double profit = 0;
		for (DebitAndPayBillPO debitAndPayBillPO : POs) {
			ReceiptType type =debitAndPayBillPO.getReceiptType();
			if(type==ReceiptType.DEBIT)	expense+=debitAndPayBillPO.getMoney();
			else if(type==ReceiptType.PAY)	profit+=debitAndPayBillPO.getMoney();
		}
		profit = income - expense;
		BussinessConditionVO vo = new BussinessConditionVO(endDate, income, expense, profit);
		return vo;
	}
	private boolean inDate(DebitAndPayBillPO po, String beginDate, String endDate) {
		if (po.getDate().compareTo(beginDate) >= 0 && po.getDate().compareTo(endDate) <= 0)
			return true;
		return false;
	}
	@Override
	public BussinessOneDayVO getBussinessOneDayIncome(String branch, String date) throws RemoteException {
		AccountInfo_DebitAndPayBillVOShow accountInfo = new AccountInfo();
		ArrayList<DebitBillVO> debits = new ArrayList<>();
		double income = 0;
		ArrayList<DebitAndPayBillPO> POs = debitAndPayBillData.find();
		for (DebitAndPayBillPO debitAndPayBillPO : POs) {
			if(debitAndPayBillPO.getDate().equals(date)&&debitAndPayBillPO.getReceiptType()==ReceiptType.DEBIT){
				DebitBillPO po = (DebitBillPO)debitAndPayBillPO;
				if(accountInfo.isAccountAMemberOfBranch(po.getCourierID(), branch)){
					income+=debitAndPayBillPO.getMoney();
					DebitBillVO vo = FundTrans.convertDebitPOtoDebitVO(po);
					debits.add(vo);
				}
			}
		}
		return new BussinessOneDayVO(debits, income);
	}
	

}
