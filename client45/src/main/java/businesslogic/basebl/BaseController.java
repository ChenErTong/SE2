package businesslogic.basebl;
/**
 * @author LIUXUANLIN
 */
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
		return BaseBL.confirmOperation();
	}

	@Override
	public ArrayList<BaseVO> show(FindTypeBase baseType){
		try {
			return BaseBL.show(baseType);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getID(FindTypeBase baseType) {
		return null;
	}

	@Override
	public ResultMessage addBase(BaseVO vo) {
		try {
			return  BaseBL.addBase(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage deleteBase(String ID){
		try {
			return  BaseBL.deleteBase(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage updateBase(BaseVO vo){
		try {
			return  BaseBL.updateBase(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
