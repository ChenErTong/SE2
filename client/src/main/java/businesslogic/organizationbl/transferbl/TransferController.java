package businesslogic.organizationbl.transferbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.logbl.LogController;
import businesslogicservice.transferblservice.TransferBLService;
import state.CommodityState;
import state.ConfirmState;
import vo.CommodityVO;
import vo.receiptvo.orderreceiptvo.TransferArrivalListVO;
import vo.receiptvo.orderreceiptvo.TransferOrderVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:38:40
 */
public class TransferController implements TransferBLService {
	Transfer TransferBL;

	public TransferController() throws MalformedURLException, RemoteException, NotBoundException {
		TransferBL = new Transfer();
	}

	@Override
	public ConfirmState confirmOperation() {
		return TransferBL.confirmOperation();
	}

	/**
	 * @see TransferBLService#getAllCommodities()
	 */
	public ArrayList<CommodityVO> getAllCommodities() throws RemoteException {
		return TransferBL.getAllCommodities();
	}

	/**
	 * @see TransferBLService#planeTransfer(String, String, String, String,
	 *      String, ArrayList, String, String)
	 */
	public TransferOrderVO planeTransfer(String transfer, String facilityID, String departure, String destination,
			String courierName, ArrayList<String> orders, String date, String id) throws RemoteException {
		LogController.getInstance().addLog("生成中转中心飞机转运单");
		return TransferBL.planeTransfer(transfer, facilityID, departure, destination, courierName, orders, date, id);
	}

	/**
	 * @see TransferBLService#truckTransfer(String, String, String, String,
	 *      String, ArrayList, String, String)
	 */
	public TransferOrderVO truckTransfer(String transfer, String facilityID, String departure, String destination,
			String courierName, ArrayList<String> orders, String date, String id) throws RemoteException {
		LogController.getInstance().addLog("生成中转中心汽车转运单");
		return TransferBL.truckTransfer(transfer, facilityID, departure, destination, courierName, orders, date, id);
	}

	/**
	 * @see TransferBLService#trainTransfer(String, String, String, String,
	 *      String, ArrayList, String, String)
	 */
	public TransferOrderVO trainTransfer(String transfer, String facilityID, String departure, String destination,
			String courierName, ArrayList<String> orders, String date, String id) throws RemoteException {
		LogController.getInstance().addLog("生成中转中心火车转运单");
		return TransferBL.trainTransfer(transfer, facilityID, departure, destination, courierName, orders, date, id);
	}

//	/**
//	 * @see TransferBLService#submit(ReceiptVO)
//	 */
//	public ResultMessage submit(ReceiptVO receipt) throws RemoteException {
//		return TransferBL.submit(receipt);
//	}
//
//	/**
//	 * @see TransferBLService#save(ReceiptVO)
//	 */
//	public ResultMessage save(ReceiptVO receipt) throws RemoteException {
//		return TransferBL.save(receipt);
//	}

	/**
	 * @see TransferBLService#receiptList(String, String, String,
	 *      CommodityState, String)
	 */
	public TransferArrivalListVO receiptList(String transferID, String departure, String destination,
			CommodityState state, String orders) throws RemoteException {
		LogController.getInstance().addLog("生成中转中心到达单");
		return TransferBL.receiptList(transferID, departure, destination, state, orders);
	}

	@Override
	public ArrayList<String> getAllTransferNumbers() throws RemoteException {
		return TransferBL.getAllTransferNumbers();
	}
}