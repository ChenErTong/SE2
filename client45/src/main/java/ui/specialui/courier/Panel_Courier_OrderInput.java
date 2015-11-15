package ui.specialui.courier;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ui.image.CommonImage;
import ui.myui.MyJPanel;

public class Panel_Courier_OrderInput extends MyJPanel{
	private static final long serialVersionUID = 1L;

	public Panel_Courier_OrderInput(Frame_Courier frame) {
		super(60, 40, 550, 640);
		this.setOpaque(true);
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
//		g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
		BufferedImage image = new BufferedImage(550, 640, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = image.createGraphics();
		 g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
		g2d.drawImage(CommonImage.TEST_HALFOPAQUE, 0, 0, null);
	   
	    g2d.dispose();
	    
	    g.drawImage(image, 0, 0, null);
//	    System.out.println("111");
	}
}
