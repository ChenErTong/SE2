package businesslogic.facility;

import java.rmi.RemoteException;

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
	public DriverVO findDriver(String driverId) {
		DriverVO vo=null;
		try {
			vo = driverBL.findDriver(driverId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vo;
	}

}
