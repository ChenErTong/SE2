package state;

public enum SalaryPolicy {
	DEDUCT("提成"),
	BYTIMES("计次"),
	EVERYMONTH("月薪");
	
	public final String value;
	SalaryPolicy(String value){
		this.value = value;
	}
}
