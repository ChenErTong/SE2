package ui.specialui.finance.SettlementManage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

/**
 * 修改付款单信息的Panel
 * @author zsq
 * @version 2015/12/5 10:00
 */
public class ModifyPayBill extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;
	
	private MyJTextField[] fields ;
	private MyJComboBox items;
	
	public ModifyPayBill() {
		super(680, 390-30,550+20,240);
		this.initComponent();
	}

	private void initComponent() {
		this.add(new MyJLabel(240,10,150,30,"修改付款单",18,true));
		this.add(new MyJLabel(40,50,90,30,"付款人",16,true));
		this.add(new MyJLabel(290,50,90,30,"付款金额",16,true));
		this.add(new MyJLabel(40,90,90,30,"付款账户",16,true));
		this.add(new MyJLabel(290,90,90,30,"付款备注",16,true));
		this.add(new MyJLabel(40,130,90,30,"付款条目",16,true));
		this.add(new MyJLabel(290,130,90,30,"付款日期",16,true));
		
		fields = new MyJTextField[5];
		fields[0] = new MyJTextField(130,50,120,30);
		fields[0].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[0]){
					fields[1].requestFocus();
				}
				
			}
			
		});
		this.add(fields[0]);
		
		fields[1] = new MyJTextField(380,50,120,30);
		fields[1].setOnlyDouble();
		fields[1].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[1]){
					fields[2].requestFocus();
				}
				
			}
			
		});
		this.add(fields[1]);
		
		fields[2] = new MyJTextField(130,90,120,30);
		fields[2].setOnlyInteger(19);
		fields[2].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==fields[1]){
					fields[3].requestFocus();
				}
				
			}
			
		});
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
			if(data[i].equals("")){
				return null;
			}
		}
		return data;
	}
	
	public void setData(Object[] data){
		for(int i=0;i<4;i++){
			fields[i].setText((String) data[i]);
		}
		items.setSelectedItem(data[4]);
		fields[4] .setText((String) data[5]);
		
	}

	public void refresh(){
		for(int i=0;i<4;i++){
			fields[i].setText(null);
		}
		items.setSelectedItem(null);
		
	}
}
