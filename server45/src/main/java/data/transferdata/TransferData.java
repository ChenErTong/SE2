package data.transferdata;

import java.rmi.RemoteException;

import config.XMLReader;
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
	}
	/**
	 * 中转中心编号（025城市编码+0营业厅+00鼓楼中转中心)
	 * @author Ann
	 */
	@Override
	public String getID(String cityCode) throws RemoteException {
		String prifix=cityCode+0;
		return prifix+super.getID();
	}
	
	@Override
	public void initialFile() {
		poList=new SerSaveAndLoad<TransferPO>("data/"+NAME+".ser");
		configReader=new XMLReader("config/"+NAME+".xml");
	}

}
