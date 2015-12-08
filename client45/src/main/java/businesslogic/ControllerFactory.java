package businesslogic;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.accountbl.AccountController;
import businesslogic.basebl.BaseController;
import businesslogic.basebl.PolicyController;
import businesslogic.branchbl.BranchController;
import businesslogic.facilitybl.DriverController;
import businesslogic.facilitybl.FacilityController;
import businesslogic.fundbl.BankAccountController;
import businesslogic.fundbl.DebitAndPayBillController;
import businesslogic.fundbl.DebitAndPayBillShowController;
import businesslogic.inventorybl.InventoryController;
import businesslogic.logbl.LogController;
import businesslogic.orderbl.OrderController;
import businesslogic.organizationbl.OrganizationController;
import businesslogic.receiptbl.ReceiptController;
import businesslogic.recordbl.RecordController;
import businesslogic.transferbl.TransferController;
import businesslogic.userbl.UserController;
/**
 * 
 * @author czw
 * @version 创建时间：2015年12月3日 下午3:39:10
 */
public class ControllerFactory {
	private static LogController logController = null;
	private static FacilityController facilityController = null;
	private static DriverController driverController = null;
	private static UserController userController = null;
	private static AccountController accountController = null;
	private static BaseController baseController = null;
	private static BankAccountController bankAccountController = null;
	private static BranchController branchController = null;
	private static DebitAndPayBillController debitAndPayBillController = null;
	private static DebitAndPayBillShowController debitAndPayBillShowController = null;
	private static InventoryController inventoryController = null;
	private static OrganizationController organizationController = null;
	private static RecordController recordController = null;
	private static ReceiptController receiptController = null;
	private static OrderController orderController = null;
	private static PolicyController policyController = null;
	private static TransferController transferController = null;
	
	public static FacilityController getFacilityController(){
		if(facilityController == null) facilityController = new FacilityController();
		return facilityController;
	}
	
	public static DriverController getDriverController(){
		if(driverController == null) driverController = new DriverController();
		return driverController;
	}

	public static UserController getUserController() throws MalformedURLException, RemoteException, NotBoundException{
		if(userController == null) userController = new UserController();
		return userController;
	}
	
	public static AccountController getAccountController() {
		if(accountController == null) accountController = new AccountController();
		return accountController;
	}
	
	public static BaseController getBaseController() {
		if(baseController == null) baseController = new BaseController();
		return baseController;
	}
	
	public static BranchController getBranchController() {
		if(branchController == null) branchController = new BranchController();
		return branchController;
	}
	
	public static 	BankAccountController getBankAccountController() {
		if(bankAccountController == null) bankAccountController = new BankAccountController();
		return bankAccountController;
	}
	
	public static 	DebitAndPayBillController getDebitAndPayBillController() {
		if(debitAndPayBillController == null) debitAndPayBillController = new DebitAndPayBillController();
		return debitAndPayBillController;
	}
	
	public static 	DebitAndPayBillShowController getDebitAndPayBillShowController() {
		if(debitAndPayBillShowController == null) debitAndPayBillShowController = new DebitAndPayBillShowController();
		return debitAndPayBillShowController;
	}
	
	public static InventoryController getInventoryController() {
		if(inventoryController == null) inventoryController = new InventoryController();
		return inventoryController;
	}
	
	public static OrganizationController getOrganizationController() {
		if(organizationController == null) organizationController = new OrganizationController();
		return organizationController;
	}
	
	public static RecordController getRecordController() {
		if(recordController == null) recordController = new RecordController();
		return recordController;
	}

	public static ReceiptController getReceiptController() {
		if(receiptController == null) receiptController = new ReceiptController();
		return receiptController;
	}
	
	public static OrderController getOrderController(){
		if(orderController == null) orderController = new OrderController();
		return orderController;
	}
	
	public static  PolicyController getPolicyController(){
		if(policyController == null) policyController = new PolicyController();
		return policyController;
	}

	public static TransferController getTransferController() {
		if(transferController == null) transferController = new TransferController();
		return transferController;
	}

	public static LogController getLogController() {
		if(logController == null) logController = new LogController();
		return logController;
	}
}
