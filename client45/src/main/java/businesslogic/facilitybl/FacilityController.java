package businesslogic.facilitybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.facilityblservice.FacilityBLService;
import state.ConfirmState;
import state.ResultMessage;
import vo.FacilityVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:33:38
 */
public class FacilityController implements FacilityBLService {

	Facility facilityBL = new Facility();

	@Override
	public ConfirmState confirmOperation() {
		return facilityBL.confirmOperation();
	}

	@Override
	public ResultMessage addFacility(FacilityVO facility) throws RemoteException {
		return facilityBL.addFacility(facility);
	}

	@Override
	public ResultMessage deleteFacility(FacilityVO facility) throws RemoteException {
		return facilityBL.deleteFacility(facility);
	}

	@Override
	public ResultMessage modifyFacility(FacilityVO facility) throws RemoteException {
		return facilityBL.modifyFacility(facility);
	}

	@Override
	public ArrayList<FacilityVO> findFacility() throws RemoteException {
		return facilityBL.findFacility();
	}

	@Override
	public FacilityVO findFacility(String ID) throws RemoteException {
		return facilityBL.findFacility(ID);
	}

	@Override
	public String getID(String branchID) throws RemoteException {
		return facilityBL.getID(branchID);
	}

}
