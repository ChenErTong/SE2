package businesslogic.fundbl;

import po.BankAccountPO;
import vo.BankAccountVO;

public class FundTrans {
	public static BankAccountPO convertVOtoPO(BankAccountVO vo){
		return new BankAccountPO(vo.getID(), vo.getName(), vo.getMoney(), vo.getLevel());
	}
}
