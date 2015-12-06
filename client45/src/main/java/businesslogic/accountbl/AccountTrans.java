package businesslogic.accountbl;

import java.util.ArrayList;

import po.accountpo.AccountPO;
import vo.accountvo.AccountVO;
/**
 * 完成Account VO PO之间的转换
 * 包括AccountVO->AccountPO
 * AccountPO->AccountVO
 * ArrayList<AccountVO>->ArrayList<AccountPO>
 * <AccountPO>->ArrayList<AccountVO>
 * 
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:32:13
 */
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
	
	/**
	 * 在ArrayList<AccountPO>中找到与给定职务与人员的职务相同的持久化对象
	 * 将其转换为VO 
	 * 
	 * @author Ann
	 * @version 创建时间：2015年12月6日 下午3:25:18
	 * @param pos ArrayList<AccountPO>型，待转换PO列表
	 * @param duty String型，给定的职务
	 * @return 职务符合给定duty的accountVO列表
	 */
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
