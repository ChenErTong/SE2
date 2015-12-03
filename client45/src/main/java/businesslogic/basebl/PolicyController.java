package businesslogic.basebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.baseblservice.PolicyBLService;
import state.ResultMessage;
import vo.PolicyVO;

public class PolicyController implements PolicyBLService {
	
	Policy policyBL = new Policy();
	@Override
	public String getID() {
		try {
			return policyBL.getID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage addBase(PolicyVO vo) {
		try {
			return policyBL.addBase(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage deleteBase(String ID) {
		try {
			return policyBL.deleteBase(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage updateBase(PolicyVO vo) {
		try {
			return policyBL.updateBase(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<PolicyVO> show() {
		try {
			return policyBL.show();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PolicyVO find(String id) {
		try {
			return policyBL.find(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
