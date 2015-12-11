package businesslogic.basebl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.baseblservice.BaseBLService;
import command.BaseCommandController;
import command.CommandDelete;
import po.BasePO;
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
	private Base BaseBL;
	private BaseCommandController commandController;
	public BaseController() throws MalformedURLException, RemoteException, NotBoundException {
		BaseBL = new Base();
		commandController = new BaseCommandController("base");
	}

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
		BasePO basePO = BaseTrans.convertVOtoPO(vo);
		return BaseBL.add(basePO);
	}

	/**
	 * @see BaseBLService#deleteBase(String)
	 */
	public ResultMessage deleteBase(String ID) throws RemoteException {
		BasePO po = BaseBL.delete(ID);
		if (po == null) {
			return ResultMessage.FAIL;
		} else {
			commandController.addCommand(new CommandDelete<BasePO>("delete", po));
			return ResultMessage.SUCCESS;
		}
	}

	/**
	 * @see BaseBLService#updateBase(BaseVO)
	 */
	public ResultMessage updateBase(BaseVO vo) throws RemoteException {
		BasePO basePO = BaseTrans.convertVOtoPO(vo);
		return BaseBL.modify(basePO);
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
