package po;

import state.OrganizationType;

/**
 * ������ĸ��࣬�����ĸ��������ԣ�������ţ�����ʱ�䣬Ա��������������ַ
 * @author zsq
 * @version Oct 22,2015
 */
public class OrganizationPO extends PersistentObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2620692444650564758L;
	/** serialVersionUID*/
	/**�������*/
	protected String organizationID;
	
	protected int numberOfPerson;
	/**������ַ*/
	protected String address;
	
	protected OrganizationType organizationType;
	
	public OrganizationPO(String organizationID,String address,int numberOfPerson,OrganizationType organizationType){
		super(organizationID);
		this.organizationID = organizationID;
		this.address = address;
		this.numberOfPerson=numberOfPerson;
		this.organizationType=organizationType;
	}
	public String getOrganizationID() {
		return organizationID;
	}
	public void setOrganizationID(String organizationID) {
		this.organizationID = organizationID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public int getNumberOfPerson() {
		return numberOfPerson;
	}
	public OrganizationType getOrganizationType() {
		return organizationType;
	}

}
