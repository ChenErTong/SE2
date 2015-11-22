package businesslogic.basebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.baseblservice.BaseBLService;
import dataservice.basedataservice.BaseDataService;
import state.ConfirmState;
import state.FindTypeBase;
import state.ResultMessage;
import vo.BaseVO;

public class Base implements BaseBLService{
	private BaseDataService baseData;
	public Base() {
		try {
			baseData = (BaseDataService)Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/"+BaseDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ConfirmState confirmOperation() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<BaseVO> show(FindTypeBase baseType) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getID(FindTypeBase baseType) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage addBase(BaseVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage deleteBase(String ID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage updateBase(BaseVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
}
