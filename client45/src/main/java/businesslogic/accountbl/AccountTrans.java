package businesslogic.accountbl;

import java.util.ArrayList;

import po.accountpo.AccountPO;
import vo.accountvo.AccountVO;
/**
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:32:13
 */
public class AccountTrans {
	public static ArrayList<AccountPO> convertPOstoVOs(ArrayList<AccountPO> POs) {
		ArrayList<AccountPO> VOs = new ArrayList<AccountPO>();
		for (po.accountpo.AccountPO po : POs) {
			AccountPO vo = convertPOToVO(po);
			VOs.add(vo);
		}
		return VOs;
	}

	public static AccountPO convertPOToVO(AccountPO po) {
		if(po==null){
			return null;
		}
		String ID = po.getID();
		String duty = po.getDuty();
		String name = po.getName();
		String birthday = po.getBirthDay();
		String IDCard = po.getIDCard();
		String phone = po.getPhone();
		double salary = po.getSalary();
		String workTime = po.getWorkTime();
		String branchID = po.getOrganizationID();
		AccountPO vo = new AccountPO(ID, duty, name, birthday, IDCard, phone, salary, workTime,branchID);
		return vo;
	}

	public static AccountPO convertVOtoPO(AccountPO vo) {
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

	public static ArrayList<AccountPO> convertVOstoPOs(ArrayList<AccountPO> vos) {
		ArrayList<AccountPO> pos = new ArrayList<>();
		for (AccountPO vo : vos) {
			AccountPO po = convertVOtoPO(vo);
			pos.add(po);
		}
		return pos;
	}
	
	public static ArrayList<AccountPO> convertPOstoVOsByDuty(ArrayList<AccountPO> pos,String duty){
		ArrayList<AccountPO> vos = new ArrayList<AccountPO>();
		for (po.accountpo.AccountPO po : pos) {
			if(po.getDuty().equals(duty)){
				AccountPO vo = convertPOToVO(po);
				vos.add(vo);
			}
		}
		return vos;
	}
}
