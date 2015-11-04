package state;

public enum SalaryPolicy {
	DEDUCT("COURIER"),
	BYTIMES("DRIVER"),
	EVERYMONTH("COUNTERMAN");
	
	public final String value;
	SalaryPolicy(String value){
		this.value = value;
	}
}
