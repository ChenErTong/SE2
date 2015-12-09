package organization;
import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;




import org.junit.Test;

import state.OrganizationType;
import state.ResultMessage;
import vo.OrganizationVO;


public class TestOrganization {
	@Test
	public void testOrganization() {
		MockOrganization mockOrganization = null;
		try {
			mockOrganization = new MockOrganization();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		OrganizationVO vo1 = new OrganizationVO("123", "南京市栖霞区九乡河东路163号", 8,OrganizationType.BRANCH);
		OrganizationVO vo2 = new OrganizationVO("456","南京市鼓楼校区南京大学鼓楼校区",10,OrganizationType.BRANCH);
		//ArrayList<OrganizationVO> organizations;
		ArrayList<OrganizationVO> organizations = new ArrayList<OrganizationVO>();
		organizations.add(vo1);
		organizations.add(vo2);
		mockOrganization.show(organizations);
		
		mockOrganization.addOrganization(vo1);
		mockOrganization.addOrganization(vo2);
		mockOrganization.deleteOrganization(vo1.organizationID);
		mockOrganization.updateOrganization(vo2);
		assertEquals(organizations,mockOrganization.show(organizations));
		assertEquals(ResultMessage.SUCCESS,mockOrganization.addOrganization(vo1));
		assertEquals(ResultMessage.WAIT,mockOrganization.updateOrganization(vo2));
		assertEquals(ResultMessage.FAIL,mockOrganization.deleteOrganization(vo1.organizationID));
	}

	
}

