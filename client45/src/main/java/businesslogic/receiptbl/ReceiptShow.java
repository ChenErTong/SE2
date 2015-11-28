package businesslogic.receiptbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import config.RMIConfig;
import dataservice.receiptdataservice.ReceiptDataService;
import po.receiptpo.ReceiptPO;
import state.ReceiptState;
import state.ReceiptType;
import vo.receiptvo.AdjustReceiptVO;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.PaymentBillVO;
import vo.receiptvo.ReceiptVO;
import vo.receiptvo.orderreceiptvo.BranchArrivalListVO;
import vo.receiptvo.orderreceiptvo.DeliveryListVO;
import vo.receiptvo.orderreceiptvo.LoadingListVO;
import vo.receiptvo.orderreceiptvo.TransferArrivalListVO;
import vo.receiptvo.orderreceiptvo.TransferOrderVO;

public class ReceiptShow {
	
	private ReceiptDataService  receiptData;

	public ReceiptShow() {
		try {
			receiptData = (ReceiptDataService ) Naming
					.lookup(RMIConfig.PREFIX + ReceiptDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<ReceiptVO> show()  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<BranchArrivalListVO> showBranchArrivalList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DeliveryListVO> showDeliveryList()  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<LoadingListVO> showLoadingList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TransferArrivalListVO> showTransferArrivalList()  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TransferOrderVO> showTransferOrder() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<AdjustReceiptVO> showAdjustReceipt() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DebitBillVO> showDebitBill() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<InventoryExportReceiptVO> showInventoryExportReceipt()  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<InventoryImportReceiptVO> showInventoryImportReceipt()  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PaymentBillVO> showPaymentBill() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public <T extends ReceiptVO> ArrayList<T> findTypeReceipt(ReceiptType type,ReceiptState state) throws RemoteException {
		ArrayList<ReceiptPO> pos = receiptData.find();
		ArrayList<T> vos = new ArrayList<>();
		for (ReceiptPO receiptPO : pos) {
			if(receiptPO.getReceiptType().equals(type)||receiptPO.getReceiptState().equals(state)){
				@SuppressWarnings("unchecked")
				T vo = (T) ReceiptTrans.convertPOtoVO(receiptPO);
				vos.add(vo);
			}
		}
		return vos;
	}
	
	public static void main(String[] args) {
		ReceiptType type = ReceiptType.BRANCH_ARRIVAL;
		System.out.println(type.equals(null));
		System.out.println(type.equals(ReceiptType.BRANCH_ARRIVAL));
		System.out.println(type.equals(ReceiptType.CONFIRM));
	}
}
