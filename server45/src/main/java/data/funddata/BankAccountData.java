package data.funddata;

import java.rmi.RemoteException;

import config.XMLReader;
import data.ManageData;
import dataservice.funddataservice.BankAccountDataService;
import po.BankAccountPO;
import state.FindTypeAccount;
import util.SerSaveAndLoad;

public class BankAccountData extends ManageData<BankAccountPO> implements BankAccountDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public BankAccountData() throws RemoteException {
	}

	/**
	 * type是查找的方式，为NULL则表示进行模糊查询
	 * 如果IDorName包含关键字就返回
	 * @see BankAccountData#find(String, FindTypeAccount)
	 * @author Ann
	 */
	/*public ArrayList<BankAccountPO> find(String keywords, FindTypeAccount bankAccoutType)  throws RemoteException{
		// type是查找的方式，为NULL则表示进行模糊查询
		// 但是我是把所有的账户都返回了，有问题再改
		ArrayList<BankAccountPO> bankAccounts = new ArrayList<>();
		for (int i = 0; i < poList.size(); i++) {
			BankAccountPO po = poList.get(i);
			if (bankAccoutType == null) {
				if (po.getID().contains(keywords) || po.getName().contains(keywords))
					// 如果ID或Name包含关键字就返回
					bankAccounts.add(po);
			}else if (bankAccoutType==FindTypeAccount.ID) {
				if (po.getID().contains(keywords))
					// 如果ID包含关键字就返回
					bankAccounts.add(po);
			}else if (bankAccoutType==FindTypeAccount.NAME) {
				if (po.getName().contains(keywords))
					// 如果Name包含关键字就返回
					bankAccounts.add(po);
			}
		}
		return bankAccounts;
	}*/


	@Override
	public void initialFile() {
		poList=new SerSaveAndLoad<BankAccountPO>("data/"+NAME+".ser");
		configReader=new XMLReader("config/"+NAME+".xml");
	}

}
