package vo;

import java.util.ArrayList;

import state.SalaryPolicy;

public class BaseVO {
	public BaseVO() {
	
	}
	
	/**城市距离，ArrayList里存放的类型应该能代表两个不同的城市*/
	private ArrayList<Double> distances;
	/**运输单价，ArrayList存放顺序与城市距离对应*/
	private ArrayList<Double> price;
	/**薪水策略，根据不同的职工采用不同的策略*/
	private ArrayList<SalaryPolicy> salaryPolicies;
	public ArrayList<Double> getDistances() {
		return distances;
	}
	
	public ArrayList<Double> getPrice() {
		return price;
	}
	
	public ArrayList<SalaryPolicy> getSalaryPolicies() {
		return salaryPolicies;
	}
	
}
