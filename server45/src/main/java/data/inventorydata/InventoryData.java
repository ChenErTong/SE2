package data.inventorydata;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import config.XMLReader;
import data.ManageData;
import dataservice.inventorydataservice.InventoryDataService;
import po.InventoryPO;
import util.SerSaveAndLoad;

public class InventoryData extends ManageData<InventoryPO> implements InventoryDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public InventoryData() throws RemoteException {
	}

	/**
	 * 库存盘点时，系统自动根据当前盘点时间生成一个截止点
	 * 这个点就是批次（日期）批号（序号）
	 * 在这个截点之后做的出入库是不计入盘点的。
	 * @author Ann
	 */
	@Override
	public String getLotNum() throws RemoteException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = sdf.format(new Date());
		return "CHECK"+date;
	}

	@Override
	public InventoryPO getInventoryPO(String id) throws RemoteException {
		for (int i = 0; i < poList.size(); i++) {
			InventoryPO po = poList.get(i);
			if (po.getID().equals(id)) {
				return po;
			}
		}
		return null;
	}

	@Override
	public InventoryPO getInventoryPO(int a, int b, int c, int d) throws RemoteException {
		for (int i = 0; i < poList.size(); i++) {
			InventoryPO po = poList.get(i);
			if (isValid(po,a,b,c,d)) {
				return po;
			}
		}
		return null;
	}
	
	private boolean isValid(InventoryPO po,int a,int b,int c,int d){
		if(po.getA()==a&&po.getB()==b&&po.getC()==c&&po.getD()==d){
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<InventoryPO> getInventoryPOList(String date) throws RemoteException {
		ArrayList< InventoryPO> inventories = new ArrayList<>();
		for (int i = 0; i < poList.size(); i++) {
			InventoryPO po = poList.get(i);
			if (po.getDate().compareTo(date)<0) {
				inventories.add(po);
			}
		}
		return inventories;
	}

	@Override
	public void initialFile() {
		poList=new SerSaveAndLoad<InventoryPO>("data/"+NAME+".ser");
		configReader=new XMLReader("config/"+NAME+".xml");
	}

}
