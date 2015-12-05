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
	protected MyButton closeButton;
	//最小化按钮
	protected MyButton minimizeButton;
	//返回按钮
	protected MyButton returnButton;
	//用户ID
	protected String ID;
	
	public static  String frameName;
	/**
	 * 透明渐变启动界面
	 */
	public MyJFrame(String userID){
		this(true);
		this.ID = userID;
		new HyalineValue().start(); // 透明渐变启动界面
	}
	/**
	 * 非透明渐变启动界面
	 */
	public MyJFrame(boolean isGradualSetup){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(1280, 720);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		
		this.returnButton = new MyButton(1155, 15, 30, 30, CommonImage.TEST_RETURN_BUTTON);
		this.returnButton.setActionCommand("return");
		this.add(this.returnButton);
		
		this.minimizeButton = new MyButton(1195, 15, 30, 30, CommonImage.TEST_MINIMUMIZE_BUTTON);
		this.minimizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyJFrame.this.setExtendedState(JFrame.ICONIFIED);
			}
		});
		this.add(this.minimizeButton);
		
		this.closeButton = new MyButton(1235, 15, 30, 30, CommonImage.TEST_CLOSE_BUTTON);
		this.closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.add(this.closeButton);
		
		this.repaint();
	}
	
	protected void setBackground(ImageIcon image){
		MyBackground background = new MyBackground(image);
		this.add(background);
	}
	
	public String getID(){
		return this.ID;
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