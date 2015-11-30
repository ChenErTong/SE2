package order;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.Test;
import state.CommodityState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;

public class TestOrder {
	@Test
	public void testOrder() {
		CommodityVO commmodity1 = new CommodityVO("iphone", 0.5, 0.002, CommodityState.Complete);
		CommodityVO commmodity2 = new CommodityVO("ipad", 1, 0.008, CommodityState.Complete);
		CommodityVO commmodity3 = new CommodityVO("ipad mini", 0.75, 0.004, CommodityState.Complete);
		ArrayList<CommodityVO> commodities = new ArrayList<CommodityVO>();
		commodities.add(commmodity1);
		commodities.add(commmodity2);
		commodities.add(commmodity3);
		
		OrderVO orderVO = null;
//				new OrderVO("5648213657", "Obama", "Washington D.C", "250050", "The White House", "Putin", "Moscow", "150050", "Kremlin", null, "2015-11-7", "2015-11-11", 20000,commodities);
		MockOrder order = new MockOrder();
		ResultMessage RMessSet = order.addOrder(commodities, orderVO);
		assertEquals(ResultMessage.SUCCESS,RMessSet);
		
		OrderVO ordergot = order.inquireOrder("3256874523", "Obama");
		assertEquals(null, ordergot);
	}
}