package businesslogic.fundbl;

import po.BankAccountPO;
import vo.BankAccountVO;

public class FundTrans {
	public static BankAccountPO convertVOtoPO(BankAccountVO vo){
		if (vo==null) {
			return null;
		}
		else {
			String ID = vo.getID();
			String name  =vo.getName();
			double money = vo.getMoney();
			String level = vo.getLevel();
			return new BankAccountPO(ID, name, money, level);
		}
	}
}
