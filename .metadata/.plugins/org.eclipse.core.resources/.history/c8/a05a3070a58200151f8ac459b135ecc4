package po;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * �����˻��ĳ־û�����
 * �˻������У����ƺ�������ʱ�䡢�˻����ԡ�����ǲ������޸ĵģ���������ȡ�����տ�͸��
 * @author zsq
 * @version Oct 22,2015
 */

public class BankPO extends PersistentObject{

	/**serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
	/**�˻�����*/
	private String name;
	/**�˻����*/
	private double money;
	/**�˻�����*/
	private String level;
	/**�˻�����ʱ��,ϵͳ�Զ�����õ�*/
	private String date;
	
	public BankPO(String ID,String name,double money,String level){
		super(ID);
		this.name = name;
		this.money = money;
		this.level = level;
		/**�Զ���������*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm--dd HH:mm");
		date = sdf.format(new Date());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	/**
	 * ģ����ѯ
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return this.ID+"|"+this.name+"|"+this.money;
	}

	

	
}
