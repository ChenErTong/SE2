package state;
/**
 * 单据的状态
 * @author zsq
 * @version Oct 22,2015
 */
public enum ReceiptState {
	APPROVALING("待审批"),
	SUCCESS("通过审批"),
	FAILURE("未通过审批"),
	DRAFT("草稿状态״̬");
	
	public final String value;
	
	ReceiptState(String value){
		this.value = value;
	}
	
	public boolean equals(ReceiptState state){
		if(state==null)
			return true;
		else
			return super.equals(state);
	}
}
