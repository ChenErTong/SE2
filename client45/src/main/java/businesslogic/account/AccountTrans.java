package businesslogic.account;

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
}
