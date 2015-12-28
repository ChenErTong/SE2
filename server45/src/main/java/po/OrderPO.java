package po;

import java.math.BigDecimal;
import java.util.ArrayList;

import po.receiptpo.ReceiptPO;
import state.ExpressType;
import state.OrderState;
import state.PackageType;
import state.ReceiptState;
import state.ReceiptType;

/**
 * 订单的PO类， 包括订单号、收件人（寄件人）姓名、收件人（寄件人）住址、 收件人（寄件人）电话、收件人（寄件人）单位、 货物集合信息、订单运送途径地点、
 * 派件时间、收件时间、费用， 费用格式必须是大于等于0、精确到小数点后1为的浮点数，单位是元。
 * 
 * @author Ann
 *
 */
public class OrderPO extends ReceiptPO {

	protected OrderPO(String id,ReceiptType type) {
		super(id,type);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	// 订单号
//	private String orderIdString;
	private OrderState orderstate;
	// 寄件人姓名、寄件人住址、
	// 寄件人电话、寄件人单位
	private String senderName;
	private String senderAddress;
	private String senderTel;
	private String senderCo;
	// 收件人姓名、收件人住址、
	// 收件人电话、收件人单位
	private String recipientName;
	private String recipientAddress;
	private String recipientTel;
	private String recipientCo;
	// 货物集合信息
	private ArrayList<CommodityPO> commodityPO;
	// 订单运送途径地点
	private ArrayList<String> midAddres;
	// 派件时间、收件时间
	private String sendTime;
	private String recipientTime;
	// 费用
	private BigDecimal money;
	private ReceiptState state;
	// 包装类型
	private PackageType packType;
	// 快递类型
	private ExpressType express;

	public OrderPO(String orderIdString, ReceiptType type,String senderName, String senderAddress, String senderTel,
			String senderCo, String recipientName, String recipientAddress, String recipientTel, String recipientCo,
			ArrayList<CommodityPO> commodityPO, ArrayList<String> midAddres, String sendTime, String recipientTime, BigDecimal money, PackageType packType,ExpressType express) {
		super(orderIdString,type);
		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.senderTel = senderTel;
		this.senderCo = senderCo;
		this.recipientName = recipientName;
		this.recipientAddress = recipientAddress;
		this.recipientTel = recipientTel;
		this.recipientCo = recipientCo;
		this.commodityPO = commodityPO;
		this.midAddres = midAddres;
		this.sendTime = sendTime;
		this.recipientTime = recipientTime;
		this.money = money;
		this.packType=packType;
		this.express=express;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getSenderTel() {
		return senderTel;
	}

	public void setSenderTel(String senderTel) {
		this.senderTel = senderTel;
	}

	public String getSenderCo() {
		return senderCo;
	}

	public void setSenderCo(String senderCo) {
		this.senderCo = senderCo;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientAddress() {
		return recipientAddress;
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}

	public String getRecipientTel() {
		return recipientTel;
	}

	public void setRecipientTel(String recipientTel) {
		this.recipientTel = recipientTel;
	}

	public String getRecipientCo() {
		return recipientCo;
	}

	public void setRecipientCo(String recipientCo) {
		this.recipientCo = recipientCo;
	}


	public ArrayList<CommodityPO> getCommodityPO() {
		return commodityPO;
	}


	public ArrayList<String> getMidAddres() {
		return midAddres;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getRecipientTime() {
		return recipientTime;
	}

	public void setRecipientTime(String recipientTime) {
		this.recipientTime = recipientTime;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
	public  ReceiptState getState() {
		return state;
	}

	public  void setState(ReceiptState state) {
		this.state = state;
	}

	public void setCommodityPO(ArrayList<CommodityPO> commodityPO) {
		this.commodityPO = commodityPO;
	}

	public void setMidAddres(ArrayList<String> midAddres) {
		this.midAddres = midAddres;
	}
	
	public PackageType getPackType() {
		return packType;
	}

	public ExpressType getExpress() {
		return express;
	}

	public OrderState getOrderstate() {
		return orderstate;
	}

	public void setOrderstate(OrderState orderstate) {
		this.orderstate = orderstate;
	}

}
