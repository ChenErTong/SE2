package businesslogic.fundbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.receiptbl.Receipt;
import config.RMIConfig;
import dataservice.funddataservice.DebitAndPayBillDataService;
import po.receiptpo.DebitAndPayBillPO;
import state.ReceiptState;
import state.ReceiptType;
import vo.receiptvo.DebitAndPayBillVO;

/**
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:34:37
 */
public class DebitAndPayBillShow {

	private DebitAndPayBillDataService debitAndPayBillData;
	private Receipt receipt;

	public DebitAndPayBillShow() throws MalformedURLException, RemoteException, NotBoundException {
		debitAndPayBillData = (DebitAndPayBillDataService) Naming
				.lookup(RMIConfig.PREFIX + DebitAndPayBillDataService.NAME);
		receipt=new Receipt();
	}

	public ArrayList<DebitAndPayBillVO> showPay() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos = this.show(pos, ReceiptType.PAY, null);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showExpense() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos = this.show(pos, ReceiptType.DEBIT, null);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showPayApproving() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos = this.show(pos, ReceiptType.PAY, ReceiptState.APPROVALING);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showExpenseApproving() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos = this.show(pos, ReceiptType.DEBIT, ReceiptState.APPROVALING);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showPayPass() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos = this.show(pos, ReceiptType.PAY, ReceiptState.SUCCESS);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showExpensePass() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos = this.show(pos, ReceiptType.DEBIT, ReceiptState.SUCCESS);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showPayFailure() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos = this.show(pos, ReceiptType.PAY, ReceiptState.FAILURE);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showExpenseFailure() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos = this.show(pos, ReceiptType.DEBIT, ReceiptState.FAILURE);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showPayDraft() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos = this.show(pos, ReceiptType.PAY, ReceiptState.DRAFT);
		return vos;
	}

	public ArrayList<DebitAndPayBillVO> showExpenseDraft() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos = this.show(pos, ReceiptType.DEBIT, ReceiptState.DRAFT);
		return vos;
	}

	/**
	 * 返回给定日期前的单据列表
	 * 
	 * @param end
	 *            String型，给定日期
	 * @return ArrayList<DebitAndPayBillVO>型，符合条件的单据列表
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<DebitAndPayBillVO> showList(String end) throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> vos = new ArrayList<>();
		for (DebitAndPayBillPO debitAndPayBillPO : pos) {
			if (debitAndPayBillPO.getDate().compareTo(end) <= 0) {
				DebitAndPayBillVO vo = FundTrans.convertPOtoVO(debitAndPayBillPO);
				vos.add(vo);
			}
		}
		return vos;
	}

	/**
	 * 根据单据类型和单据状态返回符合条件的单据
	 * 
	 * @param pos
	 *            ArrayList<DebitAndPayBillPO>型，所有的单据
	 * @param type
	 *            ReceiptType型，单据类型
	 * @param state
	 *            ReceiptState型，单据状态
	 * @return ArrayList<DebitAndPayBillVO>型，符合条件的单据列表
	 */
	private ArrayList<DebitAndPayBillVO> show(ArrayList<DebitAndPayBillPO> pos, ReceiptType type, ReceiptState state) {
		ArrayList<DebitAndPayBillVO> vos = new ArrayList<>();
		for (DebitAndPayBillPO debitAndPayBillPO : pos) {
			boolean isCorrectType = debitAndPayBillPO.getReceiptType().equals(type);
			boolean isCorrectState = debitAndPayBillPO.getReceiptState().equals(state);
			if (isCorrectType && isCorrectState) {
				DebitAndPayBillVO vo = FundTrans.convertPOtoVO(debitAndPayBillPO);
				vos.add(vo);
			}
		}
		return vos;
	}
	
	public <T extends DebitAndPayBillVO> ArrayList<T> show(ReceiptType type,ReceiptState state) throws RemoteException{
		if(type==null)
			System.out.println("wrong!!!!!!!!!!!!我没考虑这种情况");
		return receipt.show(type, state);
	}
}
