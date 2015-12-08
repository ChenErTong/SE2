package businesslogic.facilitybl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import businesslogicservice.facilityblservice.DriverBLService;
import state.ConfirmState;
import state.ResultMessage;
import vo.accountvo.DriverVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:33:29
 */
public class DriverController implements DriverBLService {

	Driver driverBL = new Driver();

	@Override
	public ConfirmState confirmOperation() {
		return driverBL.confirmOperation();
	}

	/**
	 * @see DriverBLService#addDriver(DriverVO)
	 */
	public ResultMessage addDriver(DriverVO driver) throws RemoteException {
		try {
			return driverBL.addDriver(driver);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	/**
	 * @see DriverBLService#deleteDriver(DriverVO)
	 */
	public ResultMessage deleteDriver(DriverVO driver) throws RemoteException {
		try {
			return driverBL.deleteDriver(driver);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	/**
	 * @see DriverBLService#modifyDriver(DriverVO)
	 */
	public ResultMessage modifyDriver(DriverVO driver) throws RemoteException {
		try {
			return driverBL.modifyDriver(driver);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	/**
	 * @see DriverBLService#findDriver()
	 */
	public ArrayList<DriverVO> findDriver() throws RemoteException {
		ArrayList<DriverVO> vos = null;
		try {
			vos = driverBL.findDriver();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vos;
	}

	/**
	 * @see DriverBLService#findDriver(String)
	 */
	public DriverVO findDriver(String ID) throws RemoteException {
		try {
			return driverBL.findDriver(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @see DriverBLService#getID(String)
	 */
	public String getID(String branchID) throws RemoteException {
		try {
			return driverBL.getID(branchID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
