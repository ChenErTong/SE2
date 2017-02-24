package state;
/**
 * 快递包装类型
 * @author czw
 * @time 2015年11月27日下午8:50:55
 */
public enum PackageType {
	Paper("纸盒"),
	Plastic("塑料"),
	Bubble("泡沫"),
	Metal("金属");
	
	public String value;
	
	PackageType(String value){
		this.value = value;
	}
	
	public static PackageType getType(String value){
		switch(value){
		case "纸盒": return Paper;
		case "塑料": return Plastic;
		case "金属":return Metal;
		default: return Bubble;
		}
	}
}