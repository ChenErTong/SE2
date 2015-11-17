package businesslogicservice.facilityblservice;

import java.rmi.RemoteException;

import dataservice.facilitydataservice.FacilityDataService;
import dataservice.facilitydataservice._Facility_Data_Stub;
import po.FacilityPO;
import po.accountpo.DriverPO;
import state.ConfirmState;
import state.ResultMessage;
import vo.FacilityVO;
import vo.accountvo.DriverVO;

public class _Facility_Stub implements FacilityBLService {
	FacilityDataService data_Stub = new _Facility_Data_Stub();
	@Override
	public ConfirmState confirmOperation() {
		System.out.println("You have confirmed!");
		return ConfirmState.CONFIRM;
	}

	@Override
	public ResultMessage addFacility(FacilityVO facility) {
		FacilityPO facilityPO = new FacilityPO(facility.getFacilityIdString(),facility.getDateString(),facility.getManagerId(),facility.getDeliverHistory());
		try {
			data_Stub.addFacility(facilityPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteFacility(FacilityVO facility) {
		try {
			data_Stub.deleteFacility(facility.getFacilityIdString());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyFacility(FacilityVO facility) {
		FacilityPO facilityPO = new FacilityPO(facility.getFacilityIdString(),facility.getDateString(),facility.getManagerId(),facility.getDeliverHistory());
		try {
			data_Stub.modifyFacility(facilityPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public FacilityVO findFacility(String facilityId) {
		FacilityPO facilityPO = null;
		try {
			facilityPO = data_Stub.findFacility(facilityId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		System.out.println("You have found a car!");
		return new FacilityVO(facilityPO.getManagerId(), facilityPO.getDeliverHistory(), facilityId, facilityPO.getDate());
	}

	@Override
	public ResultMessage addDriver(DriverVO driver) {
		DriverPO driverPO = new DriverPO(
				driver.getID(), driver.getDuty(), driver.getName(), driver.getBirthDay(),
				driver.getIDCard(), driver.getPhone(), driver.getSalary(), driver.getWorkTime(),
				driver.getReceiptNum());
		try {
			data_Stub.addDriver(driverPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteDriver(DriverVO driver) {
		try {
			data_Stub.deleteDriver(driver.getID());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyDriver(DriverVO driver) {
		DriverPO driverPO = new DriverPO(
				driver.getID(), driver.getDuty(), driver.getName(), driver.getBirthDay(),
				driver.getIDCard(), driver.getPhone(), driver.getSalary(), driver.getWorkTime(),
				driver.getReceiptNum());
		try {
			data_Stub.modifyDriver(driverPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public DriverVO findDriver(String driverId) {
		DriverPO driverPO = null;
		try {
			driverPO = (DriverPO) data_Stub.findDriver(driverId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		System.out.println("You have find a driver!");
		return new DriverVO(
				driverId,driverPO.getDuty(), 
				driverPO.getName(), driverPO.getBirthDay(),driverPO.getIDCard(), 
				driverPO.getPhone(), driverPO.getSalary(), driverPO.getWorkTime(), driverPO.getReceiptNum());
	}

}
