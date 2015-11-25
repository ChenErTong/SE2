package vo;

import java.util.ArrayList;
import state.SalaryPolicy;

public class BaseVO {

	public BaseVO(String id, ArrayList<Double> distances, ArrayList<Double> price,
			ArrayList<SalaryPolicy> salaryPolicies) {
		this.id = id;
		this.distances = distances;
		this.price = price;
		this.salaryPolicies = salaryPolicies;
	}

	public String id;
	/** 城市距离，ArrayList里存放的类型应该能代表两个不同的城市 */
	public ArrayList<Double> distances;
	/** 运输单价，ArrayList存放顺序与城市距离对应 */
	public ArrayList<Double> price;
	/** 薪水策略，根据不同的职工采用不同的策略 */
	public ArrayList<SalaryPolicy> salaryPolicies;

}
