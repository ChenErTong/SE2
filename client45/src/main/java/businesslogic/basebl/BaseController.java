package businesslogic.basebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.baseblservice.BaseBLService;
import state.ConfirmState;
import state.ResultMessage;
import vo.BaseVO;

/**
 * 管理公司成本常量
 * 
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:32:32
 */
public class BaseController implements BaseBLService {
	Base BaseBL = new Base();

	@Override
	public ConfirmState confirmOperation() {
		return BaseBL.confirmOperation();
	}

	/**
	 * @see BaseBLService#getID()
	 */
	public String getID() throws RemoteException {
			return BaseBL.getID();
	}

	/**
	 * @see BaseBLService#addBase(BaseVO)
	 */
	public ResultMessage addBase(BaseVO vo) throws RemoteException {
			return BaseBL.addBase(vo);
	}

	/**
	 * @see BaseBLService#deleteBase(String)
	 */
	public ResultMessage deleteBase(String ID) throws RemoteException {
			return BaseBL.deleteBase(ID);
	}

	/**
	 * @see BaseBLService#updateBase(BaseVO)
	 */
	public ResultMessage updateBase(BaseVO vo) throws RemoteException {
			return BaseBL.updateBase(vo);
	}

	/**
	 * @see BaseBLService#show()
	 */
	public ArrayList<BaseVO> show() throws RemoteException {
			return BaseBL.show();
	}

	/**
	 * @see BaseBLService#find(String)
	 */
	public BaseVO find(String id) throws RemoteException {
			return BaseBL.find(id);
	}

}
