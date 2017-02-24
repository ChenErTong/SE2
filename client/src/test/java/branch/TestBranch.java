package branch;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import state.CommodityState;

public class TestBranch {

	@Test
	public void testBranch() {
		MockBranch mockBranch = null;
		try {
			mockBranch = new MockBranch();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		mockBranch.mockBranchArrivalList("ZZ001", "Nanjing Xianlin", CommodityState.Complete	, new ArrayList<>());
		mockBranch.mockDeliveryList(new ArrayList<>(), "Lao Wang");
		mockBranch.mockTruckDeliver("Branch001", "Nanjing Gulou", "B001:2015-09-21", "Lao Wang", new ArrayList<>());
	}

}
