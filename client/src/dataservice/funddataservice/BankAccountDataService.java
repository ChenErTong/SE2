package dataservice.funddataservice;
import java.util.ArrayList;

import po.BankPO;
import po.FindTypeAccount;
import state.ResultMessage;

/**
 * �ṩ�����˻����ݵļ������롢�������ɾ�Ĳ����
 * @author zsq
 * @version Oct 22,2015
 */
	public interface BankAccountDataService {
	/**
	 * �����л��ļ�������һ��BankAccoutPO
	 * @param po
	 * @return ������
	 */
	public ResultMessage insert(BankPO po);
	/**
	 * ����IDɾ�����л��ļ��е�һ��BankAccoutPO
	 * @param ID
	 * @return ������
	 */
	public ResultMessage delete(String ID);
	/**
	 * ����BankPO
	 * @param PO
	 * @return ������
	 */
	public ResultMessage update(BankPO PO);
	
	
	/**
	 * ��keywords�鿴�˻���Ϣ��type�ǲ��ҵķ�ʽ��ΪNULL���ʾ����ģ����ѯ
	 * @param keywords
	 * @return �˻��־û�����
	 */
	public ArrayList<BankPO> find(String keywords,FindTypeAccount bankAccoutType);
}