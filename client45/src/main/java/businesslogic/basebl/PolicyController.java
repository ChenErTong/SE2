package businesslogic.basebl;

import java.util.ArrayList;

import businesslogicservice.baseblservice.PolicyBLService;
import state.ResultMessage;
import vo.PolicyVO;

public class PolicyController implements PolicyBLService {
	
	Policy policyBL = new Policy();
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addBase(PolicyVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteBase(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateBase(PolicyVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PolicyVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PolicyVO find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
