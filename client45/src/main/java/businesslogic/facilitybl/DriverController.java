package businesslogic.facilitybl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.facilityblservice.DriverBLService;
import command.Command;
import command.CommandController;
import command.CommandDelete;
import po.accountpo.DriverPO;
import state.ConfirmState;
import state.ResultMessage;
import vo.accountvo.DriverVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:33:29
 */
public class DriverController implements DriverBLService {

	Driver driverBL;
	private CommandController<DriverPO> commandManager;

	public DriverController() throws MalformedURLException, RemoteException, NotBoundException {
		driverBL = new Driver();
		commandManager = new CommandController<DriverPO>("driver");
	}

	@Override
	public ConfirmState confirmOperation() {
		return driverBL.confirmOperation();
	}

	/**
	 * @see DriverBLService#addDriver(DriverVO)
	 */
	public ResultMessage addDriver(DriverVO driver) throws RemoteException {
		DriverPO po = FacilityTrans.convertVOtoPO(driver);
		return driverBL.add(po);
	}

	/**
	 * @see DriverBLService#deleteDriver(DriverVO)
	 */
	public ResultMessage deleteDriver(DriverVO driver) throws RemoteException {
		DriverPO po = FacilityTrans.convertVOtoPO(driver);
		Command<DriverPO> deleteCommand = new CommandDelete<DriverPO>(driverBL, po);
		commandManager.addCommand(deleteCommand);
		return deleteCommand.execute();
		// DriverPO po = driverBL.delete(driver.ID);
		// if(po==null){
		// return ResultMessage.FAIL;
		// }
		// else{
		// commandManager.addCommand(new CommandDelete<DriverPO>("delete", po));
		// return ResultMessage.SUCCESS;
		// }
	}

	/**
	 * @see DriverBLService#modifyDriver(DriverVO)
	 */
	public ResultMessage modifyDriver(DriverVO driver) throws RemoteException {
		DriverPO po = FacilityTrans.convertVOtoPO(driver);
		return driverBL.modify(po);
	}

	/**
	 * @see DriverBLService#findDriver()
	 */
	public ArrayList<DriverVO> findDriver() throws RemoteException {
		ArrayList<DriverVO> vos = driverBL.findDriver();
		return vos;
	}

	/**
	 * @see DriverBLService#findDriver(String)
	 */
	public DriverVO findDriver(String ID) throws RemoteException {
		return driverBL.findDriver(ID);
	}

	/**
	 * @see DriverBLService#getID(String)
	 */
	public String getID(String branchID) throws RemoteException {
		return driverBL.getID(branchID);
	}

}
