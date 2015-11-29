package businesslogic.orderbl;

import java.rmi.RemoteException;

public interface BaseInfo_Order {
	public String getArrialDateByCities(String cityFrom,String cityTo,String begindate,double transSpeed) throws RemoteException;
}
