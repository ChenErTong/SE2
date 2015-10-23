package po;

import java.util.ArrayList;

import po.receiptpo.TruckDeliveryListPO;

public class FacilityPO extends PersistentObject{
	/**
	 * 管理员编号
	 */
	private String managerId;
	
	/**
	 * 运输历史
	 */
	private ArrayList<TruckDeliveryListPO> deliverHistory;

	public FacilityPO(String id, String date, String managerId, ArrayList<TruckDeliveryListPO> deliverHistory) {
		super(id, date);
		this.managerId = managerId;
		this.deliverHistory = deliverHistory;
	}

	public String getManagerId() {
		return managerId;
	}

	public ArrayList<TruckDeliveryListPO> getDeliverHistory() {
		return deliverHistory;
	}
}
