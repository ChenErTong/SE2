package po;

import java.util.ArrayList;

import state.SalaryPolicy;

/**
 * ��˾��������Ӫ����������ְ��нˮ���ԡ����о��롢���䵥��
 * @author zsq
 * @version Oct 22,2015
 */
public class BasePO extends PersistentObject{

	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	/**���о��룬ArrayList���ŵ�����Ӧ���ܴ���������ͬ�ĳ���*/
	private ArrayList<Double> distances;
	/**���䵥�ۣ�ArrayList���˳������о����Ӧ*/
	private ArrayList<Double> price;
	/**нˮ���ԣ����ݲ�ͬ��ְ�����ò�ͬ�Ĳ���*/
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
