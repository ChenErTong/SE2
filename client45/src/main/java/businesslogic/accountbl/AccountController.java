package businesslogic.accountbl;
/**
 * @author LIUXUANLIN
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.accountblservice.AccountBLService;
import vo.accountvo.AccountVO;

public class AccountController implements AccountBLService{
     Account AccountBL = new Account();
	@Override
	public ArrayList<AccountVO> show() {
		try {
			return AccountBL.show();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
