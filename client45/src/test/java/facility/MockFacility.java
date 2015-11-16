package facility;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.facility.Facility;
import dataservice.facilitydataservice.FacilityDataService;
import po.FacilityPO;
import state.ResultMessage;
import vo.FacilityVO;

public class MockFacility extends Facility {
	
	private FacilityDataService facilityData;
	
	public MockFacility() {
		try {
			facilityData = (FacilityDataService)Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/"+FacilityDataService.NAME);
			System.out.println("连接成功！");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ResultMessage addFacility(FacilityVO facility) {
		FacilityPO facilityPO = new FacilityPO(facility.getFacilityIdString(), facility.getDateString(), facility.getManagerId(), facility.getDeliverHistory());
		try {
			facilityData.addFacility(facilityPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public FacilityVO findFacility(String facilityId) {
		FacilityPO facilityPO = null;
		try {
			facilityPO = facilityData.findFacility(facilityId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		FacilityVO vo = new FacilityVO(facilityPO.getManagerId(), facilityPO.getDeliverHistory(), facilityId, facilityPO.getDate());
		return vo;
	}
	public static void main(String[] args) {
		MockFacility mockFacility = new MockFacility();
		ResultMessage resultMessage = mockFacility.addFacility(new FacilityVO("WANG123456", new ArrayList<>(), "DONGFENG157", "2015-10-10"));
		if(resultMessage==ResultMessage.SUCCESS)
			System.out.println("SUCCESS");
		FacilityVO facilityVO = mockFacility.findFacility("DONGFENG157");
		System.out.println(facilityVO.getManagerId());
	}
}
