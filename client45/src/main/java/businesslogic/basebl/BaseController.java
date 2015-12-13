package businesslogic.basebl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.logbl.LogController;
import businesslogicservice.baseblservice.BaseBLService;
import command.Command;
import command.CommandAdd;
import command.CommandController;
import command.CommandDelete;
import command.CommandModify;
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
	private CommandController<BasePO> commandController;

	public BaseController() throws MalformedURLException, RemoteException, NotBoundException {
		BaseBL = new Base();
		commandController = new CommandController<BasePO>("base");
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
		LogController.getInstance().addLog("添加价格常量");
		BasePO basePO = BaseTrans.convertVOtoPO(vo);
		Command<BasePO> addCommand=new CommandAdd<BasePO>(Base.BLNAME, basePO);
		commandController.addCommand(addCommand);
		return addCommand.execute();
	}

	/**
	 * @see BaseBLService#deleteBase(String)
	 */
	public ResultMessage deleteBase(String ID) throws RemoteException {
		LogController.getInstance().addLog("删除价格常量");
		BasePO po = BaseBL.delete(ID);
		if (po == null) {
			return ResultMessage.FAIL;
		} else {
			commandController.addCommand(new CommandDelete<BasePO>(Base.BLNAME, po));
			return ResultMessage.SUCCESS;
		}
	}

	/**
	 * @see BaseBLService#updateBase(BaseVO)
	 */
	public ResultMessage updateBase(BaseVO vo) throws RemoteException {
		LogController.getInstance().addLog("修改价格常量信息");
		BasePO basePO = BaseTrans.convertVOtoPO(vo);
		BasePO res =  BaseBL.modify(basePO);
		if(res==null){
			return ResultMessage.FAIL;
		}else{
			Command<BasePO> modifyCommand = new CommandModify<BasePO>(Base.BLNAME, res);
			commandController.addCommand(modifyCommand);
			return ResultMessage.SUCCESS;
		}
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

	@Override
	public boolean canUndo() {
		return commandController.canUndo();
	}

	@Override
	public boolean canRedo() {
		return commandController.canRedo();
	}

	@Override
	public ResultMessage undo() throws RemoteException {
		return commandController.undoCommand();
	}

	@Override
	public ResultMessage redo() throws RemoteException {
		return commandController.redoCommand();
	}

}
