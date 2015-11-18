package data.basedata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.basedataservice.BaseDataService;
import po.BasePO;
import po.TransferPO;
import state.FindTypeBase;
import state.ResultMessage;
import util.SerSaveAndLoad;

public class BaseData extends ManageData implements BaseDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public BaseData() throws RemoteException {
		poList=new SerSaveAndLoad<BasePO>("data/"+NAME+".ser");
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
