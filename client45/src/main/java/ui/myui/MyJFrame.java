package ui.myui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import ui.image.CommonImage;
/**
 * Frame的总类，定义位置，大小，启动动画
 * @author czw
 * @time 2015年11月15日下午4:11:17
 */
public class MyJFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	//退出按钮
	protected MyJButton closeButton;
	//最小化按钮
	protected MyJButton minimizeButton;
	
	public MyJFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(1280, 720);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		
		this.minimizeButton = new MyJButton(1195, 15, 30, 30);
		this.minimizeButton.setMyIcon(CommonImage.TEST_MINIMUMIZE_BUTTON);
		this.minimizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyJFrame.this.setExtendedState(JFrame.ICONIFIED);
			}
		});
		this.add(this.minimizeButton);
		
		this.closeButton = new MyJButton(1235, 15, 30, 30);
		this.closeButton.setMyIcon(CommonImage.TEST_CLOSE_BUTTON);
		this.closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.add(this.closeButton);
		
		new HyalineValue().start(); // 透明渐变启动界面
	}
	
	protected void setBackground(ImageIcon image){
		MyBackground background = new MyBackground(image);
		this.add(background);
	}
	
	/**
	 * 透明度渐变启动界面
	 */
	protected class HyalineValue extends Thread {		
		float hyalineValue = 0f;
		public void run() {
			while(true) {
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				hyalineValue += 0.05f;
				if (hyalineValue > 1) {
					hyalineValue = 1;
				}
				setOpacity(hyalineValue);
				if (hyalineValue == 1) {
					break;
				}
			}
		}
	}
	
}