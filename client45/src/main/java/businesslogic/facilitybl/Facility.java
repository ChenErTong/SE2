package businesslogic.facilitybl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import config.RMIConfig;
import dataservice.facilitydataservice.FacilityDataService;
import po.FacilityPO;
import state.ConfirmState;
import state.ResultMessage;
import vo.FacilityVO;

public class Facility {
	private FacilityDataService facilityData;

	public Facility() {

		try {
			// Registry registry = LocateRegistry.getRegistry("127.0.0.1", 8888,
			// new RMIClientSocketFactory() {
			// @Override
			// public Socket createSocket(String host, int port) throws
			// IOException {
			// Socket socket = new Socket();
			// socket.connect(new InetSocketAddress(host, port), 2000);
			// return socket;
			// }
			// }); // registry最好是全局一个的（一个IP对应一个registry，也可以是多个，这个只是建议）
			// facilityData = (FacilityDataService)
			// registry.lookup(FacilityDataService.NAME);
			// System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			facilityData = (FacilityDataService) Naming
					.lookup(RMIConfig.PREFIX + FacilityDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}

	public ResultMessage addFacility(FacilityVO facility) throws RemoteException {
		FacilityPO facilityPO = FacilityTrans.convertVOtoPO(facility);
		return facilityData.add(facilityPO);
	}

	public FacilityVO findFacility(String ID) throws RemoteException {
		FacilityPO facilityPO = facilityData.find(ID);
		FacilityVO facilityVO = FacilityTrans.convertPOtoVO(facilityPO);
		return facilityVO;
	}

	public ArrayList<FacilityVO> findFacility() throws RemoteException {
		ArrayList<FacilityPO> facilityPOs = facilityData.find();
		ArrayList<FacilityVO> facilityVOs = FacilityTrans.convertFacilityPOstoVOs(facilityPOs);
		return facilityVOs;
	}

	public ResultMessage modifyFacility(FacilityVO facility) throws RemoteException {
		FacilityPO facilityPO = FacilityTrans.convertVOtoPO(facility);
		return facilityData.modify(facilityPO);
	}

	public ResultMessage deleteFacility(FacilityVO facility) throws RemoteException {
		return facilityData.delete(facility.getFacilityIdString());
	}

}
