package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DataService extends Remote{
	public void initialFile() throws RemoteException;
}
