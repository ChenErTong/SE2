package data;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.PersistentObject;
import state.ResultMessage;
import util.SerSaveAndLoad;

public class Data  extends UnicastRemoteObject{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected SerSaveAndLoad<PersistentObject> poList;
	
	public Data() throws RemoteException {
	}
	public PersistentObject find(String id)throws RemoteException {
		for (int i = 0; i < poList.size(); i++) {
			PersistentObject po = poList.get(i);
			if(po.getID().equals(id))
				return po;
		}
		return null;
	}
	public ResultMessage add(PersistentObject po)throws RemoteException {
		if(poList.add(po))
			return ResultMessage.SUCCESS;
		return ResultMessage.FAIL;
	}
	public ResultMessage delete(String id) throws RemoteException{
		for (int i = 0; i < poList.size(); i++) {
			PersistentObject poFind = poList.get(i);
			if(poFind.getID().equals(id)){
				poList.remove(i);
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAIL;
	}
	public ResultMessage modify(PersistentObject po)throws RemoteException {
		for (int i = 0; i < poList.size(); i++) {
			PersistentObject poFind = poList.get(i);
			if(poFind.getID().equals(po.getID())){
				poList.set(i, po);
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAIL;
	}
}
