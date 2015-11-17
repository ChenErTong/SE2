package facility;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.facility.Facility;
import dataservice.facilitydataservice.FacilityDataService;
import po.FacilityPO;
import state.ResultMessage;
import vo.FacilityVO;

public class MockFacility extends Facility {
	
	private FacilityDataService facilityData;
	
	public MockFacility() {
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
	public ResultMessage addFacility(FacilityVO facility) {
		FacilityPO facilityPO = new FacilityPO(facility.getFacilityIdString(), facility.getDateString(), facility.getManagerId(), facility.getDeliverHistory());
		try {
			facilityData.addFacility(facilityPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public FacilityVO findFacility(String facilityId) {
		FacilityVO vo=null;
		FacilityPO facilityPO = null;
		try {
			facilityPO = facilityData.findFacility(facilityId);
			if(facilityPO!=null)
				vo = new FacilityVO(facilityPO.getManagerId(), facilityPO.getDeliverHistory(), facilityId, facilityPO.getDate());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vo;
	}
	@Override
	public ResultMessage modifyFacility(FacilityVO facility) {
		FacilityPO facilityPO = new FacilityPO(facility.getFacilityIdString(), facility.getDateString(), facility.getManagerId(), facility.getDeliverHistory());
		try {
			facilityData.modifyFacility(facilityPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}
	@Override
	public ResultMessage deleteFacility(FacilityVO facility) {
		FacilityPO facilityPO = new FacilityPO(facility.getFacilityIdString(), facility.getDateString(), facility.getManagerId(), facility.getDeliverHistory());
		try {
			facilityData.deleteFacility(facilityPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}
}
