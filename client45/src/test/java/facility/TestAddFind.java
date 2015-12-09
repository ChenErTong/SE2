package facility;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Test;

public class TestAddFind {

	@Test
	public void testAddFind() {
		try {
			new MockFacility();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
//		mockFacility.addFacility(new FacilityVO("WANG123456", new ArrayList<>(), "DONGFENG157", "2015-10-10"));
//		FacilityVO facilityVO = mockFacility.findFacility("DONGFENG157");
//		System.out.println(facilityVO.getManagerId());
//		mockFacility.modifyFacility(new FacilityVO("SBWOGAILE123456", new ArrayList<>(), "DONGFENG157", "2015-10-10"));
//		FacilityVO facilityVOKAI = mockFacility.findFacility("DONGFENG157");
//		System.out.println(facilityVOKAI.getManagerId());
//		mockFacility.deleteFacility(new FacilityVO("SBWOGAILE123456", new ArrayList<>(), "DONGFENG157", "2015-10-10"));
//		FacilityVO facilityVOKAIKAI = mockFacility.findFacility("DONGFENG157");
//		System.out.println(facilityVOKAIKAI==null);
	}

}
