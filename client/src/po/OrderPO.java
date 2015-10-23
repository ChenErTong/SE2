package po;

import java.util.ArrayList;

/**
 * 订单的单一可持久化对象
 * @author czw
 * @version Oct 23, 2015
 */
public class OrderPO extends PersistentObject{
	/**
	 * 收件人姓名
	 */
	private String recipient_name;
	
	/**
	 * 收件人地址
	 */
	private String recipient_address;
	
	/**
	 * 收件人电话
	 */
	private String recipient_phonenumber;
	
	/**
	 * 寄件人姓名
	 */
	private String sender_name;
	
	/**
	 * 寄件人地址
	 */
	private String sender_address;
	
	/**
	 * 寄件人电话
	 */
	private String sender_phonenumber;
	
	/**
	 * 货物列表
	 */
	private ArrayList<CommodityPO> commodities;
	
	/**
	 * 运送途径地点
	 */
	private ArrayList<String> path;
	
	/**
	 * 寄件时间
	 */
	private String send_time;
	
	/**
	 * 收件时间
	 */
	private String receive_time;
	
	/**
	 * 费用
	 */
	private double cost;
	
	public OrderPO(String id, String recipient_name, String recipient_address,
			String recipient_phonenumber, String sender_name,
			String sender_address, String sender_phonenumber,
			ArrayList<CommodityPO> commodities, ArrayList<String> path,
			String send_time, String receive_time, double cost) {
		super(id);
		this.recipient_name = recipient_name;
		this.recipient_address = recipient_address;
		this.recipient_phonenumber = recipient_phonenumber;
		this.sender_name = sender_name;
		this.sender_address = sender_address;
		this.sender_phonenumber = sender_phonenumber;
		this.commodities = commodities;
		this.path = path;
		this.send_time = send_time;
		this.receive_time = receive_time;
		this.cost = cost;
	}

	public String getRecipient_name() {
		return recipient_name;
	}

	public String getRecipient_address() {
		return recipient_address;
	}

	public String getRecipient_phonenumber() {
		return recipient_phonenumber;
	}

	public String getSender_name() {
		return sender_name;
	}

	public String getSender_address() {
		return sender_address;
	}

	public String getSender_phonenumber() {
		return sender_phonenumber;
	}

	public ArrayList<CommodityPO> getCommodities() {
		return commodities;
	}

	public ArrayList<String> getPath() {
		return path;
	}

	public String getSend_time() {
		return send_time;
	}

	public String getReceive_time() {
		return receive_time;
	}

	public double getCost() {
		return cost;
	}	
}