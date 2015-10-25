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
		System.out.println("You get all orderPOs");
		ArrayList<OrderPO> orderPOs = new ArrayList<>();
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
		System.out.println("You get all orderPOs");
		ArrayList<OrderPO> orderPOs = new ArrayList<>();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeliveryListVO getDeliveryList(ArrayList<String> orders, String courierName) {
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
	public LoadingListVO truckDeliver(String branchID, String destination, String facilityID, String courierName,
			ArrayList<String> orders) {
		// TODO Auto-generated method stub
		return null;
	}

}
