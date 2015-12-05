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
	public ResultMessage addFacility(FacilityVO facility) {
		try {
			return facilityBL.addFacility(facility);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage deleteFacility(FacilityVO facility) {
		try {
			return facilityBL.deleteFacility(facility);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage modifyFacility(FacilityVO facility) {
		try {
			return facilityBL.modifyFacility(facility);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}


	@Override
	public ArrayList<FacilityVO> findFacility() {
		try {
			return facilityBL.findFacility();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public FacilityVO findFacility(String ID) {
		try {
			return facilityBL.findFacility(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getID(String branchID) {
		try {
			return facilityBL.getID(branchID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
