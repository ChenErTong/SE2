package data;

import java.rmi.RemoteException;

import data.accountdata.AccountData;
import data.basedata.BaseData;
import data.basedata.PolicyData;
import data.branchdata.BranchData;
import data.facilitydata.DriverData;
import data.facilitydata.FacilityData;
import data.funddata.BankAccountData;
import data.funddata.DebitAndPayBillData;
import data.inventorydata.InventoryData;
import data.logdata.LogData;
import data.openingstockdata.OpeningStockData;
import data.orderdata.OrderData;
import data.organizationdata.OrganizationData;
import data.receiptdata.ReceiptData;
import data.recorddata.BusinessConditionData;
import data.recorddata.BusinessProcessData;
import data.transferdata.TransferData;
import data.userdata.UserData;
import dataservice.DataService;

public class DataFactory {
	public static DataService createDataService(String name) throws RemoteException {
		switch(name) {
		case AccountData.NAME:						return new AccountData();
		case BaseData.NAME:							return new BaseData();
		case PolicyData.NAME:							return new PolicyData();
		case BranchData.NAME:						return new BranchData();
		case FacilityData.NAME:						return new FacilityData();
		case DebitAndPayBillData.NAME:			return new DebitAndPayBillData();
		case BankAccountData.NAME:				return new BankAccountData();
		case InventoryData.NAME:					return new InventoryData();
		case OpeningStockData.NAME:				return new OpeningStockData();
		case OrderData.NAME:							return new OrderData();
		case OrganizationData.NAME:				return new OrganizationData();
		case ReceiptData.NAME:						return new ReceiptData();
		case BusinessProcessData.NAME:			return new BusinessProcessData();
		case BusinessConditionData.NAME:		return new BusinessConditionData();
		case TransferData.NAME:						return new TransferData();
		case UserData.NAME:							return new UserData();
		case DriverData.NAME:						return new DriverData();
		case LogData.NAME:								return new LogData();
		default:												return null;
		}
	}
}
