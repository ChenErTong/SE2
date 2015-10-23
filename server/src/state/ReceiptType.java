package state;
/**
 * ��Ҫ���������ĵ��ݵ�����
 * @author zsq
 * @version Oct 22,2015
 */
public enum ReceiptType {
	CONFIRM("�ռ�ȷ�ϵ�", "SJQRD"),
	ORDER("�ļ�����", "JJDD"),
	BRANCH_TRUCK("װ����", "ZCD"),
	BRANCH_ARRIVAL("Ӫҵ�����ﵥ", "YYTDDD"),
	BRANCH_DELIVER("Ӫҵ���ɼ���", "YYTPJD"),
	EXPENSE("�տ", "SKD"),
	PAY("���","FKD"),
	TRANS_ARRIVAL("��ת���ĵ��ﵥ", "ZZZXDDD"),
	TRANS_PLANE("�ɻ�ת�˵�", "FJZYD"),
	TRANS_TRAIN("��ת�˵�", "HCZYD"),
	TRANS_TRUCK("����ת�˵�", "KCZYD"),
	INSTOCK("��ⵥ","RKD"),
	OUTSTOCK("���ⵥ","CCD"),
	TAKINGSTOCK("��������","KCTZD");
	
	public final String value;
	public final String prefix;
	
	ReceiptType(String value,String prefix){
		this.value = value;
		this.prefix = prefix;
	}
}
