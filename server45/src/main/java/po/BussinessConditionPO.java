package po;

/**
 * @author lxl
 * @version Oct 23,2015
 **/

public class BussinessConditionPO extends PersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public String begin;
	public String end;
	public double totalIncome;
	public double totalExpen;
	public double profit;

	public BussinessConditionPO(String id, String begin, String end, double totalIncome, double totalExpen,
			double profit) {
		super(id);
		this.begin = begin;
		this.end = end;
		this.totalIncome = totalIncome;
		this.totalExpen = totalExpen;
		this.profit = profit;
	}

}
