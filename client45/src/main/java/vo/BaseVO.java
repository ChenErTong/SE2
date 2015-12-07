package vo;

import java.math.BigDecimal;

public class BaseVO extends ValueObject{
	public String cityFrom;
	public String cityTo;
	
	public BigDecimal distance;
	public BigDecimal price;
	
	public BaseVO(String iD, String cityFrom, String cityTo, BigDecimal distance, BigDecimal price) {
		super(iD);
		this.cityFrom = cityFrom;
		this.cityTo = cityTo;
		this.distance = distance;
		this.price = price;
	}
	

}
