package ui.specialui.manager.HandleOrganization;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import ui.image.CommonImage;
import ui.myui.MyComboBox;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTextField;

public class Panel_Manager_AddOrganization extends MyJPanel {

	public Panel_Manager_AddOrganization() {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent();
	
	}
	public void paint(Graphics g){
		super.paint(g);
		BufferedImage image = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = image.createGraphics();
		 g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
		g2d.drawImage(CommonImage.TEST_HALFOPAQUE, 0, 0, null);
	    g2d.dispose();
	     g.drawImage(image, 365, 40, null);
	  
	}

	private void initComponent() {
		MyJLabel title = new MyJLabel(580, 40, 170, 50, "添加新机构", 24, true);
		this.add(title);
		
		MyJLabel organizationID = new MyJLabel(400, 92, 100, 30, "机构编号", 18, true);
		this.add(organizationID);
		
		MyJLabel organizationName = new MyJLabel(660,92,90,30,"机构名称",18,true);
		this.add(organizationName);
		
		MyJLabel organizationType = new MyJLabel(400,180, 90, 30, "机构类型", 18, true);
		this.add(organizationType);
		
		MyJLabel numberOfEmployee= new MyJLabel(660,180,90,30,"机构人数",18,true);
		this.add(numberOfEmployee);
			
		MyJLabel phone = new MyJLabel(400, 270, 90, 30, "联系电话",18,true);
		this.add(phone);
		
		MyJLabel address = new MyJLabel(400,360,90,30,"家庭地址:",18,true);
		this.add(address);
		
		MyJLabel addrDetails = new MyJLabel(400,460,90,30,"详细地址:",18,true);
		this.add(addrDetails);
		
		MyJLabel province = new MyJLabel(490,400,25,30,"省",18,true);
		this.add(province);
		
		MyJLabel city = new MyJLabel(660,400,25,30,"市",18,true);
		this.add(city);
		
		MyJTextField organizationId = new MyJTextField(500,92,140,30);
		this.add(organizationId);

		MyJTextField nameField = new MyJTextField(750,92,140,30);
		this.add(nameField);
		
		MyJTextField numberField = new MyJTextField(750, 180, 140, 30);
		this.add(numberField);
		
		MyJTextField phoneField = new MyJTextField(500,270,140,30);
		phoneField.setOnlyInteger(11);
		this.add(phoneField);
		
		String type[] = {"所有机构","营业厅","中转中心"};
		MyComboBox userIdentityBox = new MyComboBox(500,180,150,30,18,type);
		this.add(userIdentityBox);
	
		String[] provinces ={"江苏省","海南省"};
		MyComboBox provincesBox = new MyComboBox(520,400,120,30,18,provinces);
		this.add(provincesBox);
		
		String[] cities = {"南京市","海口市"};
		MyComboBox citiesBox = new MyComboBox(690,400,120,30,18,cities);
		this.add(citiesBox);
		
		MyEmptyTextArea addressDetails = new MyEmptyTextArea(490,468,410,100);
		this.add(addressDetails);
		
		MyJButton modify = new MyJButton(475,600,100,30,"确认添加",18);
		modify.setActionCommand("Modify");
		modify.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("111");
			}
			
		});
		this.add(modify);
		modify.setVisible(true);
		
		MyJButton cancel = new MyJButton(720,600,100,30,"取消添加",18);
		cancel.setActionCommand("Cancel");
		cancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("222");
			}
			
		});
		this.add(cancel);
		cancel.setVisible(true);
		
	}
	

	private static final long serialVersionUID = 1L;

}
