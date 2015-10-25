package vo;

import state.CommodityState;

public class CommodityVO {
	private String commodityType;
	private double weight;
	private double volumn;
	private CommodityState commodityState;
	
	public CommodityVO(String commodityType, double weight, double volumn, CommodityState commodityState) {
		this.commodityType = commodityType;
		this.weight = weight;
		this.volumn = volumn;
		this.commodityState = commodityState;
	}

	public String getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getVolumn() {
		return volumn;
	}

	public void setVolumn(double volumn) {
		this.volumn = volumn;
	}

	public CommodityState getCommodityState() {
		return commodityState;
	}

	public void setCommodityState(CommodityState commodityState) {
		this.commodityState = commodityState;
	}
}
