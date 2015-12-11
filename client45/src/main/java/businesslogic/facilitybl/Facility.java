package businesslogic.facilitybl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.organizationbl.branchbl.BranchInfo;
import command.Command;
import command.FacilityCommandController;
import config.RMIConfig;
import dataservice.facilitydataservice.FacilityDataService;
import po.FacilityPO;
import state.ConfirmState;
import state.ResultMessage;
import util.Util;
import vo.FacilityVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:33:33
 */
public class Facility {
	private FacilityDataService facilityData;
	private BranchInfo_Facility branchInfo;
	private FacilityCommandController commandManager;
	public Facility() throws MalformedURLException, RemoteException, NotBoundException {
		branchInfo = new BranchInfo();
		commandManager = new FacilityCommandController("car");
		facilityData = getData();
	}

	public FacilityDataService getData() throws MalformedURLException, RemoteException, NotBoundException {
		return (FacilityDataService) Naming.lookup(RMIConfig.PREFIX + FacilityDataService.NAME);
	}

	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}

	public ResultMessage addFacility(FacilityVO facility) throws RemoteException {
		FacilityPO facilityPO = FacilityTrans.convertVOtoPO(facility);
		if (branchInfo.addCar(facilityPO) == ResultMessage.SUCCESS)
			return facilityData.add(facilityPO);
		return ResultMessage.FAIL;
	}

	public FacilityVO findFacility(String ID) throws RemoteException {
		FacilityPO facilityPO = facilityData.find(ID);
		FacilityVO facilityVO = FacilityTrans.convertPOtoVO(facilityPO);
		return facilityVO;
	}

	public ArrayList<FacilityVO> findFacility() throws RemoteException {
		ArrayList<FacilityPO> facilityPOs = facilityData.find();
		ArrayList<FacilityVO> facilityVOs = FacilityTrans.convertFacilityPOstoVOs(facilityPOs);
		return facilityVOs;
	}

	public ResultMessage modifyFacility(FacilityVO facility) throws RemoteException {
		FacilityPO facilityPO = FacilityTrans.convertVOtoPO(facility);
		if (branchInfo.modifyCar(facilityPO) == ResultMessage.SUCCESS) {
			return facilityData.modify(facilityPO);
		}
		return ResultMessage.FAIL;
	}

	public ResultMessage deleteFacility(FacilityVO facility) throws RemoteException {
		if (branchInfo.deleteCar(facility.branchID, facility.facilityIdString) == ResultMessage.SUCCESS) {
			FacilityPO po =  facilityData.delete(facility.facilityIdString);
			if(po==null){
				return ResultMessage.FAIL;
			}else{
				commandManager.addCommand(new Command<FacilityPO>("delete", po));
			}
		}
		return ResultMessage.FAIL;
	}

	/**
	 * 根据营业厅编号获取新增车辆编号
	 * 
	 * @see Util#splitBranchID(String)
	 * @param branchID
	 *            营业厅编号
	 * @return String型，车辆编号
	 * @throws RemoteException
	 *             远程异常
	 */
	public String getID(String branchID) throws RemoteException {
		String[] branchMessage = Util.splitBranchID(branchID);
		String cityCode = branchMessage[0];
		String branchNumber = branchMessage[1];
		return cityCode + branchNumber + facilityData.getID();
	}

}
