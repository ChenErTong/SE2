package ui.specialui.manager;

import ui.image.ManagerImage;
import ui.myui.MyButton;
import ui.myui.MyJPanel;
import ui.myui.MyLogo;
import ui.myui.MyTitle;
/**
 * 总经理主界面的总Panel
 * @author zsq
 * @version 2015/12/05 16:14
 */
public class Panel_Manager_Total extends MyJPanel {
	private static final long serialVersionUID = 1L;

	public Panel_Manager_Total(FrameManager frameManager) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		MyLogo.setLogo(this);
		MyTitle.setTitle(this, "总公司总经理界面", 535, 100, 387, 148);
		this.initComponent(frameManager);
		this.repaint();
	}
	
	public void initComponent(FrameManager frameManager){
		MyButton HandleReceipt = new MyButton(551, 200+10+8+18+5+20, 257, 46,ManagerImage.getBUTTON_APPROVE());
		HandleReceipt.setActionCommand("HandleReceipt");
		HandleReceipt.addActionListener(frameManager);
		this.add(HandleReceipt);
		HandleReceipt.setVisible(true);
		
		MyButton HandleOrganization = new MyButton(551, 256+10+8+18+5+20, 257, 46,ManagerImage.getBUTTON_ORGANIZATION());
		
		HandleOrganization.setActionCommand("HandleOrganization");
		HandleOrganization.addActionListener(frameManager);
		this.add(HandleOrganization);
		HandleOrganization.setVisible(true);
		
		MyButton AdjustBase = new MyButton(551, 256+56+10+8+18+5+20,257 , 46,ManagerImage.getBUTTON_BASE());
		AdjustBase.setActionCommand("AdjustBase");
		AdjustBase.addActionListener(frameManager);
		this.add(AdjustBase);
		AdjustBase.setVisible(true);
		
		MyButton AdjustSalaryPolicy = new MyButton(551,256+56+56+10+8+18+5+20, 257, 46,ManagerImage.getBUTTON_POLICY());
		AdjustSalaryPolicy.setActionCommand("AdjustSalaryPolicy");
		AdjustSalaryPolicy.addActionListener(frameManager);
		this.add(AdjustSalaryPolicy);
		AdjustSalaryPolicy.setVisible(true);
		
		MyButton ViewUser = new MyButton(551,  256+56+56+56+10+8+18+5+20, 257, 46,ManagerImage.getBUTTON_ACCOUNT());
		ViewUser.setActionCommand("ViewUser");
		ViewUser.addActionListener(frameManager);
		this.add(ViewUser);
		ViewUser.setVisible(true);
		
		MyButton ViewBusinessPerformance = new MyButton(551,256+56*4+10+8+18+5+20,257,46,ManagerImage.getButton_JINGYING());
		ViewBusinessPerformance.setActionCommand("ViewBusinessPerformance");
		ViewBusinessPerformance.addActionListener(frameManager);
		this.add(ViewBusinessPerformance);
		ViewBusinessPerformance.setVisible(true);
		
		MyButton ViewIncomeStatement = new MyButton(551, 256+56*5+10+8+18+5+20, 257, 46,ManagerImage.getButton_CHENGBEN());
		ViewIncomeStatement.setActionCommand("ViewIncomeStatement");
		ViewIncomeStatement.addActionListener(frameManager);
		this.add(ViewIncomeStatement);
		ViewIncomeStatement.setVisible(true);
		
		MyButton viewLog = new MyButton(551,256+56*6+10+8+18+5+20,257,46,ManagerImage.getButton_LOG());
		viewLog.setActionCommand("ViewLogMsg");
		viewLog.addActionListener(frameManager);
		this.add(viewLog);
	}

}
