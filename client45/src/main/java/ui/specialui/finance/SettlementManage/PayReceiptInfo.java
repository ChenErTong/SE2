package ui.specialui.finance.SettlementManage;

import ui.myui.MyComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;
/**
 * 建立付款单构造器
 * @param ID 付款单ID
 * @param money 付款金额
 * @param payerName 付款人姓名
 * @param bankAccouts 付款账号
 * @param type 单据类型
 * @param rentYear 租金备注，当不是此条目下为NULL
 * @param salaryMonth 薪水备注，当不是此条目下为NULL
 * @param items 付款条目
 * @param transListNumber 运单号备注，当不是此条目下为NULL
 * @author zsq
 * @version Oct 22,2015
 */
public class PayReceiptInfo extends MyTranslucentPanel{
	private MyJTextField idField;
	private MyJTextField numberField;
	private MyJTextField payerName;
	private MyComboBox bankAccount;
	private MyComboBox remarkBox;
	private MyJTextField items;
	private MyComboBox transferList;
	
	public PayReceiptInfo() {
		super(680,100,550,562);
		//super(0,0,1280,720);
		this.initComponent();
	}

	private void initComponent() {
		this.add(new MyJLabel(40,50,90,30,"付款单ID",16,true));
		this.add(new MyJLabel(290,50,90,30,"付款金额",16,true));
		this.add(new MyJLabel(40,90,90,30,"付款人",16,true));
		this.add(new MyJLabel(290,90,120,30,"付款条目",16,true));
		this.add(new MyJLabel(40,130,90,30,"付款备注",16,true));
		this.add(new MyJLabel(290,130,90,30,"付款日期",16,true));
		this.add(new MyJLabel(40,170,90,30,"付款账号",16,true));
		this.add(new MyJLabel(290,170,90,30,"运单号",16,true));
		
		idField = new MyJTextField(140,50,120,30);
		this.add(idField);
		numberField = new MyJTextField(380,50,120,30);
		this.add(numberField);
		payerName = new MyJTextField(140,90,120,30);
		this.add(payerName);
		
		
		String [] bankAccountLists = {""};
		bankAccount = new MyComboBox(140,170,120,30,16,bankAccountLists);
		this.add(bankAccount);
		String[] remarks ={""};
		remarkBox = new MyComboBox(140,130,120,30,16,remarks);
		this.add(remarkBox);
		
		items = new MyJTextField(380,90,120,30);
		this.add(items);
		
		String[] transferLists = {""};
		transferList = new MyComboBox(380,170,120,30,16,transferLists);
		this.add(transferList);
		
	}

	private static final long serialVersionUID = 1L;

	public void setUneditable() {
		// TODO Auto-generated method stub
		
	}
}
