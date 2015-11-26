package data;

import java.rmi.RemoteException;
import java.util.ArrayList;

import config.XMLReader;
import dataservice.ManageDataService;
import po.PersistentObject;
import state.ResultMessage;
import util.SerSaveAndLoad;

public class ManageData<PO extends PersistentObject> extends Data implements ManageDataService<PO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected XMLReader configReader;
	protected SerSaveAndLoad<PO> poList;
	/** 当前最大ID */
	protected int maxID;
	/** 添加一条记录后的账单 */
	protected String currentID;
	/** ID最大位数 */
	protected int IDMaxBit;

	public ManageData() throws RemoteException {
	}
	
	public String getID() throws RemoteException{
		return null;
	}
	public PO find(String id) throws RemoteException {
		for (int i = 0; i < poList.size(); i++) {
			PO po = poList.get(i);
			if (po.getID().equals(id))
				return po;
		}
		return null;
	}
    
	public ResultMessage add(PO po) throws RemoteException {
		if (poList.add(po))
			return ResultMessage.SUCCESS;
		return ResultMessage.FAIL;
	}

	public ResultMessage delete(String id) throws RemoteException {
		for (int i = 0; i < poList.size(); i++) {
			PO poFind = poList.get(i);
			if (poFind.getID().equals(id)) {
				poList.remove(i);
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAIL;
	}

	public ResultMessage modify(PO po) throws RemoteException {
		for (int i = 0; i < poList.size(); i++) {
			PO poFind = poList.get(i);
			if (poFind.getID().equals(po.getID())) {
				poList.set(i, po);
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<PO> find() throws RemoteException {
		return poList.getInList();
	}
}
