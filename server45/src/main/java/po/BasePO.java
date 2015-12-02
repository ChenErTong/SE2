package po;

/**
 * 公司基本晕运营常量，包括职工薪水策略、城市距离、运输单价
 * @author zsq
 * @version Oct 22,2015
 */
public class BasePO extends PersistentObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cityFrom;
	private String cityTo;
	private double distance;
	private double price;
	public BasePO(String id, String cityFrom, String cityTo, double distance, double price) {
		super(id);
		this.cityFrom = cityFrom;
		this.cityTo = cityTo;
		this.distance = distance;
		this.price = price;
	}
	public String getCityFrom() {
		return cityFrom;
	}
	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}
	public String getCityTo() {
		return cityTo;
	}
	public void setCityTo(String cityTo) {
		this.cityTo = cityTo;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BasePO [cityFrom=" + cityFrom + ", cityTo=" + cityTo + ", distance=" + distance + ", price=" + price
				+ ", ID=" + ID + ", date=" + date + "]";
	}
	
	
	
}
