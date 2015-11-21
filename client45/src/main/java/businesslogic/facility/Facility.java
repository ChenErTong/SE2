package businesslogic.facility;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.facilitydataservice.FacilityDataService;
import state.ConfirmState;
import state.ResultMessage;
import vo.FacilityVO;

public class Facility{
	private FacilityDataService facilityData;
	
	public Facility() {
		try {
			facilityData = (FacilityDataService)Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/"+FacilityDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}

	public ResultMessage addFacility(FacilityVO facility) throws RemoteException {
			return facilityData.add(FacilityTrans.convertVOtoPO(facility));
	}

	public FacilityVO findFacility(String facilityId) throws RemoteException {
		return FacilityTrans.convertPOtoVO(facilityData.find(facilityId));
	}
	public ResultMessage modifyFacility(FacilityVO facility)  throws RemoteException{
			return facilityData.modify(FacilityTrans.convertVOtoPO(facility));
	}
	public ResultMessage deleteFacility(FacilityVO facility)  throws RemoteException{
			return facilityData.delete(facility.getFacilityIdString());
	}


}
