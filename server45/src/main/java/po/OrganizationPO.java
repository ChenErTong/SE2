package po;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zsq
 * @version Oct 22,2015
 */
public class OrganizationPO extends PersistentObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2620692444650564758L;
	/** serialVersionUID*/
	protected String organizationID;
	protected String date;
	protected String address;
	protected int numberOfPerson;
	
	public OrganizationPO(String organizationID,String address,int numberOfPerson){
		super(organizationID);
		this.organizationID = organizationID;
		this.address = address;
		this.numberOfPerson=numberOfPerson;
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

}
