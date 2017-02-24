package data.inventorydata;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
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
	 * 类似getID
	 * 库存盘点时，系统自动根据当前盘点时间生成一个截止点
	 * 这个点就是批次（日期）批号（序号）
	 * 在这个截点之后做的出入库是不计入盘点的。
	 * @author Ann
	 */
	@Override
	public String getLotID() throws RemoteException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = sdf.format(new Date());
		return "CHECK"+date+super.getID();
	}

	@Override
	public void initialFile() {
		poList=new SerSaveAndLoad<InventoryPO>("data/"+NAME+".ser");
		configReader=new XMLReader("config/"+NAME+".xml");
	}

}
