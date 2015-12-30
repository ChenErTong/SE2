package vo;

import java.math.BigDecimal;

import state.CommodityState;

public class CommodityVO extends ValueObject{
	public String commodityType;
	public BigDecimal weight;
	public BigDecimal volumn;
	public boolean inStock;
	public CommodityState commodityState;
	public String orderID;
	
	public CommodityVO(String commodityType, BigDecimal weight, BigDecimal volumn, CommodityState commodityState,boolean inStock,String orderID) {
		this.commodityType = commodityType;
		this.weight = weight;
		this.volumn = volumn;
		this.commodityState = commodityState;
		this.inStock=inStock;
		this.orderID=orderID;
	}
	/**
	 * 进行重量矫正
	 */
	public void correctWeight(){
		BigDecimal weight = volumn.divide(new BigDecimal(5000));
		this.weight = this.weight.compareTo(weight)>0?this.weight:weight;
	}
	@Override
	public String toString() {
		return " commodityType=" + commodityType + ", weight=" + weight + ", volumn=" + volumn + ", commodityState="
				+ commodityState;
	}
	
	/**
	 * 为每个货物加上订单id属性
	 * @param id
	 */
	public void setOrderID(String id){
		this.ID = id;
	}
}