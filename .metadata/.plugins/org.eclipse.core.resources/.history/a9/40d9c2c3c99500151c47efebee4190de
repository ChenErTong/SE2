package dataservice.funddataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.ManageDataService;
import po.receiptpo.DebitAndPayBillPO;
import state.ReceiptState;
import state.ReceiptType;

/**
 * 收款单、付款单的集体载入、保存、查看和修改操作
 * @author zsq
 * @version Oct 22,2015
 */
public interface DebitAndPayBillDataService extends ManageDataService<DebitAndPayBillPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "DebitAndPayBillData";
	/**
	 * 更新DebitAndPayBillPO
	 * @param PO
	 * @return 
	 * @return 处理结果
	 */
	public DebitAndPayBillPO find(String ID)throws RemoteException;
	/**
	 * 根据单据类型生成编号
	 * @param type 收款单或者付款单
	 * @return 可用的单据编号 ；若为null则传入类型错误
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public String getID(ReceiptType type)  throws RemoteException;

	/**
	 * @return 获得新的收款单ID
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public String getExpenseID() throws RemoteException ;

	/**
	 * @return 获得新的付款单ID
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public String getPayID()  throws RemoteException;

	/**
	 * 按照单据类型返回单据【收款单或者付款单】
	 * @param type
	 * @return
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ArrayList<DebitAndPayBillPO> show(ReceiptType type) throws RemoteException;
	/**
	 * 按照时间区间返回单据【收款单或者付款单】
	 * @param 
	 * @return
	 * @author lxl
	 * @version 11  20 2015
	 */
	public ArrayList<DebitAndPayBillPO> showList(String begin,String end) throws RemoteException;
	
	public ArrayList<DebitAndPayBillPO> showList(String end) throws RemoteException;
	
	public ArrayList<DebitAndPayBillPO> show(ReceiptType type,ReceiptState State) throws RemoteException;
	
	public ArrayList<DebitAndPayBillPO> showDate(String date)throws RemoteException;
	

}
