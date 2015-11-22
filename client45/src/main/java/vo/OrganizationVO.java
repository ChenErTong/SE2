package vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import state.OrganizationType;

public class OrganizationVO {
	protected String organizationID;
	/**����ʱ�䣬ϵͳ�Զ�����*/
	protected String date;
	/**Ա������*/
	protected int number;
	/**������ַ*/
	protected String address;
	protected OrganizationType organizationType;
	public OrganizationVO(String organizationID,String address,int number,OrganizationType organizationType){

		this.organizationID = organizationID;
		this.address = address;
		this.number = number;
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm");
		date = sdf.format(new Date());
	}
	public String getOrganizationID() {
		return organizationID;
	}
	
	public double getNumber() {
		return number;
	}
	
	public String getAddress() {
		return address;
	}
	

}
