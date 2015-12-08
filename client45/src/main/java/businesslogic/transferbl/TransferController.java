package businesslogic.transferbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.transferblservice.TransferBLService;
import state.CommodityState;
import state.ConfirmState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.receiptvo.ReceiptVO;
import vo.receiptvo.orderreceiptvo.TransferArrivalListVO;
import vo.receiptvo.orderreceiptvo.TransferOrderVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:38:40
 */
public class TransferController implements TransferBLService{
    Transfer TransferBL = new Transfer();
	@Override
	public ConfirmState confirmOperation() {
		return TransferBL.confirmOperation();
	}

	@Override
	public ArrayList<CommodityVO> getAllCommodities() throws RemoteException {
			return TransferBL.getAllCommodities();
	}

	@Override
	public TransferOrderVO planeTransfer(String transfer,String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders, String date, String id) throws RemoteException {
			return TransferBL.planeTransfer(transfer,facilityID, departure, destination, courierName, orders, date, id);
	}

	@Override
	public TransferOrderVO truckTransfer(String transfer,String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders, String date, String id) throws RemoteException {
			return TransferBL.truckTransfer(transfer,facilityID, departure, destination, courierName, orders, date, id);
	}

	@Override
	public TransferOrderVO trainTransfer(String transfer,String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders, String date, String id) throws RemoteException {
			return TransferBL.trainTransfer(transfer,facilityID, departure, destination, courierName, orders, date, id);
	}

	@Override
	public ResultMessage submit(ReceiptVO receipt) throws RemoteException {
			return TransferBL.submit(receipt);
	}

	@Override
	public ResultMessage save(ReceiptVO receipt) throws RemoteException {
			return TransferBL.save(receipt);
	}

	@Override
	public TransferArrivalListVO receiptList(String transferID,
			String departure, String destination, CommodityState state,
			String orders) throws RemoteException {
			return TransferBL.receiptList(transferID, departure, destination, state, orders);
	}
}