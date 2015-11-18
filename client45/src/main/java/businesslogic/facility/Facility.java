package businesslogic.facility;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogicservice.facilityblservice.FacilityBLService;
import dataservice.facilitydataservice.FacilityDataService;
import dataservice.funddataservice.ExpenseDataService;
import state.ConfirmState;
import state.ResultMessage;
import vo.FacilityVO;
import vo.accountvo.DriverVO;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addFacility(FacilityVO facility){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteFacility(FacilityVO facility) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyFacility(FacilityVO facility) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FacilityVO findFacility(String facilityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addDriver(DriverVO driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteDriver(DriverVO driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyDriver(DriverVO driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverVO findDriver(String driverId) {
		// TODO Auto-generated method stub
		return null;
	}

}
