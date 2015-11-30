package state;

public enum CommodityState {
	Complete("完整"),
	Demaged("损坏"),
	Lost("丢失");
	public String value;
	CommodityState(String value){
		this.value = value;
	}
	
	public static CommodityState getType(String value){
		switch(value){
		case "完整": return Complete;
		case "损坏": return Demaged;
		default: return Lost;
		}
	}
}
