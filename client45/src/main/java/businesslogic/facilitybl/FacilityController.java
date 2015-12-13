package businesslogic.facilitybl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.logbl.LogController;
import businesslogicservice.facilityblservice.FacilityBLService;
import command.Command;
import command.CommandAdd;
import command.CommandController;
import command.CommandDelete;
import command.CommandModify;
import po.FacilityPO;
import state.ConfirmState;
import state.ResultMessage;
import vo.FacilityVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:33:38
 */
public class FacilityController implements FacilityBLService {

	Facility facilityBL;
	private CommandController<FacilityPO> commandController;

	public FacilityController() throws MalformedURLException, RemoteException, NotBoundException {
		facilityBL = new Facility();
		commandController = new CommandController<FacilityPO>("car");
	}

	@Override
	public ConfirmState confirmOperation() {
		return facilityBL.confirmOperation();
	}

	/**
	 * @see FacilityBLService#addFacility(FacilityVO)
	 */
	public ResultMessage addFacility(FacilityVO facility) throws RemoteException {
		LogController.getInstance().addLog("添加车辆");
		FacilityPO facilityPO = FacilityTrans.convertVOtoPO(facility);
		Command<FacilityPO> addCommand=new CommandAdd<FacilityPO>(Facility.BLNAME, facilityPO);
		commandController.addCommand(addCommand);
		return addCommand.execute();
	}

	/**
	 * @see FacilityBLService#deleteFacility(FacilityVO)
	 */
	public ResultMessage deleteFacility(FacilityVO facility) throws RemoteException {
		LogController.getInstance().addLog("删除车辆");
		FacilityPO facilityPO = FacilityTrans.convertVOtoPO(facility);
		Command<FacilityPO> commandDelete = new CommandDelete<FacilityPO>(Facility.BLNAME, facilityPO);
		commandController.addCommand(commandDelete);
		return commandDelete.execute();
		// FacilityPO facilityPO = facilityBL.delete(facility.facilityIdString);
		// if(facilityPO==null){
		// return ResultMessage.FAIL;
		// }else{
		// commandManager.addCommand(new CommandDelete<FacilityPO>("delete",
		// facilityPO));
		// return ResultMessage.SUCCESS;
		// }
	}

	/**
	 * @see FacilityBLService#modifyFacility(FacilityVO)
	 */
	public ResultMessage modifyFacility(FacilityVO facility) throws RemoteException {
		LogController.getInstance().addLog("修改车辆信息");
		FacilityPO facilityPO = FacilityTrans.convertVOtoPO(facility);
		FacilityPO res =  facilityBL.modify(facilityPO);
		if(res==null){
			return ResultMessage.FAIL;
		}else{
			Command<FacilityPO> modifyCommand = new CommandModify<FacilityPO>(Facility.BLNAME, res);
			commandController.addCommand(modifyCommand);
			return ResultMessage.SUCCESS;
		}
	}

	/**
	 * @see FacilityBLService#findFacility()
	 */
	public ArrayList<FacilityVO> findFacility() throws RemoteException {
		return facilityBL.findFacility();
	}

	/**
	 * @see FacilityBLService#findFacility(String)
	 */
	public FacilityVO findFacility(String ID) throws RemoteException {
		return facilityBL.findFacility(ID);
	}

	/**
	 * @see FacilityBLService#getID(String)
	 */
	public String getID(String branchID) throws RemoteException {
		return facilityBL.getID(branchID);
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
