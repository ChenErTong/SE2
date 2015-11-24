package dataservice.transferdataservice;

import java.rmi.RemoteException;

import java.util.ArrayList;

import dataservice.ManageDataService;
import po.CommodityPO;
import po.TransferPO;
import po.receiptpo.TransferArrivalListPO;

public interface TransferDataService extends ManageDataService<TransferPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "TransferData";
	public TransferArrivalListPO  findList(String id) ;
	public ArrayList<CommodityPO> findCommodities();
	public String getID(String cityCode) throws RemoteException;
}
