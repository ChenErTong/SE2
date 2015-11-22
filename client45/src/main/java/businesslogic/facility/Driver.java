package businesslogic.facility;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogicservice.facilityblservice.DriverBLService;
import dataservice.facilitydataservice.DriverDataService;
import state.ConfirmState;
import state.ResultMessage;
import vo.accountvo.DriverVO;

public class Driver implements DriverBLService{
	private DriverDataService DriverData;
	
	public Driver() {
		try {
			DriverData = (DriverDataService)Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/"+DriverDataService.NAME);
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
		return null;
	}

	@Override
	public ResultMessage addDriver(DriverVO driver) {
		return null;
	}

	@Override
	public ResultMessage deleteDriver(DriverVO driver) {
		return null;
	}

	@Override
	public ResultMessage modifyDriver(DriverVO driver) {
		return null;
	}

	@Override
	public DriverVO findDriver(String driverId) {
		return null;
	}

}
