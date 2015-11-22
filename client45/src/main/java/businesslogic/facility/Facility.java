package businesslogic.facility;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.facilitydataservice.FacilityDataService;
import po.FacilityPO;
import state.ConfirmState;
import state.ResultMessage;
import vo.FacilityVO;

public class Facility {
	private FacilityDataService facilityData;

	public Facility() {
		try {
			facilityData = (FacilityDataService) Naming
					.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/" + FacilityDataService.NAME);
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
		FacilityPO facilityPO = FacilityTrans.convertVOtoPO(facility);
		return facilityData.add(facilityPO);
	}

	public FacilityVO findFacility(String ID) throws RemoteException {
		FacilityPO facilityPO = facilityData.find(ID);
		FacilityVO facilityVO = FacilityTrans.convertPOtoVO(facilityPO);
		return facilityVO;
	}
	
	public ArrayList<FacilityVO> findFacility() throws RemoteException {
		ArrayList<FacilityPO> facilityPOs = facilityData.find();
		ArrayList<FacilityVO> facilityVOs = FacilityTrans.convertFacilityPOstoVOs(facilityPOs);
		return facilityVOs;
	}

	public ResultMessage modifyFacility(FacilityVO facility) throws RemoteException {
		FacilityPO facilityPO = FacilityTrans.convertVOtoPO(facility);
		return facilityData.modify(facilityPO);
	}

	public ResultMessage deleteFacility(FacilityVO facility) throws RemoteException {
		return facilityData.delete(facility.getFacilityIdString());
	}

}
