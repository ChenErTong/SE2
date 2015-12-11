package ui.myui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

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
	
	//退出按钮
	protected MyButton closeButton;
	//最小化按钮
	protected MyButton minimizeButton;
	//返回按钮
	protected MyButton returnButton;
	//用户ID
	protected String ID;
	
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
				System.exit(0);
			}
		});
		this.add(this.closeButton);
		

		//the codes that make the frame mouse-drag-able
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
	 * 初始化界面在屏幕中央
	 * @param a
	 * @param b
	 * @return
	 */
	private int getLocation(int a,int b){
		return (a-b)/2;
	}
			
	public String getCurrentLocation(int X, int Y){
		return String.valueOf(X) + ";" + String.valueOf(Y);
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