package po;
/**
 * 需要进行审批的单据的状态
 * @author zsq
 * @version Oct 22,2015
 */
public enum ReceiptState {
	APPROVALING("正在审批"),
	SUCCESS("审批成功"),
	FAILURE("审批失败"),
	DRAFT("草稿状态");
	
	public final String value;
	
	ReceiptState(String value){
		this.value = value;
	}
}
