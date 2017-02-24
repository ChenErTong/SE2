package businesslogic;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.accountbl.Account;
import businesslogic.basebl.Base;
import businesslogic.basebl.Policy;
import businesslogic.facilitybl.Driver;
import businesslogic.facilitybl.Facility;
import businesslogic.fundbl.BankAccount;
import businesslogic.organizationbl.branchbl.Branch;
import businesslogic.organizationbl.transferbl.Transfer;
import businesslogic.userbl.User;

public class BLFactory {
	public static CommonBusinessLogic<?> getBLByName(String BLName)throws RemoteException{
		try {
			switch(BLName){
				case Account.BLNAME: 		return new Account();
				case Base.BLNAME: 				return new Base();
				case Policy.BLNAME: 			return new Policy();
				case Facility.BLNAME:			return new Facility();
				case Driver.BLNAME:			return new Driver();
				case BankAccount.BLNAME:	return new BankAccount();
				case Branch.BLNAME: 			return new Branch();
				case Transfer.BLNAME: 		return new Transfer();
				case User.BLNAME: 				return new User();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
