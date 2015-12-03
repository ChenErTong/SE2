package businesslogic.accountbl;
/**
 * @author LIUXUANLIN
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.accountblservice.AccountBLService;
import state.ResultMessage;
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
	@Override
	public ArrayList<AccountVO> show(String duty) {
		try {
			return AccountBL.show(duty);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String getID() {
		try {
			return AccountBL.getID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ResultMessage addBase(AccountVO vo) {
		try {
			return AccountBL.addBase(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ResultMessage deleteBase(String ID) {
		try {
			return AccountBL.deleteBase(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ResultMessage updateBase(AccountVO vo) {
		try {
			return AccountBL.updateBase(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public AccountVO find(String id) {
		try {
			return AccountBL.find(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
