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
public class DriverController implements DriverBLService{
	
	Driver driverBL = new Driver();
	@Override
	public ConfirmState confirmOperation(){
		return driverBL.confirmOperation();
	}

	@Override
	public ResultMessage addDriver(DriverVO driver) throws RemoteException {
		try {
			return driverBL.addDriver(driver);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage deleteDriver(DriverVO driver) throws RemoteException {
		try {
			return driverBL.deleteDriver(driver);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage modifyDriver(DriverVO driver) throws RemoteException {
		try {
			return driverBL.modifyDriver(driver);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	

	@Override
	public ArrayList<DriverVO> findDriver() throws RemoteException {
		ArrayList<DriverVO> vos=null;
		try {
			vos = driverBL.findDriver();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vos;
	}
	
	@Override
	public DriverVO findDriver(String ID) throws RemoteException {
		try {
			return driverBL.findDriver(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getID(String branchID) throws RemoteException {
		try {
			return driverBL.getID(branchID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
