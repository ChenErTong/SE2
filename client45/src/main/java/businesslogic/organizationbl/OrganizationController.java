package businesslogic.organizationbl;

import java.util.ArrayList;

import businesslogicservice.organizationblservice.OrganizationBLService;
import state.ResultMessage;
import vo.OrganizationVO;

public class OrganizationController implements OrganizationBLService {
	
	Organization organization = new Organization();
	@Override
	public ArrayList<OrganizationVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addOrganization(OrganizationVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteOrganization(String organizationID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateOrganization(OrganizationVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
