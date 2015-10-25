package dataservice.facilitydataservice;

import java.util.ArrayList;

import po.FacilityPO;
import po.accountpo.AccountPO;
import po.accountpo.DriverPO;
import state.ResultMessage;

public class _Facility_Data_Stub implements FacilityDataService<FacilityPO> {

	@Override
	public FacilityPO findFacility(String id) {
		return new FacilityPO("Y001:2015-09-22:00008" , "2015-09-22","123233", new ArrayList<>());
	}

	@Override
	public ResultMessage addFacility(FacilityPO facility) {
		System.out.println("You have added a car!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteFacility(FacilityPO facility) {
		System.out.println("You have deleted a car!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyFacility(FacilityPO facility) {
		System.out.println("You have modified a car!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public AccountPO findDriver(String id) {
		return new DriverPO("DY001:2014-6-4:00008", "Old driver", 
				"YunNan", "1990-10-24", "842160199010246291", 
				"16868688686", 1500.0, "2years", 100);
	}

	@Override
	public ResultMessage addDriver(AccountPO driver) {
		System.out.println("You have added a driver!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteDriver(AccountPO driver) {
		System.out.println("You have deleted a driver!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyDriver(AccountPO driver) {
		System.out.println("You have modified a driver!");
		return ResultMessage.SUCCESS;
	}

}
