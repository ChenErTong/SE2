package po;

import java.math.BigDecimal;

import state.CommodityState;

public class CommodityPO  extends PersistentObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String commodityType;
	private BigDecimal weight;
	private BigDecimal volumn;
	private CommodityState commodityState;
	
	public CommodityPO(String commodityType, BigDecimal weight, BigDecimal volumn, CommodityState commodityState) {
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

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getVolumn() {
		return volumn;
	}

	public void setVolumn(BigDecimal volumn) {
		this.volumn = volumn;
	}

	public CommodityState getCommodityState() {
		return commodityState;
	}

	public void setCommodityState(CommodityState commodityState) {
		this.commodityState = commodityState;
	}
	
	
}

