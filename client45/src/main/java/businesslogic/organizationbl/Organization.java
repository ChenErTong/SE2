package businesslogic.organizationbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.orderdataservice.OrderDataService;
import dataservice.organizationdataservice.OrganizationDataService;
import po.OrganizationPO;

public class Organization {
	private OrganizationDataService<OrganizationPO> organizationData;

	@SuppressWarnings("unchecked")
	public Organization() {
		try {
			organizationData = (OrganizationDataService<OrganizationPO>) Naming
					.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/" + OrganizationDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
