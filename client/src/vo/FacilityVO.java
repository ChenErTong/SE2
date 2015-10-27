package vo;

import java.util.ArrayList;

import po.receiptpo.LoadingListPO;

public class FacilityVO {
	/**
	 * 管理员编号
	 */
	private String managerId;
	
	/**
	 * 运输历史
	 */
	private ArrayList<LoadingListPO> deliverHistory;
	
	/**
	 * 车辆编号
	 */
	private String facilityIdString;
	
	/**
	 * 购入日期
	 */
	private String dateString;

	public FacilityVO(String managerId, ArrayList<LoadingListPO> deliverHistory, String facilityIdString,
			String dateString) {
		this.managerId = managerId;
		this.deliverHistory = deliverHistory;
		this.facilityIdString = facilityIdString;
		this.dateString = dateString;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public ArrayList<LoadingListPO> getDeliverHistory() {
		return deliverHistory;
	}

	public void setDeliverHistory(ArrayList<LoadingListPO> deliverHistory) {
		this.deliverHistory = deliverHistory;
	}

	public String getFacilityIdString() {
		return facilityIdString;
	}

	public void setFacilityIdString(String facilityIdString) {
		this.facilityIdString = facilityIdString;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	
}
