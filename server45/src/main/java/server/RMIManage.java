package server;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import config.RMIConfig;
import data.DataFactory;
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

public class RMIManage {
	private Remote reg;
	private InetAddress addr;
	private String hostAddr;
	private String hostName;

	public RMIManage() {
		try {
			addr = InetAddress.getLocalHost();
			hostAddr = addr.getHostAddress();
			hostName = addr.getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void startServer() {

		try {
			// 本地主机上的远程对象注册表Registry的实例，并指定端口为port
			// 这一步必不可少（Java默认端口是1099），必不可缺的一步，缺少注册表创建，则无法绑定对象到远程注册表上
			reg = LocateRegistry.createRegistry(RMIConfig.PORT);
			String prefix=RMIConfig.PREFIX;
			/*String prefix = "rmi://" + hostAddr + ":" + RMIConfig.PORT + "/";*/
			addr = InetAddress.getLocalHost();
			hostAddr = addr.getHostAddress();
			hostName = addr.getHostName();
			
			//注册Data类
			Naming.bind(prefix+AccountData.NAME, DataFactory.createDataService(AccountData.NAME));
			Naming.bind(prefix+BaseData.NAME, DataFactory.createDataService(BaseData.NAME));
			Naming.bind(prefix+BranchData.NAME, DataFactory.createDataService(BranchData.NAME));
			Naming.bind(prefix+FacilityData.NAME, DataFactory.createDataService(FacilityData.NAME));
			Naming.bind(prefix+DebitAndPayBillData.NAME, DataFactory.createDataService(DebitAndPayBillData.NAME));
			Naming.bind(prefix+BankAccountData.NAME, DataFactory.createDataService(BankAccountData.NAME));
			Naming.bind(prefix+ExpenseData.NAME, DataFactory.createDataService(ExpenseData.NAME));
			Naming.bind(prefix+InventoryData.NAME, DataFactory.createDataService(InventoryData.NAME));
			Naming.bind(prefix+OpeningStockData.NAME, DataFactory.createDataService(OpeningStockData.NAME));
			Naming.bind(prefix+ReceiptData.NAME, DataFactory.createDataService(ReceiptData.NAME));
			Naming.bind(prefix+RecordData.NAME, DataFactory.createDataService(RecordData.NAME));
			Naming.bind(prefix+TransferData.NAME, DataFactory.createDataService(TransferData.NAME));
			Naming.bind(prefix+UserData.NAME, DataFactory.createDataService(UserData.NAME));
			
			System.out.println("注册完成！");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}

	}

	public void stopServer() {
		try {
			UnicastRemoteObject.unexportObject(reg, true);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public String getHostAddr() {
		return hostAddr;
	}

	public String getHostName() {
		return hostName;
	}

	public static void main(String[] args) {
		// InetAddress addr;
		// String hostAddr = null;
		// String hostName = null;
		// try {
		// addr = InetAddress.getLocalHost();
		// hostAddr = addr.getHostAddress();
		// hostName = addr.getHostName();
		// } catch (UnknownHostException e) {
		// e.printStackTrace();
		// }
		// System.out.println(hostAddr);
		// System.out.println(hostName);
		RMIManage rmiManage = new RMIManage();
		rmiManage.startServer();
	}
}
