package businesslogic.facilitybl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.branchbl.BranchInfo;
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
	public Facility() {
		branchInfo = new BranchInfo();
		facilityData = getData();
	}

	public FacilityDataService getData() {
		try {
			return (FacilityDataService) Naming.lookup(RMIConfig.PREFIX + FacilityDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}

	public ResultMessage addFacility(FacilityVO facility) throws RemoteException {
		FacilityPO facilityPO = FacilityTrans.convertVOtoPO(facility);
		if(branchInfo.addCar(facilityPO)==ResultMessage.SUCCESS)
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
		return facilityData.modify(facilityPO);
	}

	public ResultMessage deleteFacility(FacilityVO facility) throws RemoteException {
		return facilityData.delete(facility.facilityIdString);
	}
	
	public String getID(String branchID) throws RemoteException{
		String[] branchMessage = Util.splitBranchID(branchID);
		String cityCode = branchMessage[0];
		String branchNumber = branchMessage[1];
		return cityCode+branchNumber+facilityData.getID();
	}

}
