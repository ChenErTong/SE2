package businesslogic.facilitybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.openingstockbl.FacilityInfo_OpeningStock;
import dataservice.facilitydataservice.FacilityDataService;
import po.FacilityPO;

public class FacilityInfo implements FacilityInfo_OpeningStock{
	Facility facility;
	FacilityDataService facilityData;
	public FacilityInfo() {
		facility = new Facility();
		facilityData = facility.getData();
	}
	@Override
	public ArrayList<FacilityPO> find() throws RemoteException {
		return facilityData.find();
	}
}
