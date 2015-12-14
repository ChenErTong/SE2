package data.userdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import config.XMLReader;
import data.ManageData;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import state.UserIdentity;
import util.SerSaveAndLoad;
import util.Util;

public class UserData extends ManageData<UserPO> implements UserDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public UserData() throws RemoteException {
		initAdmin();
	}

	private void initAdmin() {
		return;
	}

	@Override
	public void initialFile() {
		poList=new SerSaveAndLoad<UserPO>("data/"+NAME+".ser");
		configReader=new XMLReader("config/"+NAME+".xml");
	}

	@Override
	public String getUserID(String organizationID,UserIdentity userIden) throws RemoteException {
		if(userIden.userIDMidFix.equals("0")||userIden.userIDMidFix.equals("1")||userIden.userIDMidFix.equals("2"))
			organizationID="000000";
		if ((maxID+"").equals(Util.max(IDMaxBit))) {
			maxID = 0;	// 初始化最大ID(循环编号)
			configReader.setValue("maxID", Util.transIntToString(maxID, IDMaxBit));
		}
		currentID = Util.transIntToString(maxID + 1, IDMaxBit);
		String linShiID = organizationID+userIden.userIDMidFix+currentID;
		while(containsID(poList.getInList(), linShiID)){
			addID();
			maxID%=100;
			System.out.println(maxID);
			currentID = Util.transIntToString(maxID + 1, IDMaxBit);
			linShiID = organizationID+userIden.userIDMidFix+currentID;
		}
		return linShiID;
	}
	private boolean containsID(ArrayList<UserPO> pos, String linShiID) {
		for (UserPO po : pos) {
			if(po.getID().equals(linShiID))
				return true;
		}
		return false;
	}
}
