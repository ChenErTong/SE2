package ui.specialui.manager.AdjustSalaryPolicy;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ui.image.CommonImage;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;

public class Panel_Manager_AddNewPolicy extends MyJPanel{

	public Panel_Manager_AddNewPolicy() {
		super(0,0,1280,720);
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
		MyJLabel title = new MyJLabel(580, 40, 170, 50, "新增策略信息", 24, true);
		this.add(title);
		
		MyJLabel  policyName = new MyJLabel(400, 92, 100, 30, "新策略名称", 18, true);
		this.add(policyName);
		
		MyJLabel policyRule = new MyJLabel(660,92,90,30,"策略解释",18,true);
		this.add(policyRule);
		
		
		MyJLabel policyCalculate = new MyJLabel(400,180, 90, 30, "策略计算规则", 18, true);
		this.add(policyCalculate);
		
		
	}

	private static final long serialVersionUID = 1L;

}
