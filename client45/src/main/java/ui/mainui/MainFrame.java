package ui.mainui;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public MainFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 668);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		new HyalineValue().start(); // 透明渐变启动界面
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