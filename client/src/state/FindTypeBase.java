package state;

public enum FindTypeBase {
	SalaryPolicy("薪水策略"),
	DISTANCE("城市距离"),
	PRICE("运输单价");
	public final String value;
	
	FindTypeBase(String value){
		this.value = value;
	}
}
