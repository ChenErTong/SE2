package record;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.recordbl.Record;

public class MockBussinessCondition extends Record{

	public MockBussinessCondition( String endDate) throws MalformedURLException, RemoteException, NotBoundException {
		super();
	}
}
