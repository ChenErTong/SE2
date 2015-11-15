package businesslogicservice.facilityblservice;

import dataservice.facilitydataservice.FacilityDataService;
import dataservice.facilitydataservice._Facility_Data_Stub;
import po.FacilityPO;
import po.accountpo.DriverPO;
import state.ConfirmState;
import state.ResultMessage;
import vo.FacilityVO;
import vo.accountvo.DriverVO;

public class _Facility_Stub implements FacilityBLService {
	FacilityDataService<FacilityPO> data_Stub = new _Facility_Data_Stub();
	@Override
	public ConfirmState confirmOperation() {
		System.out.println("You have confirmed!");
		return ConfirmState.CONFIRM;
	}

	@Override
	public ResultMessage addFacility(FacilityVO facility) {
		FacilityPO facilityPO = new FacilityPO(facility.getFacilityIdString(),facility.getDateString(),facility.getManagerId(),facility.getDeliverHistory());
		data_Stub.addFacility(facilityPO);
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteFacility(FacilityVO facility) {
		FacilityPO facilityPO = new FacilityPO(facility.getFacilityIdString(),facility.getDateString(),facility.getManagerId(),facility.getDeliverHistory());
		data_Stub.deleteFacility(facilityPO);
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyFacility(FacilityVO facility) {
		FacilityPO facilityPO = new FacilityPO(facility.getFacilityIdString(),facility.getDateString(),facility.getManagerId(),facility.getDeliverHistory());
		data_Stub.modifyFacility(facilityPO);
		return ResultMessage.SUCCESS;
	}

	@Override
	public FacilityVO findFacility(String facilityId) {
		FacilityPO facilityPO = data_Stub.findFacility(facilityId);
		System.out.println("You have found a car!");
		return new FacilityVO(facilityPO.getManagerId(), facilityPO.getDeliverHistory(), facilityId, facilityPO.getDate());
	}

	@Override
	public ResultMessage addDriver(DriverVO driver) {
		DriverPO driverPO = new DriverPO(
				driver.getID(), driver.getDuty(), driver.getName(), driver.getBirthDay(),
				driver.getIDCard(), driver.getPhone(), driver.getSalary(), driver.getWorkTime(),
				driver.getReceiptNum());
		data_Stub.addDriver(driverPO);
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteDriver(DriverVO driver) {
		DriverPO driverPO = new DriverPO(
				driver.getID(), driver.getDuty(), driver.getName(), driver.getBirthDay(),
				driver.getIDCard(), driver.getPhone(), driver.getSalary(), driver.getWorkTime(),
				driver.getReceiptNum());
		data_Stub.deleteDriver(driverPO);
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyDriver(DriverVO driver) {
		DriverPO driverPO = new DriverPO(
				driver.getID(), driver.getDuty(), driver.getName(), driver.getBirthDay(),
				driver.getIDCard(), driver.getPhone(), driver.getSalary(), driver.getWorkTime(),
				driver.getReceiptNum());
		data_Stub.modifyDriver(driverPO);
		return ResultMessage.SUCCESS;
	}

	@Override
	public DriverVO findDriver(String driverId) {
		DriverPO driverPO = (DriverPO) data_Stub.findDriver(driverId);
		System.out.println("You have find a driver!");
		return new DriverVO(
				driverId,driverPO.getDuty(), 
				driverPO.getName(), driverPO.getBirthDay(),driverPO.getIDCard(), 
				driverPO.getPhone(), driverPO.getSalary(), driverPO.getWorkTime(), driverPO.getReceiptNum());
	}

}
