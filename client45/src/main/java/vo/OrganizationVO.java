package vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import state.OrganizationType;

public class OrganizationVO {
	public String organizationID;
	/**����ʱ�䣬ϵͳ�Զ�����*/
	public String date;
	/**Ա������*/
	public int number;
	/**������ַ*/
	public String address;
	public OrganizationType organizationType;
	public OrganizationVO(String organizationID,String address,int number,OrganizationType organizationType){

		this.organizationID = organizationID;
		this.address = address;
		this.number = number;
		this.organizationType=organizationType;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm");
		date = sdf.format(new Date());
	}

}
