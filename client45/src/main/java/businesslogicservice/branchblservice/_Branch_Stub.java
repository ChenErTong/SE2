package businesslogicservice.branchblservice;

import java.util.ArrayList;

import po.OrderPO;
import po.receiptpo.ReceiptPO;
import state.CommodityState;
import state.ConfirmState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.receiptvo.BranchArrivalListVO;
import vo.receiptvo.DeliveryListVO;
import vo.receiptvo.LoadingListVO;

public class _Branch_Stub implements BranchBLService {

	@Override
	public ConfirmState confirmOperation() {
		System.out.println("You have confirmed!");
		return ConfirmState.CONFIRM;
	}

	@Override
	public ArrayList<CommodityVO> getAllCommodities() {
		ArrayList<OrderPO> orderPOs = new ArrayList<>();
		System.out.println("You get all orderPOs");
		ArrayList<CommodityVO> allCommodityVOs = new ArrayList<>();
		System.out.println("Get commodities from orderPOs");
		for(int i=0;i<orderPOs.size();i++){
			OrderPO orderPO = orderPOs.get(i);
			ArrayList<CommodityVO> oneCommodityVOs = orderPO.getCommodityVO();
			for (CommodityVO commodityVO : oneCommodityVOs) {
				allCommodityVOs.add(commodityVO);
			}
		}
		System.out.println("You have got all commodities!");
		return allCommodityVOs;
	}

	@Override
	public ArrayList<String> getAllOrderNumber() {
		ArrayList<OrderPO> orderPOs = new ArrayList<>();
		System.out.println("You get all orderPOs");
		ArrayList<String> allOrderNumber = new ArrayList<>();
		System.out.println("Get order number from orderPOs");
		for(int i=0;i<orderPOs.size();i++){
			allOrderNumber.add(orderPOs.get(i).getOrderIdString());
		}
		System.out.println("You have got all order numbers!");
		return allOrderNumber;
	}

	@Override
	public BranchArrivalListVO getBranchArrivalList(String transferListID, String departure, CommodityState state,
			ArrayList<String> orders) {
		BranchArrivalListVO branchArrivalListVO = new BranchArrivalListVO(transferListID, transferListID, departure, state, orders);
		System.out.println("You have got a serial of commodities");
		ReceiptPO receiptPO = new ReceiptPO(transferListID);
		System.out.println("You have fielded a receipt");
		ResultMessage resultMessage = this.submit(receiptPO);
		if(resultMessage==ResultMessage.SUCCESS){
			System.out.println("The receipt has passed!");
			this.save(receiptPO);
		}else{
			System.out.println("The receipt has not passed!");
		}
		return branchArrivalListVO;
	}

	@Override
	public DeliveryListVO getDeliveryList(ArrayList<String> orders, String courierName) {
		DeliveryListVO deliveryListVO = new DeliveryListVO(null, orders, courierName);
		System.out.println("You have fielded a delivery receipt!");
		return deliveryListVO;
	}

	@Override
	public ResultMessage submit(ReceiptPO receipt) {
		System.out.println("You have submit a receipt");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage save(ReceiptPO receipt) {
		System.out.println("You have saved a receipt");
		return ResultMessage.SUCCESS;
	}

	@Override
	public LoadingListVO truckDeliver(String branchID, String destination, String facilityID, String courierName,
			ArrayList<String> orders) {
		@SuppressWarnings("unused")
		double fare=6.767;
		System.out.println("You have calcuated the fare of delivery!");
		LoadingListVO loadingListVO = new LoadingListVO(branchID, branchID, destination, facilityID, courierName, orders);
		System.out.println("You have fielded the loadingListReceipt!");
		//TODO
		System.out.println("You have updated the infos of branch's facilities!");
		return loadingListVO;
	}

}
