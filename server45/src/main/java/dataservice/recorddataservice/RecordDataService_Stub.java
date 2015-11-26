package dataservice.recorddataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BussinessConditionPO;
import po.BussinessProcessPO;

public class RecordDataService_Stub implements RecordDataService{
	private  ArrayList<BussinessProcessPO> bussinessProcessPOs;
	private ArrayList<BussinessConditionPO> bussinessConditionPOs;
	private BussinessProcessPO bussinessProcessPO;
	private BussinessConditionPO bussinessConditionPO;
	
	public RecordDataService_Stub(){
		bussinessProcessPOs = new ArrayList<BussinessProcessPO>();
		bussinessConditionPOs = new ArrayList<BussinessConditionPO>();
		
		//bussinessProcessPO = new BussinessProcessPO();
//		bussinessConditionPO = new BussinessConditionPO(null, null, null, 0, 0, 0);
		
		bussinessProcessPOs.add(bussinessProcessPO);
		bussinessConditionPOs.add(bussinessConditionPO);
		
	}
	@Override
	public ArrayList<BussinessProcessPO> getBussinessProcess(String begindate,
			String enddate) {
		System.out.println("GetBussinessProcess succeed!");
		return new ArrayList<BussinessProcessPO>();
	}

	@Override
	public ArrayList<BussinessConditionPO> getBussinessCondition(String enddate) {
		System.out.println("GetBussinessCondition succeed!");
		return new ArrayList<BussinessConditionPO>();
	}
	@Override
	public String getBegin() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void initialFile() {
		// TODO Auto-generated method stub
		
	}

	

}
