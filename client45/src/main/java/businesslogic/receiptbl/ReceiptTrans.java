package businesslogic.receiptbl;

import java.math.BigDecimal;
import java.util.ArrayList;

import businesslogic.orderbl.OrderTrans;
import po.CommodityPO;
import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.DebitBillPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import po.receiptpo.PaymentBillPO;
import po.receiptpo.ReceiptPO;
import po.receiptpo.RecipientConfirmReceiptPO;
import po.receiptpo.orderreceiptpo.BranchArrivalListPO;
import po.receiptpo.orderreceiptpo.DeliveryListPO;
import po.receiptpo.orderreceiptpo.LoadingListPO;
import po.receiptpo.orderreceiptpo.TransferArrivalListPO;
import po.receiptpo.orderreceiptpo.TransferOrderPO;
import state.CommodityState;
import state.PayBillItem;
import state.ReceiptState;
import state.ReceiptType;
import vo.CommodityVO;
import vo.receiptvo.AdjustReceiptVO;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.PaymentBillVO;
import vo.receiptvo.ReceiptVO;
import vo.receiptvo.RecipientConfirmReceiptVO;
import vo.receiptvo.orderreceiptvo.BranchArrivalListVO;
import vo.receiptvo.orderreceiptvo.DeliveryListVO;
import vo.receiptvo.orderreceiptvo.LoadingListVO;
import vo.receiptvo.orderreceiptvo.TransferArrivalListVO;
import vo.receiptvo.orderreceiptvo.TransferOrderVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:38:07
 */
public class ReceiptTrans {
	public static ReceiptPO convertVOtoPO(ReceiptVO vo){
		if(vo==null)
			return null;
		else {
			ReceiptPO po=null;
			ReceiptType type =vo.type;
			ReceiptState state = vo.receiptState;
			if(state==null) 
				vo.receiptState=ReceiptState.APPROVALING;
			switch (type) {
			case BRANCH_ARRIVAL:		po=convertSpecialVOtoPO((BranchArrivalListVO)vo); break;
			case BRANCH_DELIVER: 		po=convertSpecialVOtoPO((DeliveryListVO)vo);break;
			case BRANCH_TRUCK:			po=convertSpecialVOtoPO((LoadingListVO)vo);break;
			case TRANS_ARRIVAL:		po=convertSpecialVOtoPO((TransferArrivalListVO)vo);break;
			case TRANS_PLANE:
			case TRANS_TRAIN:
			case TRANS_TRUCK:			po=convertSpecialVOtoPO((TransferOrderVO)vo);break;
			case DEBIT:							po=convertSpecialVOtoPO((DebitBillVO)vo);break;
			case PAY:								po=convertSpecialVOtoPO((PaymentBillVO)vo);break;
			case TAKINGSTOCK:			po=convertSpecialVOtoPO((AdjustReceiptVO)vo);break;
			case OUTSTOCK:					po=convertSpecialVOtoPO((InventoryExportReceiptVO)vo);break;
			case INSTOCK:					po=convertSpecialVOtoPO((InventoryImportReceiptVO)vo);break;
			case CONFIRM:					po=convertSpecialVOtoPO((RecipientConfirmReceiptVO)vo);break;
			default:  								return null;
			}
			po.setReceiptState(vo.receiptState);
			return po;
		}
	}
	
	
	public static ReceiptVO convertPOtoVO(ReceiptPO po){
		if(po==null)
			return null;
		else {
			ReceiptVO vo=null;
			ReceiptType type = po.getReceiptType();
			ReceiptState state = po.getReceiptState();
			if(state==null) 
				po.setReceiptState(ReceiptState.APPROVALING);
			switch (type) {
			case BRANCH_ARRIVAL:		vo= convertSpecialPOtoVO((BranchArrivalListPO) po);break;
			case BRANCH_DELIVER: 		vo= convertSpecialPOtoVO((DeliveryListPO)po);break;
			case BRANCH_TRUCK:			vo= convertSpecialPOtoVO((LoadingListPO)po);break;
			case TRANS_ARRIVAL:		vo= convertSpecialPOtoVO((TransferArrivalListPO)po);break;
			case TRANS_PLANE:
			case TRANS_TRAIN:
			case TRANS_TRUCK:			vo= convertSpecialPOtoVO((TransferOrderPO)po);break;
			case DEBIT:							vo= convertSpecialPOtoVO((DebitBillPO)po);break;
			case PAY:								vo= convertSpecialPOtoVO((PaymentBillPO)po);break;
			case TAKINGSTOCK:			vo= convertSpecialPOtoVO((AdjustReceiptPO)po);break;
			case OUTSTOCK:					vo= convertSpecialPOtoVO((InventoryExportReceiptPO)po);break;
			case INSTOCK:					vo= convertSpecialPOtoVO((InventoryImportReceiptPO)po);break;
			case CONFIRM:					vo= convertSpecialPOtoVO((RecipientConfirmReceiptPO)po);break;
			default:  								return null;
			}
			vo.receiptState=po.getReceiptState();
			return vo;
		}
	}
	public static ReceiptVO convertSpecialPOtoVO(RecipientConfirmReceiptPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		String orderID = po.getOrderID();
		String recipientName = po.getRecipientName();
		return new RecipientConfirmReceiptVO(id, type, orderID, recipientName);
	}
	public static ReceiptPO convertSpecialVOtoPO(RecipientConfirmReceiptVO vo){
		String ID = vo.ID;
		ReceiptType type = vo.type;
		String orderID = vo.orderID;
		String recipientName = vo.recipientName;
		return new RecipientConfirmReceiptPO(ID, type, orderID, recipientName);
	}
	public static ReceiptVO convertSpecialPOtoVO(BranchArrivalListPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		String transferListID = po.getTransferListID();
		String departure = po.getDeparture();
		CommodityState state = po.getState();
		String orders = po.getOrders();
		return new BranchArrivalListVO(id, type, transferListID, departure, state, orders);
	}
	
