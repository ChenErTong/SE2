package businesslogic.accountbl;

/**
 * @author LIUXUANLIN
 */
import java.util.ArrayList;

import po.accountpo.AccountPO;
import vo.accountvo.AccountVO;

public class AccountTrans {
	public static ArrayList<AccountVO> convertPOstoVOs(ArrayList<AccountPO> POs) {
		ArrayList<AccountVO> VOs = new ArrayList<AccountVO>();
		for (po.accountpo.AccountPO po : POs) {
			AccountVO vo = convertPOToVO(po);
			VOs.add(vo);
		}
		return VOs;
	}

	public static AccountVO convertPOToVO(AccountPO po) {
		String ID = po.getID();
		String duty = po.getDuty();
		String name = po.getName();
		String birthday = po.getBirthDay();
		String IDCard = po.getIDCard();
		String phone = po.getPhone();
		double salary = po.getSalary();
		String workTime = po.getWorkTime();
		String branchID = po.getBranchID();
		AccountVO vo = new AccountVO(ID, duty, name, birthday, IDCard, phone, salary, workTime,branchID);
		return vo;
	}

	public static AccountPO convertVOtoPO(AccountVO vo) {
		if (vo == null)
			return null;
		else {
			String ID = vo.ID;
			String duty = vo.Duty;
			String name = vo.Name;
			String birthDay = vo.BirthDay;
			String IDCard = vo.IDCard;
			String phone = vo.Phone;
			double salary = vo.Salary;
			String workTime = vo.WorkTime;
			return new AccountPO(ID, duty, name, birthDay, IDCard, phone, salary, workTime);
		}
	}

	public static ArrayList<AccountPO> convertVOstoPOs(ArrayList<AccountVO> vos) {
		ArrayList<AccountPO> pos = new ArrayList<>();
		for (AccountVO vo : vos) {
			AccountPO po = convertVOtoPO(vo);
			pos.add(po);
		}
		return pos;
	}
	
	public static ArrayList<AccountVO> convertPOstoVOsByDuty(ArrayList<AccountPO> pos,String duty){
		ArrayList<AccountVO> vos = new ArrayList<AccountVO>();
		for (po.accountpo.AccountPO po : pos) {
			if(po.getDuty().equals(duty)){
				AccountVO vo = convertPOToVO(po);
				vos.add(vo);
			}
		}
		return vos;
	}
}
