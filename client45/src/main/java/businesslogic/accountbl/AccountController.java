package businesslogic.accountbl;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.accountblservice.AccountBLService;
import state.ResultMessage;
import vo.accountvo.AccountVO;
/**
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:31:56
 */
public class AccountController implements AccountBLService{
     Account AccountBL = new Account();
	/**
	 * @see AccountBLService#show()
	 */
	public ArrayList<AccountVO> show() {
		try {
			return AccountBL.show();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @see AccountBLService#show(String)
	 */
	public ArrayList<AccountVO> show(String duty) {
		try {
			return AccountBL.show(duty);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @see AccountBLService#getID()
	 */
	public String getID() {
		try {
			return AccountBL.getID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @see AccountBLService#addAccount(AccountVO)
	 */
	public ResultMessage addAccount(AccountVO vo) {
		try {
			return AccountBL.addAccount(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @see AccountBLService#deleteAccount(String)
	 */
	public ResultMessage deleteAccount(String ID) {
		try {
			return AccountBL.deleteAccount(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @see AccountBLService#updateAccount(AccountVO)
	 */
	public ResultMessage updateAccount(AccountVO vo) {
		try {
			return AccountBL.updateAccount(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @see AccountBLService#find(String)
	 */
	public AccountVO find(String id) {
		try {
			return AccountBL.find(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
