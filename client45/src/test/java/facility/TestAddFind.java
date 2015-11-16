package facility;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import vo.FacilityVO;

public class TestAddFind {

	@Test
	public void testAddFind() {
		MockFacility mockFacility = new MockFacility();
		mockFacility.addFacility(new FacilityVO("WANG123456", new ArrayList<>(), "DONGFENG157", "2015-10-10"));
		FacilityVO facilityVO = mockFacility.findFacility("DONGFENG157");
		System.out.println(facilityVO.getManagerId());
	}

}
