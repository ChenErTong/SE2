package po;

/**
 * ϵͳ�û�����ݣ����Ա��������Ա��Ӫҵ��ҵ��Ա����ת����ҵ��Ա����ת���Ŀ�������Ա���ܾ�������Ա
 * @author zsq
 *@version Oct 22,2015
 */
public enum UserIdentity {
	COURIER("���Ա"),
	GENERAL_MANAGER("�ܾ���"),
	INVENTORY_MANAGER("��������Ա"),
	FINANCE_MANAGER("������Ա"),
	BRANCH_COUNTERMAN("Ӫҵ��ҵ��Ա"),
	TRANSFER_CONTERMAN("��ת����ҵ��Ա"),
	ADMIN("����Ա");
	
	public final String value;

	UserIdentity(String value) {
		this.value = value;
	}
}
