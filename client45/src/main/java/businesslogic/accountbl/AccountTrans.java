package businesslogic.accountbl;
/**
 * @author LIUXUANLIN
 */
import java.util.ArrayList;

import po.accountpo.AccountPO;
import vo.accountvo.AccountVO;

public class AccountTrans {
	public static ArrayList<AccountVO> POstoVOs(ArrayList<AccountPO> POs) {
		ArrayList<AccountVO> VOs = new ArrayList<AccountVO>();
		for(po.accountpo.AccountPO po : POs) {
			AccountVO vo = POToVO(po);
			VOs.add(vo);
		}
		return VOs;
	}
	public static AccountVO POToVO(AccountPO po) {
		String ID=po.getID();
		String duty=po.getDuty();
		String name =po.getName();
		String birthday=po.getBirthDay();
		String IDCard=po.getIDCard ();
		 String phone=po.getPhone() ;
		double salary=po.getSalary();
		 String workTime=po.getWorkTime();
		 int receiptNum=po.getReceiptNum() ;
		AccountVO vo = new AccountVO(ID,duty,  name,  birthday,  IDCard,  phone, salary,workTime, receiptNum);
		return vo;
	}
	
	public static AccountPO convertVOtoPO(AccountVO vo){
		if(vo==null)
			return null;
		else {
			String ID = vo.getID();
			String duty = vo.getDuty();
			String name  = vo.getName();
			String birthDay = vo.getBirthDay();
			String IDCard = vo.getIDCard();
			String phone = vo.getPhone();
			double salary =vo.getSalary();
			String workTime = vo.getWorkTime();
			int receiptNum = vo.getReceiptNum();
			return new AccountPO(ID, duty, name, birthDay, IDCard, phone, salary, workTime, receiptNum);
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
}
