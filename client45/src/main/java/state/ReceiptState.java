package state;
/**
 * 单据的状态
 * @author zsq
 * @version Oct 22,2015
 */
public enum ReceiptState {
	APPROVALING("正在审批"),
	SUCCESS("通过审批"),
	FAILURE("未通过审批"),
	DRAFT("草稿状态״̬");
	
	public final String value;
	
	ReceiptState(String value){
		this.value = value;
	}
}
