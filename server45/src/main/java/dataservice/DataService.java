package dataservice;

import java.rmi.Remote;

public interface DataService<T> extends Remote{
	public void initialFile();
}
