package po;

import state.CommodityState;

/**
 * 货物单一可持续化对象
 * @author czw
 * @version Oct 23, 2015
 */
public class CommodityPO extends PersistentObject{
	/**
	 * 商品种类
	 */
	private String kind;
	
	/**
	 * 商品重量
	 */
	private double weight;
	
	/**
	 * 商品体积
	 */
	private double volume;
	
	/**
	 * 商品状态（完整、损坏、丢失）
	 */
	private CommodityState condition;
	
	public CommodityPO(String kind, double weight, double volume, CommodityState condition) {
		super(null);
		this.kind = kind;
		this.volume = volume;
		//如果是比较轻，体积较大的货物，按照长*宽*高/5000来计算其体积重量，和实际重量取最大值
		this.weight = Double.max(weight, this.volume / 5000);
		this.condition = condition;
	}

	public String getKind() {
		return kind;
	}

	public double getWeight() {
		return weight;
	}

	public double getVolume() {
		return volume;
	}

	public CommodityState getCondition() {
		return condition;
	}
}
