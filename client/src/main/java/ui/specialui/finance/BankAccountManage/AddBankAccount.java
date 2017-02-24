package ui.specialui.finance.BankAccountManage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;
/**
 * 进行银行账户添加的半透明Panel
 * @author zsq
 * @version 2015/11/15 23:41
 */
public class AddBankAccount extends MyTranslucentPanel implements ActionListener{
	private static final long serialVersionUID = 1L;

	private MyJTextField nameField;
	private MyJTextField balanceField;
	
	public AddBankAccount() {
		super(660,70,550,240);
		this.initComponent();
	}

	private void initComponent() {
		MyJLabel title = new MyJLabel(240,10,150,30,"添加账户",18,true);
		this.add(title);
		
		MyJLabel accountName = new MyJLabel(10,80,90,30,"账户名称",16,true);
		this.add(accountName);
		
		MyJLabel balance = new MyJLabel(290,80,90,30,"账户余额",16,true);
		this.add(balance);
		
		nameField = new MyJTextField(100,80,150,30);
		nameField.addActionListener(this);
		this.add(nameField);
		
		balanceField = new MyJTextField(380,80,150,30);
		balanceField.setOnlyDouble();
		balanceField.addActionListener(this);
		this.add(balanceField);
		
	}
	
	public  void setUnEditable(){
		nameField.setEditable(false);
		balanceField.setEditable(false);
	}
	
	public String[] getData(){
		String [] data = new String[3];
		//data[0]用于存放id
		data[1] = nameField.getText();
		data[2] = balanceField.getText();
		if(data[1].equals("")||data[2].equals("")){
			return null;
		}
		return data;
	}
	
	public  void setData(String[] data){
		nameField.setText(data[0]);
		balanceField.setText(data[1]);
	}
	
	public void refresh() {
		nameField.setText(null);
		balanceField.setText(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nameField)
			balanceField.requestFocus();
		//	else if (e.getSource() == passText)
			//loginButton.requestFocus();
		//	}
		
	}
}
