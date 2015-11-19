package ui.specialui.sender;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.image.CommonImage;
import ui.myui.MyJFrame;
/**
 * 订单物流信息查询界面
 * @author zsq
 * @time 2015/11/18 19:31
 */
public class Frame_Sender extends MyJFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	
	
	private Panel_Sender_Total totalPanel ;
	private Panel_Sender_CommodityInfo commodityPanel ;
	private Panel_Sender_logisticInfo logisticPanel;
	public Frame_Sender(){

	totalPanel = new Panel_Sender_Total();
	commodityPanel = new Panel_Sender_CommodityInfo();
	logisticPanel = new Panel_Sender_logisticInfo();
	this.add(totalPanel);
	this.add(commodityPanel);
	this.add(logisticPanel);
	this.setBackground(CommonImage.TEST_BACKGROUND);
		

		
		//确认键
		/*button_Search = new MyButton(421, 510, 60, 30);
		button_Search.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent arg0){
//						loginBackground.setVisible(false);
//						loginBackground2.setVisible(true);
		}
		public void mouseExited(MouseEvent arg0){
//						loginBackground.setVisible(true);
//						loginBackground2.setVisible(false);
		}
	});
		button_Search.registerKeyboardAction(this, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),JComponent.WHEN_IN_FOCUSED_WINDOW);
		button_Search.addKeyListener(new KeyAdapter(){
		public void keyPressed(KeyEvent event){
		if(KeyEvent.getKeyText(event.getKeyCode()).compareToIgnoreCase("enter")==0){
			button_Search.doClick();
		}
		}
		});
				button_Search.addActionListener(this);
				this.add(button_Search);
				
				//确认键
				button_Exit = new MyButton(491, 510, 60, 30);
				button_Exit.addMouseListener(new MouseAdapter(){
					public void mouseEntered(MouseEvent arg0){
//						loginBackground.setVisible(false);
//						loginBackground2.setVisible(true);
					}
					public void mouseExited(MouseEvent arg0){
//						loginBackground.setVisible(true);
//						loginBackground2.setVisible(false);
					}
				});
				button_Exit.registerKeyboardAction(this, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),JComponent.WHEN_IN_FOCUSED_WINDOW);
				button_Exit.addKeyListener(new KeyAdapter(){
					public void keyPressed(KeyEvent event){
						if(KeyEvent.getKeyText(event.getKeyCode()).compareToIgnoreCase("enter")==0){
							button_Search.doClick();
						}
					}
				});
				button_Search.addActionListener(this);
				this.add(button_Exit);
			}
	*/
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
			
		

}

