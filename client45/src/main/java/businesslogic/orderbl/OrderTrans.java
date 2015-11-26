package businesslogic.orderbl;

import java.util.ArrayList;

import po.CommodityPO;
import po.OrderPO;
import state.CommodityState;
import state.ReceiptType;
import vo.CommodityVO;
import vo.OrderVO;

public class OrderTrans {
	public static OrderPO convertVOtoPO(ArrayList<CommodityVO> commodityVOs, OrderVO vo) {
		return new OrderPO(vo.ID, ReceiptType.ORDER, vo.senderName, vo.senderAddress, vo.senderTel,
				vo.senderCo, vo.recipientName, vo.recipientAddress, vo.recipientTel, vo.recipientCo,
				commodityVOs, vo.midAddres, vo.sendTime, vo.recipientTime, vo.money);
	}
	public static OrderVO convertPOtoVO(OrderPO po) {
		return new OrderVO(po.getOrderIdString(), po.getSenderName(), po.getSenderAddress(),
				po.getSenderTel(), po.getSenderCo(), po.getRecipientName(), po.getRecipientAddress(),
				po.getRecipientTel(), po.getRecipientCo(), po.getMidAddres(), po.getSendTime(), po.getRecipientTime(),
				po.getMoney());
	}
	public static ArrayList<OrderVO> convertOrderPOstoVOs(ArrayList<OrderPO> pos){
		ArrayList<OrderVO> vos = new ArrayList<>(pos.size());
		for (OrderPO orderPO : pos) {
			vos.add(convertPOtoVO(orderPO));
		}
		return vos;
	}
	
	public static CommodityVO convertPOtoVO(CommodityPO po){
		if(po==null)
			return null;
		else {
			String commodityType = po.getCommodityType();
			double weight = po.getWeight();
			double volumn = po.getVolumn();
			CommodityState commodityState = po.getCommodityState();			
			return new CommodityVO(commodityType, weight, volumn, commodityState);
		}
	}
	
	public static ArrayList<CommodityVO> convertCommodityPOstoVOs(ArrayList<CommodityPO> pos){
		ArrayList<CommodityVO> vos = new ArrayList<CommodityVO>();
		for (CommodityPO po : pos) {
			vos.add(convertPOtoVO(po));
		}
		return vos;
	}
}
