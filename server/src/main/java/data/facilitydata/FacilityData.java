package data.facilitydata;

import java.rmi.RemoteException;

import config.XMLReader;
import data.ManageData;
import dataservice.facilitydataservice.FacilityDataService;
import po.FacilityPO;
import util.SerSaveAndLoad;
/**
 * 
 * @author Ann
 * 2015-11-17 21:37:04
 */
public class FacilityData extends ManageData<FacilityPO> implements FacilityDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public FacilityData() throws RemoteException {
	}
	@Override
	public void initialFile() {
		poList=new SerSaveAndLoad<FacilityPO>("data/"+NAME+".ser");
		configReader=new XMLReader("config/"+NAME+".xml");
	}

}
