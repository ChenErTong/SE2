package dataservice.basedataservice;

import java.util.ArrayList;


import po.BasePO;

import state.FindTypeBase;
import state.ResultMessage;

/**
 * �ṩ��˾������Ӫ���ݵļ������롢�������ɾ�Ĳ����
 * @author zsq
 * @version Oct 22,2015
 */
public interface BaseDataService {
	/**
	 * �����л��ļ�������һ��BasePO
	 * @param po
	 * @return ������
	 */
	public ResultMessage insert(BasePO po);
	/**
	 * ����IDɾ�����л��ļ��е�һ��BasePO
	 * @param ID
	 * @return ������
	 */
	public ResultMessage delete(String ID);
	/**
	 * ����BasePO
	 * @param PO
	 * @return ������
	 */
	public ResultMessage update(BasePO PO);
	/**
	 * type�ǲ��ҵ����ͣ���һ��������ACCOUNT����
	 * @param baseType
	 * @return �˻��־û�����
	 */
	public ArrayList<BasePO> find(FindTypeBase baseType);
}
