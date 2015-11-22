package data.transferdata;

import java.rmi.RemoteException;

import data.ManageData;
import dataservice.transferdataservice.TransferDataService;
import po.TransferPO;
import util.SerSaveAndLoad;

public class TransferData extends ManageData<TransferPO> implements TransferDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public TransferData() throws RemoteException {
		poList=new SerSaveAndLoad<TransferPO>("data/"+NAME+".ser");
	}
	@Override
	public String getID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
