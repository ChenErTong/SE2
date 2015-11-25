package organization;

import java.util.ArrayList;

import businesslogic.organizationbl.Organization;
import state.ResultMessage;
import vo.OrganizationVO;

public class MockOrganization extends Organization{
	protected String organizationID;

	protected String date;

	protected double number;

	protected String address;
	
	/*public MockOrganization(String organizationID,String address,double number){

		this.organizationID = organizationID;
		this.address = address;
		this.number = number;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm");
		date = sdf.format(new Date());
	}*/
	
	public ArrayList<OrganizationVO> show(ArrayList<OrganizationVO> vos) {
		return vos;
	}
	
	public String getID() {
		return "123";
	}

	public ResultMessage addOrganization(OrganizationVO vo) {
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage deleteOrganization(String organizationID) {
		return ResultMessage.FAIL;
	}
	
	public ResultMessage updateOrganization(OrganizationVO vo) {
		return ResultMessage.WAIT;
	}
}
