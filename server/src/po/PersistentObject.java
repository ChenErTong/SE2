package po;

import java.io.Serializable;

/**
 *����PO��ĸ��࣬��������ʱ�䡢���
 * @author zsq
 * @version Oct 22,2015
 *
 */
public class PersistentObject implements Serializable{

	/**serialVersionUID*/
	private static final long serialVersionUID = 1L;
	/**���ݱ�ţ���ʽ���ݲ�ͬ���Ӿ��в�ͬ�ĸ�ʽ*/
	protected String ID;
	/**ʱ��*/
	protected String date;
}
