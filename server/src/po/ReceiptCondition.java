package po;
/**
 * ���ݵ�״̬,�вݸ�״̬���ύ״̬��������״̬
 * @author zsq
 * @version Oct 22,2015
 */
public enum ReceiptCondition {
	DRAFT("�ݸ�״̬"),
	SUBITTED("�ύ״̬"),
	APPROVED("������״̬");
	
	public final String value;
	
	ReceiptCondition(String value){
		this.value = value;
	}
}
