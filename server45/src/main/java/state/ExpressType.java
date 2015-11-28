package state;

public enum ExpressType {
	Car("汽车"),
	Train("火车"),
	Plane("飞机");
	
	public final String value;
	
	ExpressType(String value){
		this.value = value;
	}
}