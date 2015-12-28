package ui.myui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import ui.commonui.exitSystem.ExitSystemFrame;
import ui.commonui.login.Frame_Login;
import ui.image.CommonImage;
import com.sun.awt.AWTUtilities;
/**
 * Frame的总类，定义位置，大小，启动动画
 * @author czw
 * @time 2015年11月15日下午4:11:17
 */
@SuppressWarnings("restriction")
public class MyJFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	//退出确认界面
	private ExitSystemFrame exit;
	//覆盖
	private MyTranslucentPanel cover;
	//退出按钮
	protected MyButton closeButton;
	//最小化按钮
	protected MyButton minimizeButton;
	//返回按钮
	protected MyButton returnButton;
	//用户ID
	protected String ID;
	//下标
	protected JLabel subscript;
	
	boolean isDraging;
	int xx, yy, X0, Y0, X, Y;
	
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
		
		subscript = new JLabel(CommonImage.getSUBSCRIPT());
		subscript.setBounds(10, 688, 148, 27);
		this.add(subscript);
		
		//设置圆角
		AWTUtilities.setWindowShape(this, new RoundRectangle2D.Double(0.0D,
				0.0D, 1280, 720, 8.0D, 8.0D));
		//小图标
		this.setIconImage(CommonImage.getLOGO().getImage());
		
		//通用按钮
		this.returnButton = new MyButton(1155, 15, 32, 32, CommonImage.getBUTTON_RETURN());
		this.returnButton.setActionCommand("return");
		this.add(this.returnButton);
		
		this.minimizeButton = new MyButton(1195, 15, 32, 32, CommonImage.getBUTTON_MINIMUMIZE());
		this.minimizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyJFrame.this.setExtendedState(JFrame.ICONIFIED);
			}
		});
		this.add(this.minimizeButton);
		
		this.closeButton = new MyButton(1235, 15, 32, 32, CommonImage.getBUTTON_CLOSE());
		this.closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyJFrame.this.startExit(true);
			}
		});
		this.add(this.closeButton);
		
		//设置界面可拖动
		this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                requestFocus();
                isDraging = true;
                xx = e.getX();
                yy = e.getY();
            }
 
            public void mouseReleased(MouseEvent e) {
                isDraging = false;
            }
        });
		
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (isDraging) {
                    int left = getLocation().x;
                    int top = getLocation().y;
                    setLocation(left + e.getX() - xx, top + e.getY() - yy);
                    X = left + e.getX() - xx;
                    Y = top + e.getY() - yy;
                    GetLocation io = new GetLocation();
                    io.setX(X);
                    io.setY(Y);
                }
            }
        });
        
        //ctrl+w键退出系统
		this.addKeyListener(new KeyAdapter() {
			boolean tag1 = false;
			boolean tag2 = false;
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_CONTROL){
					tag1 = true;
				}else if(e.getKeyCode() == KeyEvent.VK_W){
					tag2 = true;
				}
				if(tag1&&tag2){
					System.exit(0);
				}
			}
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_CONTROL){
					tag1 = false;
				}else if(e.getKeyCode() == KeyEvent.VK_W){
					tag2 = false;
				}
			}
		});
        
		this.repaint();
	}
	
	/**
	 * 启动退出界面
	 */
	private void startExit(boolean kind){
		cover = new MyTranslucentPanel(0, 0, 1280, 720);
		MyJFrame.this.getLayeredPane().add(cover);
		MyJFrame.this.setEnabled(false);
		exit = new ExitSystemFrame(MyJFrame.this, MyJFrame.this.getLocationOnScreen().getX() + 640, MyJFrame.this.getLocationOnScreen().getY() + 360, kind);
		exit.setEnabled(true);
	}
	
	/**
	 * 准备注销
	 */
	protected void logout(){
		this.startExit(false);
	}
	
	/**
	 * 确认注销
	 */
	public void confirmLogout() {
		new Frame_Login(ID);
		this.exit.dispose();
		this.dispose();
	}
	
	protected void setBackground(ImageIcon image){
		MyBackground background = new MyBackground(image);
		this.add(background);
	}
	
	public String getID(){
		return this.ID;
	}
			
	public String getCurrentLocation(int X, int Y){
		return String.valueOf(X) + ";" + String.valueOf(Y);
	}   

	/**
	 * 取消退出系统或注销用户
	 */
	public void cancelExit() {
		exit.setVisible(false);
		this.remove(exit);
		exit = null;
		cover.setVisible(false);
		this.remove(cover);
		cover = null;
		this.setEnabled(true);
		this.setVisible(true);
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
	
	class MyWindow extends JDialog {
		private static final long serialVersionUID = 1L;

		MyWindow(){
			this.setSize(1280, 720);
			this.setUndecorated(true);
			GetLocation io = new GetLocation();
			this.setLocation(io.getX(), io.getY());
			this.setLayout(null);
			this.setBackground(new Color(0, 0, 0, 0.7f));	
		}
	}
	
	class GetLocation {	
		int x, y;
		void setX(int _x){
			x = _x;
		}
		void setY(int _y){
			y = _y;
		}
		int getX(){
			return x;
		}
		int getY(){
			return y;
		}
	}
}