package businesslogic.transferbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.openingstockbl.TransferInfo_OpeningStock;
import dataservice.transferdataservice.TransferDataService;
import po.TransferPO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:38:44
 */
public class TransferInfo implements TransferInfo_OpeningStock{
	Transfer transfer;
	TransferDataService transferData;
	public TransferInfo() {
		transfer = new Transfer();
		transferData = transfer.getData();
	}	

	@Override
	public ArrayList<TransferPO> find() throws RemoteException {
		return  transferData.find();
	}

}
