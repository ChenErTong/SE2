package data;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.ManageDataService;
import po.PersistentObject;
import state.ResultMessage;
import util.SerSaveAndLoad;

public class ManageData<PO extends PersistentObject> extends Data implements ManageDataService<PO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected SerSaveAndLoad<PO> poList;

	public ManageData() throws RemoteException {
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
