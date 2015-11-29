package state;

public enum ExpressType {
	Car("汽车"),
	Train("火车"),
	Plane("飞机");
	
	@SuppressWarnings("unused")
	private String value;
	
	private ExpressType(String value){
		this.value = value;
	}
	
	public static ExpressType getType(String value){
		switch(value){
		case "汽车": return Car;
		case "火车": return Train;
		default: return Plane;
		}
	}
}