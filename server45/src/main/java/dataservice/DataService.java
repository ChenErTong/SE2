package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DataService<T> extends Remote{
	public void initialFile() throws RemoteException;
}