	public static ReceiptPO convertSpecialVOtoPO(BranchArrivalListVO vo){
		String ID = vo.ID;
		ReceiptType type = vo.type;
		String transferListID = vo.transferListID;
		String departure = vo.departure;
		CommodityState state = vo.state;
		String orders = vo.orderID ;
		return new BranchArrivalListPO(ID, type, transferListID, departure, state, orders);
	}
	public static ReceiptVO convertSpecialPOtoVO(DeliveryListPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		String orders = po.getOrders();
		String courierName = po.getCourierName();
		return new DeliveryListVO(id, type, orders, courierName);
	}
	public static ReceiptPO convertSpecialVOtoPO(DeliveryListVO vo){
		String id = vo.ID;
		ReceiptType type = vo.type;
		String orders = vo.order;
		String courierName = vo.courierName;
		return new DeliveryListPO(id, type, orders, courierName);
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
		BigDecimal money = po.getMoney();
		return new LoadingListVO(id, type, branchID, transferNumber, distination, carID, monitorName, orders, money);
	}
	public static ReceiptPO convertSpecialVOtoPO(LoadingListVO vo){
		String ID = vo.ID;
		ReceiptType type = vo.type;
		String branchID =vo.branchID;
		String transferNumber =vo.transferNumber;
		String distination = vo.distination;
		String carID = vo.carID;
		String monitorName = vo.monitorName;
		ArrayList<String> orders = vo.orders;
		BigDecimal money =vo.money;
		return new LoadingListPO(ID, type, branchID, transferNumber, distination, carID, monitorName, orders, money);
	}
	public static ReceiptVO convertSpecialPOtoVO(TransferArrivalListPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		String orders = po.getOrders();
		String transferCenterID = po.getTransferCenterID();
		String destination = po.getDestination();
		String departure = po.getDeparture();
		CommodityState state = po.getState();
		return new TransferArrivalListVO(id, type, transferCenterID,
				destination, departure, state, orders);
	}
	public static ReceiptPO convertSpecialVOtoPO(TransferArrivalListVO vo){
		String id = vo.ID;
		ReceiptType type = vo.type;
		String orders = vo.order;
		String transferCenterID = vo.transferCenterID;
		String destination = vo.destination;
		String departure = vo.departure;
		CommodityState state = vo.state;
		return new TransferArrivalListPO(id, type, transferCenterID, departure, destination, state, orders);
	}
	public static ReceiptVO convertSpecialPOtoVO(TransferOrderPO po){
		String ID = po.getID();
		String facilityID = po.getFacilityID();
		ReceiptType type = po.getReceiptType();
		String departure = po.getDeparture();
		String destination = po.getDestination();
		ArrayList<String> orders = po.getOrders();
		String courierName = po.getCourierName();
		return new TransferOrderVO(ID,facilityID, type, departure, destination, courierName, orders);
	}
	public static ReceiptPO convertSpecialVOtoPO(TransferOrderVO vo){
		String ID = vo.ID;
		String facilityID = vo.facilityID;
		ReceiptType type = vo.type;
		String departure =vo.departure;
		String destination = vo.destination;
		ArrayList<String> orders =vo.orders;
		String courierName =vo.courierName;
		return new TransferOrderPO(ID, type, facilityID, departure, destination, courierName, orders);
	}
	public static ReceiptVO convertSpecialPOtoVO(AdjustReceiptPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		int exArea = po.getExArea();
		int exRow = po.getExRow();
		int exFrame = po.getExFrame();
		int exPosition = po.getExPosition();
		int aftArea = po.getAftArea();
		int aftRow = po.getAftRow();
		int aftFrame = po.getAftFrame();
		int aftPosition = po.getAftPosition();
		return new AdjustReceiptVO(id, type, exArea, exRow, exFrame, exPosition, aftArea, aftRow, aftFrame, aftPosition);
	}
	public static ReceiptPO convertSpecialVOtoPO(AdjustReceiptVO vo){
		String ID = vo.ID;
		ReceiptType type = vo.type;
		int exArea =vo.exArea;
		int exRow =vo.exRow;
		int exFrame =vo.exFrame;
		int exPosition =vo.exPosition;
		int aftArea =vo.aftArea;
		int aftRow =vo.aftRow;
		int aftFrame =vo.aftFrame;
		int aftPosition =vo.aftPosition;
		return new AdjustReceiptPO(ID, type, exArea, exRow, exFrame, exPosition, aftArea, aftRow, aftFrame, aftPosition);
	}
	public static ReceiptVO convertSpecialPOtoVO(DebitBillPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		String courierID = po.getCourierID();
		BigDecimal money = po.getMoney();
		ArrayList<String> orderNumbers = po.getOrderNumbers();
		String date = po.getDate();
		String bankAccountID = po.getBankAccountID();
		return new DebitBillVO(id, type, courierID, money, orderNumbers, date,bankAccountID);
	}
	public static ReceiptPO convertSpecialVOtoPO(DebitBillVO vo){
		String id = vo.ID;
		ReceiptType type = vo.type;
		String courierID =vo.courierID;
		BigDecimal money = vo.money;
		ArrayList<String> orderNumbers = vo.orderNumbers;
		String date = vo.date;
		String bankAccountID = vo.bankAccountID;
		return new DebitBillPO(id, type, courierID, money, orderNumbers, date,bankAccountID);
	}
	public static ReceiptVO convertSpecialPOtoVO(PaymentBillPO po){
		String iD = po.getID();
		String date = po.getDate();
		ReceiptType type = po.getReceiptType();
		BigDecimal money = po.getMoney();
		String payerName = po.getPayerName();
		String accountID = po.getBankAccountID();
		PayBillItem items = po.getPayBillItem();
		String remarks = po.getRemarks();
		return new PaymentBillVO(iD, date, type, money, payerName, accountID, items, remarks);
	}
	public static ReceiptPO convertSpecialVOtoPO(PaymentBillVO vo){
		String ID = vo.ID;
		String date = vo.date;
		ReceiptType type = vo.type;
		BigDecimal money =vo.money;
		String payerName = vo.payerName;
		String accountID = vo.bankAccountID;
		PayBillItem items = vo.items;
		String remarks = vo.remarks;
		return new PaymentBillPO(ID, date ,type, money, payerName, items, accountID, remarks);
	}
	public static ReceiptVO convertSpecialPOtoVO(InventoryExportReceiptPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		String transferID = po.getTransferID();
		CommodityVO commodityVO = OrderTrans.convertPOtoVO(po.getCommodityPO());
		int area = po.getArea();
		int row =po.getRow();
		int frame = po.getFrame();
		int position = po.getPosition();
		return new InventoryExportReceiptVO(id, type, transferID, commodityVO, area, row, frame, position);
	}
	public static ReceiptPO convertSpecialVOtoPO(InventoryExportReceiptVO vo){
		String ID = vo.ID;
		ReceiptType type = vo.type;
		String transferID = vo.transferID;
		CommodityPO commodityPO = OrderTrans.convertVOtoPO(vo.commodityVO);
		int area=  vo.area;
		int row = vo.row;
		int frame = vo.frame;
		int position = vo.position;
		return new InventoryExportReceiptPO(ID, type, transferID, commodityPO, area, row, frame, position);
	}
	public static ReceiptVO convertSpecialPOtoVO(InventoryImportReceiptPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		CommodityPO commodity = po.getCommodityPO();
		System.out.println(commodity);
		CommodityVO commodityVO = OrderTrans.convertPOtoVO(commodity);
		System.out.println(commodityVO);
		int area = po.getArea();
		int row =po.getRow();
		int frame = po.getFrame();
		int position = po.getPosition();
		String transferID = po.getTransferID();
		return new InventoryImportReceiptVO(id, type, commodityVO, area, row, frame, position,transferID);
	}
	
	public static ReceiptPO convertSpecialVOtoPO(InventoryImportReceiptVO vo){
		String ID = vo.ID;
		ReceiptType type = vo.type;
		CommodityPO commodityPO = OrderTrans.convertVOtoPO(vo.commodityVO);
		int area = vo.area;
		int row =vo.row;
		int frame = vo.frame;
		int position = vo.position;
		String transferID = vo.transferID;
		return new InventoryImportReceiptPO(ID, type, commodityPO, area, row, frame, position,transferID);
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
