package po;
/**
 * ��Ҫ���������ĵ��ݵ�״̬
 * @author zsq
 * @version Oct 22,2015
 */
public enum ReceiptState {
	APPROVALING("��������"),
	SUCCESS("�����ɹ�"),
	FAILURE("����ʧ��"),
	DRAFT("�ݸ�״̬");
	
	public final String value;
	
	ReceiptState(String value){
		this.value = value;
	}
}
