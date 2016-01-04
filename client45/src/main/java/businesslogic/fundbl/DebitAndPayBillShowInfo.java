package businesslogic.fundbl;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
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

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:34:48
 */
public class DebitAndPayBillShowInfo implements DebitAndPayBillShowInfo_Record {
	DebitAndPayBill debitAndPayBill;
	DebitAndPayBillDataService debitAndPayBillData;
	AccountInfo_DebitAndPayBillVOShow accountInfo;

	public DebitAndPayBillShowInfo() throws MalformedURLException, RemoteException, NotBoundException {
		debitAndPayBill = new DebitAndPayBill();
		debitAndPayBillData = debitAndPayBill.getData();
		accountInfo = new AccountInfo();
	}

	/**
	 * @see DebitAndPayBillShowInfo_Record#getBusinessProcess(String, String)
	 */
	public ArrayList<DebitAndPayBillVO> getBusinessProcess(String startDate, String endDate) throws RemoteException {
		ArrayList<DebitAndPayBillPO> POs = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> VOs = new ArrayList<>();
		System.out.println(startDate);
		System.out.println(endDate);
		for (DebitAndPayBillPO debitAndPayBillPO : POs) {
			System.out.println(debitAndPayBillPO.getID());
			System.out.println(debitAndPayBillPO.getDate());
			if (inDate(debitAndPayBillPO, startDate, endDate)) {
				DebitAndPayBillVO vo = FundTrans.convertPOtoVO(debitAndPayBillPO);
				VOs.add(vo);
			}
		}
		return VOs;
	}

	/**
	 * @see DebitAndPayBillShowInfo_Record#getBussinessCondition(String)
	 */
	public BussinessConditionVO getBussinessCondition(String endDate) throws RemoteException {
		ArrayList<DebitAndPayBillPO> POs = debitAndPayBillData.find();
		BigDecimal income = new BigDecimal(0);
		BigDecimal expense = new BigDecimal(0);
		BigDecimal profit = new BigDecimal(0);
		for (DebitAndPayBillPO debitAndPayBillPO : POs) {
			ReceiptType type = debitAndPayBillPO.getReceiptType();
			if (type == ReceiptType.DEBIT){
				income = income.add(debitAndPayBillPO.getMoney());
			} else if (type == ReceiptType.PAY) {
				expense = expense.add(debitAndPayBillPO.getMoney());
			}
		}
		profit = income.subtract(expense);
		BussinessConditionVO vo = new BussinessConditionVO(endDate, income, expense, profit);
		return vo;
	}

	/**
	 * @see DebitAndPayBillShowInfo_Record#getBussinessOneDayIncome(String,
	 *      String)
	 */
	public BussinessOneDayVO getBussinessOneDayIncome(String branch, String date) throws RemoteException {
		ArrayList<DebitBillVO> debits = new ArrayList<>();
		BigDecimal income = new BigDecimal(0);
		ArrayList<DebitAndPayBillPO> POs = debitAndPayBillData.find();
		for (DebitAndPayBillPO debitAndPayBillPO : POs) {
			if (debitAndPayBillPO.getDate().equals(date) && debitAndPayBillPO.getReceiptType() == ReceiptType.DEBIT) {
				DebitBillPO po = (DebitBillPO) debitAndPayBillPO;
				if (accountInfo.isAccountAMemberOfBranch(po.getCourierID(), branch)) {
					income = income.add(debitAndPayBillPO.getMoney());
					DebitBillVO vo = FundTrans.convertDebitPOtoDebitVO(po);
					debits.add(vo);
				}
			}
		}
		System.out.println(debits.size());
		if(debits.size()==0)
			return null;
		return new BussinessOneDayVO(debits, income);
	}

	/**
	 * 判断单据的日期是否在开始日期和结束日期之间
	 * 
	 * @param po
	 *            DebitAndPayBillPO型，单据
	 * @param beginDate
	 *            String型，开始日期
	 * @param endDate
	 *            String型，结束日期
	 * @return boolean型，判断结构
	 */
	private boolean inDate(DebitAndPayBillPO po, String beginDate, String endDate) {
		if (po.getDate().compareTo(beginDate) >= 0 && po.getDate().compareTo(endDate) <= 0)
			return true;
		return false;
	}

}
