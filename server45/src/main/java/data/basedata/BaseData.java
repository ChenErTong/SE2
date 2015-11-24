package data.basedata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.basedataservice.BaseDataService;
import po.BasePO;
import state.FindTypeBase;
import util.SerSaveAndLoad;

public class BaseData extends ManageData<BasePO> implements BaseDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public BaseData() throws RemoteException {
		poList=new SerSaveAndLoad<BasePO>("data/"+NAME+".ser");
	}
	public ArrayList<BasePO> find(FindTypeBase baseType) throws RemoteException {
		//改接口
		ArrayList<BasePO> bankAccounts = new ArrayList<>();
		for (int i = 0; i < poList.size(); i++) {
			BasePO po = poList.get(i);
			if (baseType == FindTypeBase.SalaryPolicy) {
					// 如果SalaryPolicy包含关键字就返回
					bankAccounts.add(po);
			}else if (baseType==FindTypeBase.DISTANCE) {
					// 如果DISTANCE包含关键字就返回
					bankAccounts.add(po);
			}else if (baseType==FindTypeBase.PRICE) {
					// 如果PRICE包含关键字就返回
					bankAccounts.add(po);
			}
		}
		return bankAccounts;
	}
	@Override
	public String getID(FindTypeBase baseType) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
