package businesslogic.facilitybl;

import java.math.BigDecimal;
import java.util.ArrayList;

import po.FacilityPO;
import po.accountpo.DriverPO;
import po.receiptpo.orderreceiptpo.LoadingListPO;
import vo.FacilityVO;
import vo.accountvo.DriverVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:33:49
 */
public class FacilityTrans {
	public static FacilityPO convertVOtoPO(FacilityVO vo) {
		if (vo == null)
			return null;
		else {
			String ID = vo.facilityIdString;
			String date = vo.dateString;
			String manageID = vo.managerId;
			String bottomCode = vo.bottomCode;
			String engineNumber = vo.engineCode;
			String VIN = vo.vehicleIdentificationNumber;
			ArrayList<LoadingListPO> deliverHistory = vo.deliverHistory;
			String branchID = vo.branchID;
			return new FacilityPO(ID, manageID, date, deliverHistory, bottomCode, engineNumber, VIN, branchID);
		}
	}

	public static FacilityVO convertPOtoVO(FacilityPO po) {
		if (po == null)
			return null;
		else {
			String ID = po.getID();
			String date = po.getDate();
			String manageID = po.getManagerId();
			String bottomCode = po.getBottomCode();
			String engineNumber = po.getEngineCode();
			String VIN = po.getVehicleIdentificationNumber();
			ArrayList<LoadingListPO> deliverHistory = po.getDeliverHistory();
			String branchID = po.getBranchID();
			return new FacilityVO(manageID, deliverHistory, ID, date, bottomCode, engineNumber, VIN, branchID);
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
			String ID = vo.ID;
			String duty = vo.Duty;
			String name = vo.Name;
			String birthDay = vo.BirthDay;
			String IDCard = vo.IDCard;
			String phone = vo.Phone;
			BigDecimal salary = vo.Salary;
			String workTime = vo.WorkTime;
			String carID = vo.carID;
			String branchID = vo.branchID;
			return new DriverPO(ID, duty, name, birthDay, IDCard, phone, salary, workTime, carID,branchID);
		}
	}

	public static DriverVO convertPOtoVO(DriverPO po) {
		if (po == null)
			return null;
		else {
			String ID = po.getID();
			String duty = po.getDuty();
			String name = po.getName();
			String birthDay = po.getBirthDay();
			String IDCard = po.getIDCard();
			String phone = po.getPhone();
			BigDecimal salary = po.getSalary();
			String workTime = po.getWorkTime();
			String carID = po.getCarID();
			String branchID = po.getOrganizationID();
			return new DriverVO(ID, duty, name, birthDay, IDCard, phone, salary, workTime, carID, branchID);
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
