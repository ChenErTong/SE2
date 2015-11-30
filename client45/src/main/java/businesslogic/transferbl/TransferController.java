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

public class TransferController implements TransferBLService{
    Transfer TransferBL = new Transfer();
	@Override
	public ConfirmState confirmOperation() {
		return TransferBL.confirmOperation();
	}

	@Override
	public ArrayList<CommodityVO> getAllCommodities() {
		try {
			return TransferBL.getAllCommodities();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TransferOrderVO planeTransfer(String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders, String date, String id) {
		try {
			return TransferBL.planeTransfer(facilityID, departure, destination, courierName, orders, date, id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TransferOrderVO truckTransfer(String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders, String date, String id) {
		try {
			return TransferBL.truckTransfer(facilityID, departure, destination, courierName, orders, date, id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TransferOrderVO trainTransfer(String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders, String date, String id) {
		try {
			return TransferBL.trainTransfer(facilityID, departure, destination, courierName, orders, date, id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage submit(ReceiptVO receipt) {
		try {
			return TransferBL.submit(receipt);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage save(ReceiptVO receipt) {
		try {
			return TransferBL.save(receipt);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TransferArrivalListVO receiptList(String transferID,
			String departure, String destination, CommodityState state,
			ArrayList<String> orders) {
		// TODO Auto-generated method stub
		return null;
	}
}