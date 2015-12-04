package state;

public enum ExpressType {
	Car("汽车",10,18),
	Train("火车",7,23),
	Plane("飞机",3,25);
	
	public String value;
	public double speed;
	public double priceConstant;
	
	private ExpressType(String value,double speed,double priceConstant){
		this.value = value;
		this.speed=speed;
		this.priceConstant = priceConstant;
	}
	
	public static ExpressType getType(String value){
		switch(value){
		case "汽车": return Car;
		case "火车": return Train;
		default: return Plane;
		}
	}
}