package branch;

import java.util.ArrayList;

import org.junit.Test;

import state.CommodityState;

public class TestBranch {

	@Test
	public void testBranch() {
		MockBranch mockBranch = new MockBranch();
		mockBranch.mockBranchArrivalList("ZZ001", "Nanjing Xianlin", CommodityState.Success	, new ArrayList<>());
		mockBranch.mockDeliveryList(new ArrayList<>(), "Lao Wang");
		mockBranch.mockTruckDeliver("Branch001", "Nanjing Gulou", "B001:2015-09-21", "Lao Wang", new ArrayList<>());
	}

}
