package server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import config.RMIConfig;

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
			String prefix = "rmi://" + hostAddr + ":" + RMIConfig.PORT + "/";
			addr = InetAddress.getLocalHost();
			hostAddr = addr.getHostAddress();
			hostName = addr.getHostName();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
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
	}
}
