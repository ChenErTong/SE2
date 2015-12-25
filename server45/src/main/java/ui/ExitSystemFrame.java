package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JDialog;
import com.sun.awt.AWTUtilities;

@SuppressWarnings("restriction")
public class ExitSystemFrame extends JDialog{
	private static final long serialVersionUID = 1L;

	/**
	 * @param frame
	 * @param x
	 * @param y
	 * @param kind 窗口类别，若为true则是退出系统界面，若为false则是注销用户界面
	 */
	public ExitSystemFrame(ServerFrame frame, double x, double y, boolean kind){
		this.setSize(256, 144);
		this.setLocation((int)(x - this.getWidth() / 2), (int)(y - this.getHeight() / 2));
		this.setLayout(null);
		this.setUndecorated(true);
		//设置圆角
		AWTUtilities.setWindowShape(this, new RoundRectangle2D.Double(0.0D,
				0.0D, 256, 144, 8.0D, 8.0D));
		//设置半透明
		com.sun.awt.AWTUtilities.setWindowOpacity(this, 0.6f);
		
		ServerLabel title = null;
		if(kind){
			title = new ServerLabel(23, 20, 240, 21, "是否确认关闭服务器", 20, true);
		}else{
			title = new ServerLabel(23, 20, 210, 21, "是否确认注销当前用户", 20, true);
		}
		title.setForeground(Color.BLACK);
		this.add(title);
		
		ServerButton confirm = new ServerButton(63, 68, 45, 45, CommonImage.getBUTTON_CONFIRM());
		confirm.setActionCommand("confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kind){
					System.exit(0);
				}else{
					frame.confirmLogout();
				}
			}
		});
		this.add(confirm);
		
		ServerButton cancel = new ServerButton(153, 70, 38, 38, CommonImage.getBUTTON_CANCEL());
		cancel.setActionCommand("cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cancelExit();
			}
		});
		this.add(cancel);
		
		this.setVisible(true);		
	}
}