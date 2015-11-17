package ui.specialui.sender;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;


import ui.image.CommonImage;
import ui.myui.MyButton;
import ui.myui.MyJFrame;
import ui.myui.MyJTextField;

public class Frame_Sender extends MyJFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	MyJTextField orderNumberField;
	MyJTextField senderNameField;
	MyButton button_Search;
	MyButton button_Exit;
	JLabel label_field1,label_field2;
	
	Panel_Sender_Total totalPanel = new Panel_Sender_Total(this);
	public Frame_Sender(){
//		MyColor color = new MyColor();
		totalPanel = new Panel_Sender_Total(this);
		this.add(totalPanel);
		
		this.setBackground(CommonImage.TEST_BACKGROUND);
		
//		订单号输入框	
		orderNumberField = new MyJTextField(421, 414, 200, 40);
		orderNumberField.setFont(new Font("Arail",Font.BOLD,20));
		this.add(orderNumberField);
		
		senderNameField = new MyJTextField(421, 464, 200, 40);
		senderNameField.setFont(new Font("Arail",Font.BOLD,20));
		this.add(senderNameField);
		
		//确认键
		button_Search = new MyButton(421, 510, 60, 30);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
			
		

}

