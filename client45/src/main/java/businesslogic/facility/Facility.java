package businesslogic.facility;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogicservice.facilityblservice.FacilityBLService;
import dataservice.facilitydataservice.FacilityDataService;
import po.FacilityPO;
import state.ConfirmState;
import state.ResultMessage;
import vo.FacilityVO;

public class Facility implements FacilityBLService {
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
	@Override
	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}

	@Override
	public ResultMessage addFacility(FacilityVO facility) {
		try {
			return facilityData.add(FacilityTrans.convertVOtoPO(facility));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public FacilityVO findFacility(String facilityId) {
		FacilityVO vo=null;
		FacilityPO facilityPO = null;
		try {
			facilityPO = facilityData.find(facilityId);
			if(facilityPO!=null)
				vo = FacilityTrans.convertPOtoVO(facilityPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vo;
	}
	@Override
	public ResultMessage modifyFacility(FacilityVO facility) {
		try {
			return facilityData.modify(FacilityTrans.convertVOtoPO(facility));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}
	@Override
	public ResultMessage deleteFacility(FacilityVO facility) {
		try {
			return facilityData.delete(facility.getFacilityIdString());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}


}
