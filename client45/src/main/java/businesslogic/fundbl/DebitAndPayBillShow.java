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
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:34:37
 */
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
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos = this.show(pos,ReceiptType.PAY,null);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showExpense() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos = this.show(pos,ReceiptType.DEBIT,null);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showPayApproving() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos =  this.show(pos,ReceiptType.PAY, ReceiptState.APPROVALING);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showExpenseApproving() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos =  this.show(pos,ReceiptType.DEBIT, ReceiptState.APPROVALING);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showPayPass() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos =  debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos =  this.show(pos,ReceiptType.PAY, ReceiptState.SUCCESS);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showExpensePass() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos =  debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos = this.show(pos,ReceiptType.DEBIT, ReceiptState.SUCCESS);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showPayFailure() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos =this.show(pos,ReceiptType.PAY, ReceiptState.FAILURE);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showExpenseFailure() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos = this.show(pos, ReceiptType.DEBIT, ReceiptState.FAILURE);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showPayDraft() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos =  this.show(pos, ReceiptType.PAY, ReceiptState.DRAFT);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showExpenseDraft() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos = this.show(pos, ReceiptType.DEBIT, ReceiptState.DRAFT);
		return vos;
	}
	
	private ArrayList<DebitAndPayBillVO> show(ArrayList<DebitAndPayBillPO> pos,ReceiptType type,ReceiptState state){
		ArrayList<DebitAndPayBillVO> vos = new ArrayList<>();
		for (DebitAndPayBillPO debitAndPayBillPO : pos) {
			boolean isCorrectType = debitAndPayBillPO.getReceiptType().equals(type);
			boolean isCorrectState = debitAndPayBillPO.getReceiptState().equals(state);
			if(isCorrectType&&isCorrectState){
				DebitAndPayBillVO vo  =FundTrans.convertPOtoVO(debitAndPayBillPO);
				vos.add(vo);
			}
		}
		return vos;
	}
	
	public ArrayList<DebitAndPayBillVO> showList(String end) throws RemoteException{
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos =new ArrayList<>();
		for (DebitAndPayBillPO debitAndPayBillPO : pos) {
			if(debitAndPayBillPO.getDate().compareTo(end)<=0){
				DebitAndPayBillVO vo = FundTrans.convertPOtoVO(debitAndPayBillPO);
				vos.add(vo);
			}
		}
		return vos;
	}
}
