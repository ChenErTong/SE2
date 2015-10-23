package po;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 机构类的父类，定义四个基本属性：机构编号，成立时间，员工数量，机构地址
 * @author zsq
 * @version Oct 22,2015
 */
public class OrganizationPO extends PersistentObject{

	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	/**机构编号*/
	protected String organizationID;
	/**成立时间，系统自动生成*/
	protected String date;
	/**员工数量*/
	protected double number;
	/**机构地址*/
	protected String address;
	
	public OrganizationPO(String organizationID,String address,double number){
		this.organizationID = organizationID;
		this.address = address;
		this.number = number;
		/**自动生成日期*/
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
