package businesslogic.facilitybl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.openingstockbl.FacilityInfo_OpeningStock;
import businesslogic.organizationbl.FacilityInfo_Branch_Transfer;
import dataservice.facilitydataservice.FacilityDataService;
import po.FacilityPO;
import vo.FacilityVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:33:45
 */
public class FacilityInfo implements FacilityInfo_OpeningStock, FacilityInfo_Branch_Transfer {
	Facility facility;
	FacilityDataService facilityData;

	public FacilityInfo() throws MalformedURLException, RemoteException, NotBoundException {
		facility = new Facility();
		facilityData = facility.getData();
	}

	/**
	 * @see FacilityInfo_OpeningStock#find()
	 */
	public ArrayList<FacilityPO> find() throws RemoteException {
		return facilityData.find();
	}

	/**
	 * @see FacilityInfo_Branch_Transfer#getFacilitiesByBranchID(String)
	 */
	public ArrayList<FacilityVO> getFacilitiesByBranchID(String branchID) throws RemoteException {
		ArrayList<FacilityPO> pos = facilityData.find();
		ArrayList<FacilityVO> vos = new ArrayList<>();
		for (FacilityPO facilityPO : pos) {
			if (facilityPO.getBranchID().equals(branchID)) {
				FacilityVO vo = FacilityTrans.convertPOtoVO(facilityPO);
				vos.add(vo);
			}
		}
		return null;
	}
}
