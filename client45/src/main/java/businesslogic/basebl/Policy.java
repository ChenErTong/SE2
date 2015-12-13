package businesslogic.basebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.CommonBusinessLogic;
import config.RMIConfig;
import dataservice.basedataservice.PolicyDataService;
import po.PolicyPO;
import state.ResultMessage;
import vo.PolicyVO;

/**
 * 公司员工薪水策略管理
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:32:56
 */
public class Policy implements CommonBusinessLogic<PolicyPO>{
	public  final static String BLNAME="Policy";
	private PolicyDataService policyData;
	public Policy() throws MalformedURLException, RemoteException, NotBoundException {
		
		policyData = (PolicyDataService) Naming.lookup(RMIConfig.PREFIX + PolicyDataService.NAME);
	}

	public String getID() throws RemoteException {
		return policyData.getID();
	}

	public ResultMessage add(PolicyPO po) throws RemoteException {
		return policyData.add(po);
	}

	public PolicyPO delete(String ID) throws RemoteException {
		return policyData.delete(ID);
	}

	public PolicyPO modify(PolicyPO po) throws RemoteException {
		return policyData.modify(po);
	}

	public ArrayList<PolicyVO> show() throws RemoteException {
		ArrayList<PolicyPO> pos = policyData.find();
		ArrayList<PolicyVO> vos = BaseTrans.convertPolicyPOstoVOs(pos);
		return vos;
	}

	public PolicyVO find(String id) throws RemoteException {
		ArrayList<PolicyPO> pos = policyData.find();
		for (PolicyPO basePO : pos) {
			if (basePO.getID().equals(id))
				return BaseTrans.convertPOtoVO(basePO);
		}
		return null;
	}
}
