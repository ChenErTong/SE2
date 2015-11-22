package ui.specialui.manager.HandleReceipt;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import ui.image.CommonImage;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
/**
 * 修改单据信息的面板
 * @author zsq
 * @time 2015/11/18 23:57
 */
public class Panel_Manager_ModifyReceiptInfo extends MyJPanel{

	public Panel_Manager_ModifyReceiptInfo() {
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
		
		MyJLabel title = new MyJLabel(580, 40, 170, 50, "修改单据内容", 24, true);
		this.add(title);
		
		MyJButton modify = new MyJButton(475,600,100,30,"保存修改",18);
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
		
		MyJButton cancel = new MyJButton(720,600,100,30,"撤销修改",18);
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
