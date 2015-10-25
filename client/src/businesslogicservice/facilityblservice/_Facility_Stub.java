package businesslogicservice.facilityblservice;

import java.util.ArrayList;

import po.FacilityPO;
import po.accountpo.DriverPO;
import state.ConfirmState;
import state.ResultMessage;
import vo.FacilityVO;
import vo.accountvo.DriverVO;

public class _Facility_Stub implements FacilityBLService {

	@Override
	public ConfirmState confirmOperation() {
		System.out.println("You have confirmed!");
		return ConfirmState.CONFIRM;
	}

	@Override
	public ResultMessage addFacility(FacilityVO facility) {
		@SuppressWarnings("unused")
		FacilityPO facilityPO = new FacilityPO(facility.getFacilityIdString(),facility.getDateString(),facility.getManagerId(),facility.getDeliverHistory());
		System.out.println("You have added a car!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteFacility(FacilityVO facility) {
		System.out.println("You have deleted a car!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyFacility(FacilityVO facility) {
		System.out.println("You have modified a car!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public FacilityVO findFacility(String facilityId) {
		System.out.println("You have found a car!");
		return new FacilityVO("123456", new ArrayList<>(), facilityId, "2015-10-23");
	}

	@Override
	public ResultMessage addDriver(DriverVO driver) {
		@SuppressWarnings("unused")
		DriverPO driverPO = new DriverPO(
				driver.getID(), driver.getDuty(), driver.getName(), driver.getBirthDay(),
				driver.getIDCard(), driver.getPhone(), driver.getSalary(), driver.getWorkTime(),
				driver.getReceiptNum());
		System.out.println("You have added a driver!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteDriver(DriverVO driver) {
		System.out.println("You have deleted a driver!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyDriver(DriverVO driver) {
		System.out.println("You have modifed a driver!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public DriverVO findDriver(String driverId) {
		System.out.println("You have find a driver!");
		return new DriverVO(
				driverId, "Old driver", 
				"YunNan", "1990-10-24", "731050199010247391", 
				"16868688686", 1500.0, "2years", 100);
	}

}
