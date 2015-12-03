package businesslogic.basebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.baseblservice.PolicyBLService;
import state.ResultMessage;
import vo.PolicyVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:32:59
 */
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
