package vo;

public class BaseVO extends ValueObject{
	public String cityFrom;
	public String cityTo;
	public double distance;
	public double price;
	
	public BaseVO(String iD, String cityFrom, String cityTo, double distance, double price) {
		super(iD);
		this.cityFrom = cityFrom;
		this.cityTo = cityTo;
		this.distance = distance;
		this.price = price;
	}
	

}
