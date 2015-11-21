package businesslogic.orderbl;

import java.util.ArrayList;

import po.OrderPO;
import vo.CommodityVO;
import vo.OrderVO;

public class OrderTrans {
	public static OrderPO convertVOtoPO(ArrayList<CommodityVO> commodityVOs, OrderVO vo) {
		return new OrderPO(vo.getOrderIdString(), vo.getSenderName(), vo.getSenderAddress(),
				vo.getSenderTel(), vo.getSenderCo(), vo.getRecipientName(), vo.getRecipientAddress(),
				vo.getRecipientTel(), vo.getRecipientCo(), commodityVOs, vo.getMidAddres(), vo.getSendTime(),
				vo.getRecipientTime(), vo.getMoney());
	}
	public static OrderVO convertPOtoVO(OrderPO po) {
		return new OrderVO(po.getOrderIdString(), po.getSenderName(), po.getSenderAddress(),
				po.getSenderTel(), po.getSenderCo(), po.getRecipientName(), po.getRecipientAddress(),
				po.getRecipientTel(), po.getRecipientCo(), po.getMidAddres(), po.getSendTime(), po.getRecipientTime(),
				po.getMoney());
	}
}
