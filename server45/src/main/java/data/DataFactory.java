package data;

import java.rmi.RemoteException;

import data.accountdata.AccountData;
import data.basedata.BaseData;
import data.branchdata.BranchData;
import data.facilitydata.FacilityData;
import data.funddata.BankAccountData;
import data.funddata.DebitAndPayBillData;
import data.funddata.ExpenseData;
import data.inventorydata.InventoryData;
import data.openingstockdata.OpeningStockData;
import data.receiptdata.ReceiptData;
import data.recorddata.RecordData;
import data.transferdata.TransferData;
import data.userdata.UserData;
import dataservice.DataService;

public class DataFactory {
	public static DataService<?> createDataService(String name) throws RemoteException {
		switch(name) {
		case AccountData.NAME:
			return new AccountData();
		case BaseData.NAME:
			return new BaseData();
		case BranchData.NAME:
			return new BranchData();
		case FacilityData.NAME:
			return new FacilityData();
		case DebitAndPayBillData.NAME:
			return new DebitAndPayBillData();
		case BankAccountData.NAME:
			return new BankAccountData();
		case ExpenseData.NAME:
			return new ExpenseData();
		case InventoryData.NAME:
			return new InventoryData();
		case OpeningStockData.NAME:
			return new OpeningStockData();
		case ReceiptData.NAME:
			return new ReceiptData();
		case RecordData.NAME:
			return new RecordData();
		case TransferData.NAME:
			return new TransferData();
		case UserData.NAME:
			return new UserData();
		default:
			return null;
		}
	}
}
