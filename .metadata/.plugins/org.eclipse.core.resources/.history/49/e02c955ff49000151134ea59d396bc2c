package businesslogic.fundbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import businesslogicservice.fundblservice.DebitAndPayBillBLService;
import dataservice.funddataservice.BankAccountDataService;
import dataservice.funddataservice.DebitAndPayBillDataService;
import po.BankAccountPO;
import po.receiptpo.DebitAndPayBillPO;
import state.PayBillItem;
import state.ReceiptType;
import state.ResultMessage;
import vo.DebitAndPayBillVO;

public class DebitAndPayBill implements DebitAndPayBillBLService {
	private DebitAndPayBillDataService debitAndPayBillData;

	public DebitAndPayBill() {
		try {
			debitAndPayBillData = (DebitAndPayBillDataService) Naming
					.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/" + DebitAndPayBillDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getPayID() throws RemoteException {
		// TODO Auto-generated method stub
		return  debitAndPayBillData.getPayID();
	}

	@Override
	public String getExpenseID() throws RemoteException {
		// TODO Auto-generated method stub
		return  debitAndPayBillData.getExpenseID();
	}

	@Override
	public DebitAndPayBillVO find(String ID) throws RemoteException {
		DebitAndPayBillPO PO=debitAndPayBillData.find(ID);
		return  POtoVO(PO);
	}
   
	
	public DebitAndPayBillVO POtoVO(DebitAndPayBillPO PO){
	    ReceiptType type=PO.getType();
	    if(type==ReceiptType.EXPENSE){
	    	//收款单
	    	DebitAndPayBillVO vo=new DebitAndPayBillVO(PO.getID(),PO.getMoney(),PO.getCourierID(),PO.getType(),PO.getOrderNumbers());
	    	 return vo;
	    }
	   if(type==ReceiptType.PAY){
		   //付款单
		   DebitAndPayBillVO vo=new DebitAndPayBillVO(PO.getID(),PO.getMoney(),PO.getPayerName(),PO.getBankAccouts(),PO.getType(),PO.getRentYear(),PO.getSalaryMonth(),PO.getItems(),PO.getTransListNumber());
		   return vo;
	   }
	   else{
	   return null;
	   }
	   
   }
	@Override
	public HashMap<String, String> getAllBankAccounts() {
		return null;
		
	}

	@Override
	public ResultMessage addDebitAndPayBill(String operatorID, String operatorName) {
		DebitAndPayBillVO vo=new DebitAndPayBillVO(operatorName, 0, operatorName, null, null, operatorName, operatorName, null, null);
		/**
		 * String ID,double money,String payerName,ArrayList<BankAccountPO>bankAccouts,ReceiptType type,
			String rentYear,String salaryMonth,PayBillItem items,ArrayList transListNumber
		 */
		return null;
		
	}

	@Override
	public DebitAndPayBillVO submit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DebitAndPayBillVO save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateDraft(DebitAndPayBillVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage submitDraft(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpense() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayApproving() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseApproving() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayPass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpensePass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayFailure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseFailure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showPayDraft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> showExpenseDraft() {
		// TODO Auto-generated method stub
		return null;
	}

}
