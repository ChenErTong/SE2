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
	/**
	 * 底盘号
	 */
	private String bottomCode;
	/**
	 * 发动机号
	 */
	private String engineCode;
	/**
	 * 车牌号
	 */
	private String vehicleIdentificationNumber;
	public FacilityVO(String facilityIdString) {
		this.facilityIdString = facilityIdString;
	}

	/**
	 * @param managerId 管理员编号
	 * @param deliverHistory 运输历史
	 * @param facilityIdString 车辆代号
	 * @param dateString 购入时间
	 * @param bottomCode 底盘号
	 * @param engineCode 发动机号
	 * @param vehicleIdentificationNumber 车牌号
	 */
	public FacilityVO(String managerId,	ArrayList<LoadingListPO> deliverHistory, String facilityIdString, String dateString, String bottomCode, String engineCode, String vehicleIdentificationNumber) {
		this.managerId = managerId;
		this.deliverHistory = deliverHistory;
		this.facilityIdString = facilityIdString;
		this.dateString = dateString;
		this.bottomCode = bottomCode;
		this.engineCode = engineCode;
		this.vehicleIdentificationNumber = vehicleIdentificationNumber;
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

	public String getBottomCode() {
		return bottomCode;
	}

	public void setBottomCode(String bottomCode) {
		this.bottomCode = bottomCode;
	}

	public String getEngineCode() {
		return engineCode;
	}

	public void setEngineCode(String engineCode) {
		this.engineCode = engineCode;
	}

	public String getVehicleIdentificationNumber() {
		return vehicleIdentificationNumber;
	}

	public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
		this.vehicleIdentificationNumber = vehicleIdentificationNumber;
	}

	@Override
	public String toString() {
		return managerId + ", " + deliverHistory + ", " + facilityIdString + ", " + dateString + ", " + bottomCode
				+ ", " + engineCode + ", " + vehicleIdentificationNumber;
	}
	
	
	

}
