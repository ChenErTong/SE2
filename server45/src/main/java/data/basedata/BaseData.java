package data.basedata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.Data;
import dataservice.basedataservice.BaseDataService;
import po.BasePO;
import state.FindTypeBase;
import state.ResultMessage;

public class BaseData extends Data implements BaseDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage insert(BasePO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(BasePO PO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BasePO> find(FindTypeBase baseType) {
		// TODO Auto-generated method stub
		return null;
	}

}
