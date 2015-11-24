package po;

import java.text.SimpleDateFormat;
import java.util.Date;

import state.OrganizationType;
import state.ReceiptType;

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
	/**����ʱ�䣬ϵͳ�Զ�����*/
	protected String date;
	
	protected int numberOfPerson;
	/**������ַ*/
	protected String address;
	
	protected OrganizationType organizationType;
	
	public OrganizationPO(String organizationID,ReceiptType type,String address,int numberOfPerson,OrganizationType organizationType){
		super(organizationID, type);
		this.organizationID = organizationID;
		this.address = address;
		this.numberOfPerson=numberOfPerson;
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
