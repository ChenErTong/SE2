package data.basedata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.basedataservice.BaseDataService;
import po.BasePO;
import state.FindTypeBase;
import state.ResultMessage;

public class BaseData extends ManageData implements BaseDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage insert(BasePO po) throws RemoteException {
		return super.add(po);
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(BasePO PO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BasePO> find(FindTypeBase baseType) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
