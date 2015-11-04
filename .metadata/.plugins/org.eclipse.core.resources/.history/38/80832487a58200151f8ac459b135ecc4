package po;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ������ĸ��࣬�����ĸ��������ԣ�������ţ�����ʱ�䣬Ա��������������ַ
 * @author zsq
 * @version Oct 22,2015
 */
public class OrganizationPO extends PersistentObject{

	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	/**�������*/
	protected String organizationID;
	/**����ʱ�䣬ϵͳ�Զ�����*/
	protected String date;
	/**Ա������*/
	protected double number;
	/**������ַ*/
	protected String address;
	
	public OrganizationPO(String organizationID,String address,double number){
		super(organizationID);
		this.organizationID = organizationID;
		this.address = address;
		this.number = number;
		/**�Զ���������*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm");
		date = sdf.format(new Date());
	}
	public String getOrganizationID() {
		return organizationID;
	}
	public void setOrganizationID(String organizationID) {
		this.organizationID = organizationID;
	}
	public double getNumber() {
		return number;
	}
	public void setNumber(double number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
