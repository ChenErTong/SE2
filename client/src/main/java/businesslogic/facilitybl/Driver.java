package businesslogic.facilitybl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.CommonBusinessLogic;
import businesslogic.organizationbl.branchbl.BranchInfo;
import config.RMIConfig;
import dataservice.facilitydataservice.DriverDataService;
import po.accountpo.DriverPO;
import state.ConfirmState;
import state.ResultMessage;
import util.Util;
import vo.accountvo.DriverVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:33:25
 */
public class Driver implements CommonBusinessLogic<DriverPO>{
	public  final static String BLNAME="Driver";
	private DriverDataService DriverData;
	private BranchInfo_Facility branchInfo;
	
	public Driver() throws MalformedURLException, RemoteException, NotBoundException {
		branchInfo = new BranchInfo();
		
		DriverData = (DriverDataService) Naming.lookup(RMIConfig.PREFIX + DriverDataService.NAME);
	}

	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}

	public ResultMessage add(DriverPO driver) throws RemoteException {
		if (branchInfo.addAccount(driver) == ResultMessage.SUCCESS)
			return DriverData.add(driver);
		return ResultMessage.FAIL;
	}

	public DriverPO delete(String ID) throws RemoteException {
		DriverPO driver = DriverData.find(ID);
		if (driver == null) {
			return null;
		} else {
			String branchID = driver.getOrganizationID();
			if (branchInfo.deleteAccount(branchID, ID) == ResultMessage.SUCCESS) {
				return DriverData.delete(ID);
			}
		}
		return null;
	}

	public DriverPO modify(DriverPO driver) throws RemoteException {
		if (branchInfo.modifyAccount(driver) == ResultMessage.SUCCESS)
			return DriverData.modify(driver);
		return null;
	}

	public ArrayList<DriverVO> findDriver() throws RemoteException {
		ArrayList<DriverPO> driverPOs = DriverData.find();
		ArrayList<DriverVO> driverVOs = FacilityTrans.convertDriverPOstoVOs(driverPOs);
		return driverVOs;

	}

	public DriverVO findDriver(String ID) throws RemoteException {
		DriverPO driverPO = DriverData.find(ID);
		DriverVO driverVO = FacilityTrans.convertPOtoVO(driverPO);
		return driverVO;
	}

	/**
	 * 根据营业厅编号获取新增司机编号
	 * 
	 * @see Util#splitBranchID(String)
	 * @param branchID
	 *            营业厅编号
	 * @return String型，司机辆编号
	 * @throws RemoteException
	 *             远程异常
	 */
	public String getID(String branchID) throws RemoteException {
		String[] branchMessage = Util.splitBranchID(branchID);
		String cityCode = branchMessage[0];
		String branchNumber = branchMessage[1];
		return cityCode + branchNumber + DriverData.getID();
	}

}
