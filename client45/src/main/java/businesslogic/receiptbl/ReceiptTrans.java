package businesslogic.receiptbl;

import java.util.ArrayList;

import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.ReceiptPO;
import po.receiptpo.orderreceiptpo.BranchArrivalListPO;
import po.receiptpo.orderreceiptpo.DeliveryListPO;
import po.receiptpo.orderreceiptpo.LoadingListPO;
import po.receiptpo.orderreceiptpo.TransferArrivalListPO;
import po.receiptpo.orderreceiptpo.TransferOrderPO;
import state.CommodityState;
import state.ReceiptType;
import vo.receiptvo.AdjustReceiptVO;
import vo.receiptvo.ReceiptVO;
import vo.receiptvo.orderreceiptvo.BranchArrivalListVO;
import vo.receiptvo.orderreceiptvo.DeliveryListVO;
import vo.receiptvo.orderreceiptvo.LoadingListVO;
import vo.receiptvo.orderreceiptvo.TransferArrivalListVO;
import vo.receiptvo.orderreceiptvo.TransferOrderVO;

public class ReceiptTrans {
	public static ReceiptPO convertVOtoPO(ReceiptVO vo){
		if(vo==null)
			return null;
		else {/*
			ReceiptType type = vo.type;
			switch (type) {
			case value:
				
				break;

			default:
				break;*/
			return null;
//			}
		}
	}
	
	
	public static ReceiptVO convertPOtoVO(ReceiptPO po){
		if(po==null)
			return null;
		else {
			ReceiptType type = po.getReceiptType();
			switch (type) {
			case BRANCH_ARRIVAL:		return convertSpecialPOtoVO((BranchArrivalListPO) po);
			case BRANCH_DELIVER: 		return convertSpecialPOtoVO((DeliveryListPO)po);
			case BRANCH_TRUCK:			return convertSpecialPOtoVO((LoadingListPO)po);
			case TRANS_ARRIVAL:		return convertSpecialPOtoVO((TransferArrivalListPO)po);
			case TRANS_PLANE:
			case TRANS_TRAIN:
			case TRANS_TRUCK:			return convertSpecialPOtoVO((TransferOrderPO)po);
			case TAKINGSTOCK:			return convertSpecialPOtoVO((AdjustReceiptPO)po);
			
			
			default:  		return null;
			}
		}
	}
	
	public static ReceiptVO convertSpecialPOtoVO(BranchArrivalListPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		String transferListID = po.getTransferListID();
		String departure = po.getDeparture();
		CommodityState state = po.getState();
		ArrayList<String> orders = po.getOrders();
		return new BranchArrivalListVO(id, type, transferListID, departure, state, orders);
	}
	public static ReceiptVO convertSpecialPOtoVO(DeliveryListPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		ArrayList<String> orders = po.getOrders();
		String courierName = po.getCourierName();
		return new DeliveryListVO(id, type, orders, courierName);
	}
	public static ReceiptVO convertSpecialPOtoVO(LoadingListPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		String branchID = po.getBranchID();
		String transferNumber = po.getTransferNumber();
		String distination = po.getDistination();
		String carID = po.getCarID();
		String monitorName = po.getMonitorName();
		ArrayList<String> orders = po.getOrders();
		String courierName = po.getCourierName();
		return new LoadingListVO(id, type, branchID, transferNumber, distination, carID, monitorName, courierName, orders);
	}
	public static ReceiptVO convertSpecialPOtoVO(TransferArrivalListPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		ArrayList<String> orders = po.getOrders();
		String transferCenterID = po.getTransferCenterID();
		String destination = po.getDestination();
		String departure = po.getDeparture();
		CommodityState state = po.getState();
		return new TransferArrivalListVO(id, type, transferCenterID,
				destination, departure, state, orders);
	}
	public static ReceiptVO convertSpecialPOtoVO(TransferOrderPO po){
		String facilityID = po.getFacilityID();
		ReceiptType type = po.getReceiptType();
		String departure = po.getDeparture();
		String destination = po.getDestination();
		ArrayList<String> orders = po.getOrders();
		String courierName = po.getCourierName();
		return new TransferOrderVO(facilityID, type, departure, destination, courierName, orders);
	}
	public static ReceiptVO convertSpecialPOtoVO(AdjustReceiptPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		int exA = po.getExA();
		int exB = po.getExB();
		int exC = po.getExC();
		int exD = po.getExD();
		int aftA = po.getAftA();
		int aftB = po.getAftB();
		int aftC = po.getAftC();
		int aftD = po.getAftD();
		return new AdjustReceiptVO(id, type, exA, exB, exC, exD, aftA, aftB, aftC, aftD);
	}
	
	
	
	
	
	public static ArrayList<ReceiptVO> convertPOstoVOs(ArrayList<ReceiptPO> pos){
		ArrayList<ReceiptVO> vos=new ArrayList<ReceiptVO>();
		for(ReceiptPO po:pos){
			ReceiptVO vo=convertPOtoVO(po);
			 vos.add(vo);
		}
		return vos;
	}
	
	public static ArrayList<ReceiptPO> convertVOstoPOs(ArrayList<ReceiptVO> vos){
		ArrayList<ReceiptPO> pos=new ArrayList<ReceiptPO>();
		for(ReceiptVO vo:vos){
			ReceiptPO po=convertVOtoPO(vo);
			pos.add(po);
		}
		return pos;
	}
}
