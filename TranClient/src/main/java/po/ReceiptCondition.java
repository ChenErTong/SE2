package po;
/**
 * 单据的状态,有草稿状态、提交状态、审批后状态
 * @author zsq
 * @version Oct 22,2015
 */
public enum ReceiptCondition {
	DRAFT("草稿状态"),
	SUBITTED("提交状态"),
	APPROVED("审批后状态");
	
	public final String value;
	
	ReceiptCondition(String value){
		this.value = value;
	}
}
