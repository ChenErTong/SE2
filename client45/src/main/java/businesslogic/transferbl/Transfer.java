package businesslogic.transferbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.transferblservice.TransferBLService;
import dataservice.transferdataservice.TransferDataService;
import po.receiptpo.ReceiptPO;
import state.CommodityState;
import state.ConfirmState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.receiptvo.TransferArrivalListVO;
import vo.receiptvo.TransferOrderVO;

public class Transfer implements TransferBLService {
	private TransferDataService transferData;

	public Transfer() {
		try {
			transferData = (TransferDataService) Naming
					.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/" + TransferDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ConfirmState confirmOperation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CommodityVO> getAllCommodities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferOrderVO planeTransfer(String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferOrderVO truckTransfer(String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferOrderVO trainTransfer(String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage submit(ReceiptPO receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage save(ReceiptPO receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferArrivalListVO receiptList(String transferID, String departure, String destination,CommodityState state,
			ArrayList<String> orders) {
		// TODO Auto-generated method stub
		return null;
	}

}
