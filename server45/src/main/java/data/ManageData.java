package data;

import java.rmi.RemoteException;
import java.util.ArrayList;

import config.XMLReader;
import dataservice.ManageDataService;
import po.PersistentObject;
import state.ResultMessage;
import util.SerSaveAndLoad;
import util.Util;

public abstract class ManageData<PO extends PersistentObject> extends Data implements ManageDataService<PO> {

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
		initialFile();
		maxID=Integer.parseInt(configReader.getValue("maxID"));
		IDMaxBit=Integer.parseInt(configReader.getValue("IDMaxBit"));
	}
	
	public String getID() throws RemoteException{
		//由于添加了可撤销操作，取消maxID置0
		/*if (poList.isEmpty()) {
			maxID = 0;	// 初始化最大ID
			configReader.setValue("maxID", Util.transIntToString(maxID, IDMaxBit));
		}*/
		if ((maxID+"").equals(Util.max(IDMaxBit))) {
			maxID = 0;	// 初始化最大ID(循环编号)
			configReader.setValue("maxID", Util.transIntToString(maxID, IDMaxBit));
		}
		currentID = Util.transIntToString(maxID + 1, IDMaxBit);
		return currentID;
	}
	
	protected void addID() {
		++maxID;
		configReader.setValue("maxID", Util.transIntToString(maxID, IDMaxBit));
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
		if (poList.add(po)){
			addID();
			return ResultMessage.SUCCESS;
		}return ResultMessage.FAIL;
	}

	public PO delete(String id) throws RemoteException {
		for (int i = 0; i < poList.size(); i++) {
			PO poFind = poList.get(i);
			if (poFind.getID().equals(id)) {
				poList.remove(i);
				return poFind;
			}
		}
		return null;
	}

	public PO modify(PO po) throws RemoteException {
		for (int i = 0; i < poList.size(); i++) {
			PO poFind = poList.get(i);
			if (poFind.getID().equals(po.getID())) {
				poList.set(i, po);
				return poFind;
			}
		}
		return null;
	}

	@Override
	public ArrayList<PO> find() throws RemoteException {
		return poList.getInList();
	}
}
