package organization;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import state.ResultMessage;
import vo.OrganizationVO;
import businesslogic.organization.Organization;

public class MockOrganization extends Organization{
	protected String organizationID;

	protected String date;

	protected double number;

	protected String address;
	
	public MockOrganization(String organizationID,String address,double number){

		this.organizationID = organizationID;
		this.address = address;
		this.number = number;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm");
		date = sdf.format(new Date());
	}
	
	public ArrayList<OrganizationVO> show() {
		return null;
	}
	
	public String getID() {
		return null;
	}

	public ResultMessage addOrganization(OrganizationVO vo) {
		return null;
	}
	
	public ResultMessage deleteOrganization(String organizationID) {
		return null;
	}
	
	public ResultMessage updateOrganization(OrganizationVO vo) {
		return null;
	}
}
