package facility;

import java.rmi.Naming;

import businesslogic.facility.Facility;
import dataservice.facilitydataservice.FacilityDataService;
import po.FacilityPO;
import po.PersistentObject;
import state.ResultMessage;
import vo.FacilityVO;

public class MockFacility extends Facility {
	
	private FacilityDataService<PersistentObject> facilityData;
	
	public MockFacility() {
		facilityData = Naming.lookup(null);
	}
	@Override
	public ResultMessage addFacility(FacilityVO facility) {
		FacilityPO facilityPO = new FacilityPO(facility.getFacilityIdString(), facility.getDateString(), facility.getManagerId(), facility.getDeliverHistory());
		
		return super.addFacility(facility);
	}

	@Override
	public FacilityVO findFacility(String facilityId) {
		// TODO Auto-generated method stub
		return super.findFacility(facilityId);
	}
}
