package ui.specialui.admin;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ui.image.CommonImage;
import ui.myui.MyJPanel;

public class Panel_Admin_AddUser extends MyJPanel{
	public Panel_Admin_AddUser(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public Panel_Admin_AddUser(Frame_Admin frame_Admin) {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		
		
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

	private static final long serialVersionUID = 1L;

}
