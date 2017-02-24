package state;

import java.math.BigDecimal;

public enum ExpressType {
	Car("汽车",new BigDecimal(10),new BigDecimal(18)),
	Train("火车",new BigDecimal(7),new BigDecimal(23)),
	Plane("飞机",new BigDecimal(3),new BigDecimal(25));
	
	public String value;
	public BigDecimal speed;
	public BigDecimal priceConstant;
	
	private ExpressType(String value,BigDecimal speed,BigDecimal priceConstant){
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