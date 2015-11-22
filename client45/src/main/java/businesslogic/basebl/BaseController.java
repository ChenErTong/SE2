package businesslogic.basebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.baseblservice.BaseBLService;
import state.ConfirmState;
import state.FindTypeBase;
import state.ResultMessage;
import vo.BaseVO;

public class BaseController implements BaseBLService{
    Base BaseBL;
	@Override
	public ConfirmState confirmOperation() {
		// TODO Auto-generated method stub
		return BaseBL.confirmOperation();
	}

	@Override
	public ArrayList<BaseVO> show(FindTypeBase baseType) throws RemoteException {
		// TODO Auto-generated method stub
		return BaseBL.show(baseType);
	}

	@Override
	public String getID(FindTypeBase baseType) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addBase(BaseVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return  BaseBL.addBase(vo);
	}

	@Override
	public ResultMessage deleteBase(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return  BaseBL.deleteBase(ID);
	}

	@Override
	public ResultMessage updateBase(BaseVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return  BaseBL.updateBase(vo);
	}

}
