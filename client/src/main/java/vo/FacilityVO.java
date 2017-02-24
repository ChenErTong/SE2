package vo;

import java.util.ArrayList;

import po.receiptpo.orderreceiptpo.LoadingListPO;

public class FacilityVO {
	/**
	 * 管理员编号
	 */
	public String managerId;

	/**
	 * 运输历史
	 */
	public ArrayList<LoadingListPO> deliverHistory;

	/**
	 * 车辆编号
	 */
	public String facilityIdString;

	/**
	 * 购入日期
	 */
	public String dateString;
	/**
	 * 底盘号
	 */
	public String bottomCode;
	/**
	 * 发动机号
	 */
	public String engineCode;
	/**
	 * 车牌号
	 */
	public String vehicleIdentificationNumber;
	public String branchID;
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
	public FacilityVO(String managerId,ArrayList<LoadingListPO> deliverHistory, String facilityIdString, String dateString, String bottomCode, String engineCode, String vehicleIdentificationNumber,String branchID) {
		this.managerId = managerId;
		this.deliverHistory = deliverHistory;
		this.facilityIdString = facilityIdString;
		this.dateString = dateString;
		this.bottomCode = bottomCode;
		this.engineCode = engineCode;
		this.vehicleIdentificationNumber = vehicleIdentificationNumber;
		this.branchID=branchID;
	}



	@Override
	public String toString() {
		return managerId + "|" + deliverHistory + "|" + facilityIdString + "|" + dateString + "|" + bottomCode
				+ "|" + engineCode + "|" + vehicleIdentificationNumber;
	}
	
	
	

}
