package data;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.DataService;
import po.PersistentObject;

public class Data  extends UnicastRemoteObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Data() throws RemoteException {
	}

}
