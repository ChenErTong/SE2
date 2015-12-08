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
public class AccountController implements AccountBLService {
	Account AccountBL = new Account();

	/**
	 * @see AccountBLService#show()
	 */
	public ArrayList<AccountVO> show() throws RemoteException {
		return AccountBL.show();
	}

	/**
	 * @see AccountBLService#show(String)
	 */
	public ArrayList<AccountVO> show(String duty) throws RemoteException {
		return AccountBL.show(duty);
	}

	/**
	 * @see AccountBLService#getID()
	 */
	public String getID() throws RemoteException {
		return AccountBL.getID();
	}

	/**
	 * @see AccountBLService#addAccount(AccountVO)
	 */
	public ResultMessage addAccount(AccountVO vo) throws RemoteException {
		return AccountBL.addAccount(vo);
	}

	/**
	 * @see AccountBLService#deleteAccount(String)
	 */
	public ResultMessage deleteAccount(String ID) throws RemoteException {
		return AccountBL.deleteAccount(ID);
	}

	/**
	 * @see AccountBLService#updateAccount(AccountVO)
	 */
	public ResultMessage updateAccount(AccountVO vo) throws RemoteException {
		return AccountBL.updateAccount(vo);
	}

	/**
	 * @see AccountBLService#find(String)
	 */
	public AccountVO find(String id) throws RemoteException {
		return AccountBL.find(id);
	}

}
