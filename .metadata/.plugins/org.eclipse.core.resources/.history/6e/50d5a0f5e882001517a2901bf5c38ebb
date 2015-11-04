package po;

import java.util.ArrayList;

import po.receiptpo.LoadingListPO;

public class FacilityPO extends PersistentObject{
	/**
	 * 管理员编号
	 */
	private String managerId;
	
	private String date;
	
	/**
	 * 运输历史
	 */
	private ArrayList<LoadingListPO> deliverHistory;

	public FacilityPO(String id, String date, String managerId, ArrayList<LoadingListPO> deliverHistory) {
		super(id, date);
		this.managerId = managerId;
		this.deliverHistory = deliverHistory;
	}

	public String getManagerId() {
		return managerId;
	}

	public ArrayList<LoadingListPO> getDeliverHistory() {
		return deliverHistory;
	}

	public String getDate() {
		return date;
	}


}
