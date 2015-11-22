package businesslogic.facility;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.facilityblservice.DriverBLService;
import state.ConfirmState;
import state.ResultMessage;
import vo.accountvo.DriverVO;

public class DriverController implements DriverBLService{
	
	Driver driverBL;
	@Override
	public ConfirmState confirmOperation() {
		return driverBL.confirmOperation();
	}

	@Override
	public ResultMessage addDriver(DriverVO driver) {
		try {
			return driverBL.addDriver(driver);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage deleteDriver(DriverVO driver) {
		try {
			return driverBL.deleteDriver(driver);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage modifyDriver(DriverVO driver) {
		try {
			return driverBL.modifyDriver(driver);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	

	@Override
	public ArrayList<DriverVO> findDriver() {
		ArrayList<DriverVO> vos=null;
		try {
			vos = driverBL.findDriver();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vos;
	}
	
	@Override
	public DriverVO findDriver(String ID) {
		try {
			return driverBL.findDriver(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	

}
