package po;

import java.util.ArrayList;

import state.SalaryPolicy;

/**
 * 公司基本晕运营常量，包括职工薪水策略、城市距离、运输单价
 * @author zsq
 * @version Oct 22,2015
 */
public class BasePO extends PersistentObject{

	public BasePO(String iD, String date) {
		super(iD, date);
		// TODO Auto-generated constructor stub
	}
	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	/**城市距离，ArrayList里存放的类型应该能代表两个不同的城市*/
	private ArrayList<Double> distances;
	/**运输单价，ArrayList存放顺序与城市距离对应*/
	private ArrayList<Double> price;
	/**薪水策略，根据不同的职工采用不同的策略*/
	private ArrayList<SalaryPolicy> salaryPolicies;
	public ArrayList<Double> getDistances() {
		return distances;
	}
	public void setDistances(ArrayList<Double> distances) {
		this.distances = distances;
	}
	public ArrayList<Double> getPrice() {
		return price;
	}
	public void setPrice(ArrayList<Double> price) {
		this.price = price;
	}
	public ArrayList<SalaryPolicy> getSalaryPolicies() {
		return salaryPolicies;
	}
	public void setSalaryPolicies(ArrayList<SalaryPolicy> salaryPolicies) {
		this.salaryPolicies = salaryPolicies;
	}
	
}
