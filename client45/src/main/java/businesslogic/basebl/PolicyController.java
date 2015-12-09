package businesslogic.basebl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
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

	Policy policyBL;

	public PolicyController() throws MalformedURLException, RemoteException, NotBoundException {
		policyBL = new Policy();
	}

	/**
	 * @see PolicyBLService#getID()
	 */
	public String getID() throws RemoteException {
		return policyBL.getID();
	}

	/**
	 * @see PolicyBLService#addPolicy(PolicyVO)
	 */
	public ResultMessage addPolicy(PolicyVO vo) throws RemoteException {
		return policyBL.addBase(vo);
	}

	/**
	 * @see PolicyBLService#deletePolicy(String)
	 */
	public ResultMessage deletePolicy(String ID) throws RemoteException {
		return policyBL.deleteBase(ID);
	}

	/**
	 * @see PolicyBLService#updatePolicy(PolicyVO)
	 */
	public ResultMessage updatePolicy(PolicyVO vo) throws RemoteException {
		return policyBL.updateBase(vo);
	}

	/**
	 * @see PolicyBLService#show()
	 */
	public ArrayList<PolicyVO> show() throws RemoteException {
		return policyBL.show();
	}

	/**
	 * @see PolicyBLService#find(String)
	 */
	public PolicyVO find(String id) throws RemoteException {
		return policyBL.find(id);
	}

}
