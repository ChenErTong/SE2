package businesslogic.facilitybl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.facilityblservice.FacilityBLService;
import command.Command;
import command.CommandController;
import command.CommandDelete;
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
	private CommandController<FacilityPO> commandManager;

	public FacilityController() throws MalformedURLException, RemoteException, NotBoundException {
		facilityBL = new Facility();
		commandManager = new CommandController<FacilityPO>("car");
	}

	@Override
	public ConfirmState confirmOperation() {
		return facilityBL.confirmOperation();
	}

	/**
	 * @see FacilityBLService#addFacility(FacilityVO)
	 */
	public ResultMessage addFacility(FacilityVO facility) throws RemoteException {
		FacilityPO facilityPO = FacilityTrans.convertVOtoPO(facility);
		return facilityBL.add(facilityPO);
	}

	/**
	 * @see FacilityBLService#deleteFacility(FacilityVO)
	 */
	public ResultMessage deleteFacility(FacilityVO facility) throws RemoteException {
		FacilityPO facilityPO = FacilityTrans.convertVOtoPO(facility);
		Command<FacilityPO> commandDelete = new CommandDelete<FacilityPO>(facilityBL, facilityPO);
		commandManager.addCommand(commandDelete);
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
		FacilityPO facilityPO = FacilityTrans.convertVOtoPO(facility);
		return facilityBL.modify(facilityPO);
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

}
