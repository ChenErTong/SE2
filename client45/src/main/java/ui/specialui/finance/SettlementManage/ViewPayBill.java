package ui.specialui.finance.SettlementManage;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

/**
 * 查看付款单信息
 * @author zsq
 * @version 2015/12/5 10:15
 */
public class ViewPayBill extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;
	
	private MyJTextField[] fields ;
	private MyJComboBox items;

	public ViewPayBill() {
		super(30, 390-30,620,240);
		this.initComponent();
	}
	
	private void initComponent() {
		this.add(new MyJLabel(240,10,150,30,"查看付款单",18,true));
		this.add(new MyJLabel(40,50,90,30,"付款人",16,true));
		this.add(new MyJLabel(290,50,90,30,"付款金额",16,true));
		this.add(new MyJLabel(40,90,90,30,"付款账户",16,true));
		this.add(new MyJLabel(290,90,90,30,"付款备注",16,true));
		this.add(new MyJLabel(40,130,90,30,"付款条目",16,true));
		this.add(new MyJLabel(290,130,90,30,"付款日期",16,true));
		
		fields = new MyJTextField[5];
		fields[0] = new MyJTextField(130,50,120,30);
		this.add(fields[0]);
		
		fields[1] = new MyJTextField(380,50,120,30);
		this.add(fields[1]);
		
		fields[2] = new MyJTextField(130,90,120,30);
		fields[2].setOnlyInteger(19);
		this.add(fields[2]);
		
		fields[3] = new MyJTextField(380,90,120,30);
		this.add(fields[3]);
		
		String[] item = {"租金","运费","薪水","奖励"};
		items = new MyJComboBox(130,130,120,30,item);
		this.add(items);
		
		fields[4] = new MyJTextField(380,130,120,30);
		this.add(fields[4]);		
	}

	public void setUneditable() {
		for(MyJTextField field: fields){
			field.setEditable(false);
		}
		items.setEditable(false);
		
	}
	
	public String[] getData(){
		String [] data = new String[6];
		for(int i=0;i<4;i++){
			data[i] = fields[i].getText();
		}
		data[4] =items.getSelectedIndex()+"";
		data[5] = fields[4].getText();
		for(int i=0;i<6;i++){
			if(data[i]==null){
				return null;
			}
		}
		return data;
	}
	
	public void setData(Object[] data){
		for(int i=0;i<4;i++){
			fields[i].setText((String) data[i]);
		}
		items.setSelectedItem((String)data[4]);
		fields[4] .setText((String) data[5]);
		
	}
}
