package businesslogic.facilitybl;

import java.util.ArrayList;

import po.FacilityPO;
import po.accountpo.DriverPO;
import po.receiptpo.LoadingListPO;
import vo.FacilityVO;
import vo.accountvo.DriverVO;

public class FacilityTrans {
	public static FacilityPO convertVOtoPO(FacilityVO vo) {
		if (vo == null)
			return null;
		else {
			String ID = vo.getFacilityIdString();
			String date = vo.getDateString();
			String manageID = vo.getManagerId();
			String bottomCode=vo.getBottomCode();
			String engineNumber  = vo.getEngineCode();
			String VIN = vo.getVehicleIdentificationNumber();
			ArrayList<LoadingListPO> deliverHistory = vo.getDeliverHistory();
			return new FacilityPO(ID, manageID, date, deliverHistory, bottomCode, engineNumber,VIN);
		}
	}

	public static FacilityVO convertPOtoVO(FacilityPO po) {
		if (po == null)
			return null;
		else{
			String ID = po.getID();
			String date = po.getDate();
			String manageID = po.getManagerId();
			String bottomCode=po.getBottomCode();
			String engineNumber  = po.getEngineCode();
			String VIN = po.getVehicleIdentificationNumber();
			ArrayList<LoadingListPO> deliverHistory = po.getDeliverHistory();
			return new FacilityVO(manageID, deliverHistory, ID, date, bottomCode, engineNumber,VIN);
		}
	}
	public static ArrayList<FacilityVO> convertFacilityPOstoVOs(ArrayList<FacilityPO> pos) {
		ArrayList<FacilityVO> vos = new ArrayList<>(pos.size());
		for (FacilityPO facilityPO : pos) {
			FacilityVO vo = convertPOtoVO(facilityPO);
			vos.add(vo);
		}
		return vos;
	}
	
	public static DriverPO convertVOtoPO(DriverVO vo) {
		if (vo == null)
			return null;
		else {
			String ID  = vo.getID();
			String duty  =vo.getDuty();
			String name = vo.getName();
			String birthDay  = vo.getBirthDay();
			String IDCard = vo.getIDCard();
			String phone = vo.getPhone();
			double salary = vo.getSalary();
			String workTime = vo.getWorkTime();
			int receiptNum = vo.getReceiptNum();
			return new DriverPO(ID, duty, name, birthDay, IDCard, phone, salary, workTime, receiptNum);
		}
	}

	public static DriverVO convertPOtoVO(DriverPO po) {
		if (po == null)
			return null;
		else{
			String ID  = po.getID();
			String duty  =po.getDuty();
			String name = po.getName();
			String birthDay  = po.getBirthDay();
			String IDCard = po.getIDCard();
			String phone = po.getPhone();
			double salary = po.getSalary();
			String workTime = po.getWorkTime();
			int receiptNum = po.getReceiptNum();
			return new DriverVO(ID, duty, name, birthDay, IDCard, phone, salary, workTime, receiptNum);
		}
	}
	
	public static ArrayList<DriverVO> convertDriverPOstoVOs(ArrayList<DriverPO> pos) {
		ArrayList<DriverVO> vos = new ArrayList<>(pos.size());
		for (DriverPO driverPO : pos) {
			DriverVO vo = convertPOtoVO(driverPO);
			vos.add(vo);
		}
		return vos;
	}
	
	public static ArrayList<FacilityPO> convertVOstoPOs(ArrayList<FacilityVO> vos) {
		ArrayList<FacilityPO> pos = new ArrayList<>();
		for (FacilityVO vo : vos) {
			FacilityPO po = convertVOtoPO(vo);
			pos.add(po);
		}
		return pos;
	}
}
