package businesslogic.facilitybl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.CommonBusinessLogic;
import businesslogic.organizationbl.branchbl.BranchInfo;
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
public class Facility implements CommonBusinessLogic<FacilityPO>{
	public  final static String BLNAME="Facility";
	private FacilityDataService facilityData;
	private BranchInfo_Facility branchInfo;
	
	public Facility() throws MalformedURLException, RemoteException, NotBoundException {
		branchInfo = new BranchInfo();
		
		facilityData = getData();
	}

	public FacilityDataService getData() throws MalformedURLException, RemoteException, NotBoundException {
		return (FacilityDataService) Naming.lookup(RMIConfig.PREFIX + FacilityDataService.NAME);
	}

	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}

	public ResultMessage add(FacilityPO facility) throws RemoteException {
		if (branchInfo.addCar(facility) == ResultMessage.SUCCESS)
			return facilityData.add(facility);
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

	public FacilityPO modify(FacilityPO facility) throws RemoteException {
		if (branchInfo.modifyCar(facility) == ResultMessage.SUCCESS) {
			return facilityData.modify(facility);
		}
		return null;
	}

	public FacilityPO delete(String ID) throws RemoteException {
		FacilityPO facility = facilityData.find(ID);
		if(facility==null){
			return null;
		}else{
			String branchID = facility.getBranchID();
			if (branchInfo.deleteCar(branchID, ID) == ResultMessage.SUCCESS) {
				return  facilityData.delete(ID);
			}
		}
		return null;
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
