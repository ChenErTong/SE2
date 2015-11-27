package ui.specialui.finance.SettlementManage;

import ui.GetDate;
import ui.myui.MyJLabel;
import ui.myui.MyJTable;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;
/**
 *pb.ID,pb.type," 付款人： "+pb.payerName+" 付款账号： "+pb.accountID+" 付款条目： "+pb.items+" 备注   "+pb.remarks,pb.date
 */
public class PayReceiptInfo extends MyTranslucentPanel{
	//private MyJTextField idField;
	private MyJTextField[] fields ;
	//private MyJTextField numberField;
	//private MyJTextField payerName;
	//private MyComboBox bankAccount;
	//private MyComboBox remarkBox;
	//private MyJTextField items;
	//private MyComboBox transferList;
	
	public PayReceiptInfo() {
		super(680,100,550,562);
		this.initComponent();
	}

	private void initComponent() {
		this.add(new MyJLabel(40,50,90,30,"付款单ID:",16,true));
		this.add(new MyJLabel(40,90,90,30,"付款人",16,true));
		this.add(new MyJLabel(290,90,90,30,"付款金额",16,true));
		this.add(new MyJLabel(40,130,90,30,"付款账户",16,true));
		this.add(new MyJLabel(290,130,90,30,"付款条目",16,true));
		this.add(new MyJLabel(40,170,90,30,"付款备注",16,true));
		this.add(new MyJLabel(290,170,90,30,"付款日期",16,true));
		
		fields[0] = new MyJTextField(130,90,120,30);
		this.add(fields[0]);
		
		fields[1] = new MyJTextField(380,90,120,30);
		this.add(fields[1]);
		
		fields[2] = new MyJTextField(130,130,120,30);
		fields[2].setOnlyInteger(19);
		this.add(fields[2]);
		
		fields[3] = new MyJTextField(380,130,120,30);
		this.add(fields[3]);
		
		fields[4] = new MyJTextField(130,170,120,30);
		this.add(fields[4]);
		
		fields[5] = new MyJTextField(380,170,120,30);
		fields[5].setText(GetDate.getTime());
		fields[5].setEditable(false);
		this.add(fields[5]);
	
	//	numberField = new MyJTextField(380,50,120,30);
	//	this.add(numberField);
		//payerName = new MyJTextField(140,90,120,30);
	//	this.add(payerName);
		
		
	//	String [] bankAccountLists = {""};
		//bankAccount = new MyComboBox(140,170,120,30,16,bankAccountLists);
		//this.add(bankAccount);
		//String[] remarks ={""};
		//remarkBox = new MyComboBox(140,130,120,30,16,remarks);
		//this.add(remarkBox);
		
	//	items = new MyJTextField(380,90,120,30);
		//this.add(items);
		
	//	String[] transferLists = {""};
	//	transferList = new MyComboBox(380,170,120,30,16,transferLists);
		//this.add(transferList);
		
	}

	private static final long serialVersionUID = 1L;

	public void setUneditable() {
		for(MyJTextField field: fields){
			field.setEditable(false);
		}
		
	}
	
	public String[] getData(){
		String [] data = new String[6];
		for(int i=0;i<6;i++){
			data[i] = fields[i].getText();
			if(data[i]==null){
				return null;
			}
		}
		return data;
	}
	
	public void setData(String [] data){
		for(int i=0;i<6;i++){
			fields[i].setText(data[i]);
		}
	}


}
