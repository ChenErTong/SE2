package facility;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.facilitybl.Facility;
import dataservice.facilitydataservice.FacilityDataService;
import po.FacilityPO;
import state.ResultMessage;

public class MockFacility extends Facility {

	private FacilityDataService facilityData;

	public MockFacility() throws MalformedURLException, RemoteException, NotBoundException {
		facilityData = (FacilityDataService) Naming
				.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/" + FacilityDataService.NAME);
	}

	@Override
	public ResultMessage add(FacilityPO facility) {
		try {
			facilityData.add(facility);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	/*
	 * @Override public FacilityVO findFacility(String facilityId) { FacilityVO
	 * vo=null; FacilityPO facilityPO = null; try { facilityPO =
	 * facilityData.find(facilityId); if(facilityPO!=null) vo = new
	 * FacilityVO(facilityPO.getManagerId(), facilityPO.getDeliverHistory(),
	 * facilityId, facilityPO.getDate()); } catch (RemoteException e) {
	 * e.printStackTrace(); } return vo; }
	 */
	@Override
	public FacilityPO modify(FacilityPO facility) {
		try {
			return facilityData.modify(facility);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public FacilityPO delete(String ID) {
		try {
			facilityData.delete(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
}
