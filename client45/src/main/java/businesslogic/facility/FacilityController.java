package businesslogic.facility;

import businesslogicservice.facilityblservice.FacilityBLService;
import state.ConfirmState;
import state.ResultMessage;
import vo.FacilityVO;

/**
 * 
 * @author Ann
 *
 */
public class FacilityController implements FacilityBLService {
	
	Facility facilityBL;
	@Override
	public ConfirmState confirmOperation() {
		return facilityBL.confirmOperation();
	}

	@Override
	public ResultMessage addFacility(FacilityVO facility) {
		return facilityBL.addFacility(facility);
	}

	@Override
	public ResultMessage deleteFacility(FacilityVO facility) {
		return facilityBL.deleteFacility(facility);
	}

	@Override
	public ResultMessage modifyFacility(FacilityVO facility) {
		return facilityBL.modifyFacility(facility);
	}

	@Override
	public FacilityVO findFacility(String facilityId) {
		return facilityBL.findFacility(facilityId);
	}

}
