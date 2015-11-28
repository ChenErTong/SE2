package vo;

import state.CommodityState;

public class CommodityVO {
	public String commodityType;
	public double weight;
	public double volumn;
	public CommodityState commodityState;
	
	public CommodityVO(String commodityType, double weight, double volumn, CommodityState commodityState) {
		this.commodityType = commodityType;
		this.weight = weight;
		this.volumn = volumn;
		this.commodityState = commodityState;
	}
	/**
	 * 进行重量矫正
	 */
	public void correctWeight(){
		double weight = volumn / 5000;
		this.weight = Double.max(this.weight, weight);
	}
}
