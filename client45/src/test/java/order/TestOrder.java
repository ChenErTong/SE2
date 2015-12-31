package order;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import state.CommodityState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;

public class TestOrder {
	@Test
	public void testOrder() {
		CommodityVO commmodity1 = new CommodityVO("iphone", new BigDecimal(0.5), new BigDecimal(0.002), CommodityState.Complete,false,"1000000001");
		CommodityVO commmodity2 = new CommodityVO("ipad", new BigDecimal(1), new BigDecimal(0.008), CommodityState.Complete,false,"1000000001");
		CommodityVO commmodity3 = new CommodityVO("ipad mini", new BigDecimal(0.75), new BigDecimal(0.004), CommodityState.Complete,false,"1000000001");
		ArrayList<CommodityVO> commodities = new ArrayList<CommodityVO>();
		commodities.add(commmodity1);
		commodities.add(commmodity2);
		commodities.add(commmodity3);
		
		OrderVO orderVO = null;
//				new OrderVO("5648213657", "Obama", "Washington D.C", "250050", "The White House", "Putin", "Moscow", "150050", "Kremlin", null, "2015-11-7", "2015-11-11", 20000,commodities);
		MockOrder order = null;
		try {
			order = new MockOrder();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		ResultMessage RMessSet = order.addOrder(commodities, orderVO);
		assertEquals(ResultMessage.SUCCESS,RMessSet);
		
		OrderVO ordergot = order.inquireOrder("3256874523", "Obama");
		assertEquals(null, ordergot);
	}
}