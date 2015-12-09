package base;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import state.FindTypeBase;
import state.ResultMessage;
import state.SalaryPolicy;
import vo.BaseVO;
import businesslogic.basebl.Base;

public class MockBase extends Base {
	public MockBase() throws MalformedURLException, RemoteException, NotBoundException {
		super();
	}

	private ArrayList<Double> distances;
	
	private ArrayList<Double> price;
	
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
	public ArrayList<BaseVO> show(FindTypeBase baseType) {
		return new ArrayList<BaseVO>();
	}
	
	public String getID(FindTypeBase baseType) {
		return "123";
	}
	
	public ResultMessage addBase(BaseVO vo) {
		return ResultMessage.FAIL;
	}
	
	public ResultMessage deleteBase(String ID) {
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage updateBase(BaseVO vo) {
		return ResultMessage.WAIT;
	}
}
