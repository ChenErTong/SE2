package po;

import java.util.ArrayList;

import po.receiptpo.TruckDeliveryList;

public class FacilityPO extends PersistentObject{
	/**
	 * 管理员编号
	 */
	private String managerId;
	
	/**
	 * 运输历史
	 */
	private ArrayList<TruckDeliveryList> deliverHistory;

	public FacilityPO(String id, String date, String managerId, ArrayList<TruckDeliveryList> deliverHistory) {
		super(id, date);
		this.managerId = managerId;
		this.deliverHistory = deliverHistory;
	}

	public String getManagerId() {
		return managerId;
	}

	public ArrayList<TruckDeliveryList> getDeliverHistory() {
		return deliverHistory;
	}
}
