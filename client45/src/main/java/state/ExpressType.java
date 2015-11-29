package state;

public enum ExpressType {
	Car("汽车",10),
	Train("火车",7),
	Plane("飞机",3);
	
	@SuppressWarnings("unused")
	private String value;
	public double speed;
	
	private ExpressType(String value,double speed){
		this.value = value;
		this.speed=speed;
	}
	
	public static ExpressType getType(String value){
		switch(value){
		case "汽车": return Car;
		case "火车": return Train;
		default: return Plane;
		}
	}
}