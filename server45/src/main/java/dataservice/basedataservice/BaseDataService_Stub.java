package dataservice.basedataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BasePO;
import state.FindTypeBase;
import state.ResultMessage;

public class BaseDataService_Stub implements BaseDataService{
	private ArrayList<BasePO> basePOs;
	
	private BasePO basePO_1;
	private BasePO basePO_2;
	
	public BaseDataService_Stub(){
		basePOs = new ArrayList<BasePO>();
		basePO_1 = new BasePO("123", "2015/10/24");
		basePO_2 = new BasePO("456","2015/10/27");
		
		basePOs.add(basePO_1);
		basePOs.add(basePO_2);
	}
	@Override
	public ResultMessage add(BasePO po) {
		System.out.println("Insert a new base succeed!");
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String ID) {
		System.out.println("Delete a base succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modify(BasePO PO) {
		System.out.println("Modify a base succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<BasePO> find(FindTypeBase baseType) {
		System.out.println("Find all bases according to de baseType");
		return new ArrayList<BasePO>();
	}
	@Override
	public ArrayList<BasePO> find() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
