package data.funddata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.funddataservice.DebitAndPayBillDataService;
import po.receiptpo.DebitAndPayBillPO;
import state.ReceiptType;
import util.SerSaveAndLoad;
import util.Util;

public class DebitAndPayBillData extends ManageData<DebitAndPayBillPO> implements DebitAndPayBillDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public DebitAndPayBillData() throws RemoteException {
		poList=new SerSaveAndLoad<DebitAndPayBillPO>("data/"+NAME+".ser");
	}
	
	@Override
	public String getID(ReceiptType type) throws RemoteException {
		if(type==ReceiptType.EXPENSE)
			return getExpenseID();
		else {
			return getPayID();
		}
	}

	@Override
	public String getExpenseID()  throws RemoteException{
		String prifix="EXPENSE";
		int IDNumber=0;
		for (DebitAndPayBillPO po: poList.getInList()) {
			if(po.getType()==ReceiptType.EXPENSE)
				++IDNumber;
		}
		//TODO 硬编码
		return prifix+Util.transIntToString(IDNumber, 8);
	}

	@Override
	public String getPayID() throws RemoteException {
		String prifix="PAY";
		int IDNumber=0;
		for (DebitAndPayBillPO po: poList.getInList()) {
			if(po.getType()==ReceiptType.PAY)
				++IDNumber;
		}
		//TODO 硬编码
		return prifix+Util.transIntToString(IDNumber, 8);
	}

	@Override
	public ArrayList<DebitAndPayBillPO> show(ReceiptType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillPO> show(String begin, String end) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
    
}
