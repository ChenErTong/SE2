package businesslogic.transferbl;

import java.rmi.RemoteException;

import businesslogic.organizationbl.InventoryInfo_Branch_Transfer;
import vo.InventoryVO;

/** 
* 程序的简单说明 
* @author Ann
* @version 创建时间：2015年12月5日 下午7:36:59 
*/
public interface InventoryInfo_Transfer extends InventoryInfo_Branch_Transfer{
	public InventoryVO getTransferInitialInventory(String transferID) throws RemoteException;
}
