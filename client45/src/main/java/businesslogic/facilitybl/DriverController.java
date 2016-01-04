package businesslogic.facilitybl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.logbl.LogController;
import businesslogicservice.facilityblservice.DriverBLService;
import command.Command;
import command.CommandAdd;
import command.CommandController;
import command.CommandDelete;
import command.CommandModify;
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
	private CommandController<DriverPO> commandController;

	public DriverController() throws MalformedURLException, RemoteException, NotBoundException {
		driverBL = new Driver();
		commandController = new CommandController<DriverPO>("driver");
	}

	@Override
	public ConfirmState confirmOperation() {
		return driverBL.confirmOperation();
	}

	/**
	 * @see DriverBLService#addDriver(DriverVO)
	 */
	public ResultMessage addDriver(DriverVO driver) throws RemoteException {
		LogController.getInstance().addLog("添加司机");
		DriverPO po = FacilityTrans.convertVOtoPO(driver);
		Command<DriverPO> addCommand=new CommandAdd<DriverPO>(Driver.BLNAME, po);
		commandController.addCommand(addCommand);
		return addCommand.execute();
	}

	/**
	 * @see DriverBLService#deleteDriver(DriverVO)
	 */
	public ResultMessage deleteDriver(DriverVO driver) throws RemoteException {
		LogController.getInstance().addLog("删除司机");
		DriverPO po = FacilityTrans.convertVOtoPO(driver);
		Command<DriverPO> deleteCommand = new CommandDelete<DriverPO>(Driver.BLNAME, po);
		commandController.addCommand(deleteCommand);
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
		LogController.getInstance().addLog("修改司机信息");
		DriverPO po = FacilityTrans.convertVOtoPO(driver);
		DriverPO res =  driverBL.modify(po);
		if(res==null){
			return ResultMessage.FAIL;
		}else{
			Command<DriverPO> modifyCommand = new CommandModify<DriverPO>(Driver.BLNAME, res);
			commandController.addCommand(modifyCommand);
			return ResultMessage.SUCCESS;
		}
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
	@Override
	public boolean canUndo() {
		return commandController.canUndo();
	}

	@Override
	public boolean canRedo() {
		return commandController.canRedo();
	}

	@Override
	public ResultMessage undo() throws RemoteException {
		return commandController.undoCommand();
	}

	@Override
	public ResultMessage redo() throws RemoteException {
		return commandController.redoCommand();
	}
}
