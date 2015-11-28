package businesslogic.orderbl;

import java.util.ArrayList;

import po.CommodityPO;
import po.OrderPO;
import state.CommodityState;
import state.ReceiptType;
import vo.CommodityVO;
import vo.OrderVO;

public class OrderTrans {
	/**
	 * 
	 * @param commodityVOs
	 * @param vo
	 * @return
	 */
	public static OrderPO convertVOtoPO(OrderVO vo) {
		ArrayList<CommodityPO> pos = convertCommodityVOstoPOs(vo.commodities);
		return new OrderPO(vo.ID, ReceiptType.ORDER, vo.senderName, vo.senderAddress, vo.senderTel,
				vo.senderCo, vo.recipientName, vo.recipientAddress, vo.recipientTel, vo.recipientCo,
				pos, vo.midAddres, vo.sendTime, vo.recipientTime, vo.money);
	}
	public static OrderVO convertPOtoVO(OrderPO po) {
		ArrayList<CommodityVO> vos = convertCommodityPOstoVOs(po.getCommodityPO());
		return new OrderVO(po.getOrderIdString(), po.getSenderName(), po.getSenderAddress(),
				po.getSenderTel(), po.getSenderCo(), po.getRecipientName(), po.getRecipientAddress(),
				po.getRecipientTel(), po.getRecipientCo(), po.getMidAddres(), po.getSendTime(), po.getRecipientTime(),
				po.getMoney(),vos);
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
	
	public static CommodityPO convertVOtoPO(CommodityVO po){
		if(po==null)
			return null;
		else {
			String commodityType = po.commodityType;
			double weight = po.weight;
			double volumn = po.volumn;
			CommodityState commodityState = po.commodityState;			
			return new CommodityPO(commodityType, weight, volumn, commodityState);
		}
	}
	
	public static ArrayList<CommodityVO> convertCommodityPOstoVOs(ArrayList<CommodityPO> pos){
		ArrayList<CommodityVO> vos = new ArrayList<CommodityVO>();
		for (CommodityPO po : pos) {
			vos.add(convertPOtoVO(po));
		}
		return vos;
	}
	
	public static ArrayList<CommodityPO> convertCommodityVOstoPOs(ArrayList<CommodityVO> vos){
		ArrayList<CommodityPO> pos = new ArrayList<CommodityPO>();
		for (CommodityVO vo : vos) {
			pos.add(convertVOtoPO(vo));
		}
		return pos;
	}
}
