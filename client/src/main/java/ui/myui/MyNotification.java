package ui.myui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 通知栏(例如更新成功，数据错误等信息)(网上copy，待修改)
 * @author czw
 * @time 2015年11月16日下午9:54:34
 */
public class MyNotification extends JDialog implements Runnable{
	private static final long serialVersionUID = 1L;
	private Dimension size = new Dimension(300,100);
	
	public MyNotification(JFrame frame, String text, Color color, boolean autoClosed){
		super(frame);
		
		if((int)frame.getLocationOnScreen().getY()==94){
			this.setLocation((int)frame.getLocationOnScreen().getX() + 900, (int)frame.getLocationOnScreen().getY() + 620-70);
		}else{
			this.setLocation((int)frame.getLocationOnScreen().getX() + 900, (int)frame.getLocationOnScreen().getY() + 620);
		}
		
		this.init(text, color);
		
		if(autoClosed){
			startThread();
		}
	}
	
	public MyNotification(JPanel panel, String text, Color color, boolean autoClosed){
		if((int)panel.getLocationOnScreen().getY()==94){
			this.setLocation((int)panel.getLocationOnScreen().getX() + 900, (int)panel.getLocationOnScreen().getY() + 620-70);
		}else{
			this.setLocation((int)panel.getLocationOnScreen().getX() + 900, (int)panel.getLocationOnScreen().getY() + 620);
		}
		
		this.init(text, color);
		
		if(autoClosed){
			startThread();
		}
	}

	public void startThread(){
		Thread t = new Thread(this);
		t.start();
	}
	
	public MyNotification(JPanel panel, String text, Color color){
		this(panel, text, color, true);
	}
		

	public MyNotification(JFrame frame, String text, Color color) {
		this(frame, text, color, true);
	}

	@SuppressWarnings("restriction")
	private void init(String text, Color color){
		this.setUndecorated(true);
		setSize(size);
		
		UndergroundPanel mainPanel = new UndergroundPanel();
		mainPanel.setLayout(null);

		if (text.length() > 10) {
			String message1 = text, message2;
			message1 = text.substring(0, 9);
			message2 = text.substring(9, text.length());

			JLabel messageLabel1 = new JLabel(message1);
			messageLabel1.setForeground(color);
			messageLabel1.setFont(new MyFont(18, true));
			messageLabel1.setBounds(
					size.width / 2 - messageLabel1.getPreferredSize().width	/ 2, 
					size.height / 2 - messageLabel1.getPreferredSize().height / 2 - 16, 
					messageLabel1.getPreferredSize().width,
					messageLabel1.getPreferredSize().height);
			mainPanel.add(messageLabel1, BorderLayout.CENTER);

			JLabel messageLabel2 = new JLabel(message2);
			messageLabel2.setForeground(color);
			messageLabel2.setFont(new MyFont(18, true));
			messageLabel2.setBounds(
					size.width / 2 - messageLabel2.getPreferredSize().width	/ 2,
					size.height / 2	- messageLabel2.getPreferredSize().height / 2 + 16,
					messageLabel2.getPreferredSize().width,
					messageLabel2.getPreferredSize().height);
			mainPanel.add(messageLabel2, BorderLayout.CENTER);
		} else {
			JLabel messageLabel = new JLabel(text);
			messageLabel.setForeground(color);
			messageLabel.setFont(new MyFont(18, true));
			messageLabel.setBounds(
					size.width / 2 - messageLabel.getPreferredSize().width / 2,
					size.height / 2 - messageLabel.getPreferredSize().height / 2 - 2,
					messageLabel.getPreferredSize().width,
					messageLabel.getPreferredSize().height);
			mainPanel.add(messageLabel, BorderLayout.CENTER);
		}
		add(mainPanel);

		com.sun.awt.AWTUtilities.setWindowOpaque(this, false);

		// 渐隐效果显示
		float translucent = 0.01f;
		com.sun.awt.AWTUtilities.setWindowOpacity(this, 0.0f);
		setVisible(true);
		while (translucent < 1) {
			com.sun.awt.AWTUtilities.setWindowOpacity(this, translucent);
			translucent += 0.03f;
		}
		
	}
	
	@SuppressWarnings("restriction")
	public void close() {
		// 渐隐效果
		float translucent = 1.0f;
		while (translucent > 0) {
			com.sun.awt.AWTUtilities.setWindowOpacity(this, translucent);
			translucent -= 0.03f;
		}
		dispose();
	}

	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		close();
	}
	
	private class UndergroundPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			int width = getWidth();
			int height = getHeight();
			GradientPaint gradient = new GradientPaint(0.0f, 0.0f, new Color(
					230, 230, 230, 230), 0.0f, (float) height, new Color(230,
					230, 230, 230));

			g2.setPaint(gradient);

			// 柔性剪裁
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);

			g2.fillRoundRect(7, 7, width - 14, height - 14, 20, 20);

			g2.setColor(Color.WHITE);
			g2.drawRoundRect(6, 6, width - 14, height - 14, 20, 20);
			g2.setColor(new Color(240, 155, 75, 200));
			g2.drawRoundRect(5, 5, width - 12, height - 12, 21, 21);
			g2.setColor(new Color(240, 155, 75, 160));
			g2.drawRoundRect(4, 4, width - 10, height - 10, 22, 22);
			g2.setColor(new Color(240, 155, 75, 120));
			g2.drawRoundRect(3, 3, width - 8, height - 8, 23, 23);
			g2.setColor(new Color(240, 155, 75, 80));
			g2.drawRoundRect(2, 2, width - 6, height - 6, 24, 24);
			g2.setColor(new Color(240, 155, 75, 40));
			g2.drawRoundRect(1, 1, width - 4, height - 4, 25, 25);
			g2.setColor(new Color(240, 155, 75, 10));
			g2.drawRoundRect(0, 0, width - 2, height - 2, 26, 26);
		}
	}
}