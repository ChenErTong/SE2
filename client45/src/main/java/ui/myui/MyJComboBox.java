package ui.myui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.ComboPopup;

import jxl.format.Font;
/**
 * 下拉框
 * @author czw
 * @time 2015年11月18日上午12:04:12
 */
@SuppressWarnings("unused")
public class MyJComboBox extends JComboBox<String> {
	private static final long serialVersionUID = 1L;
	/**
	 * @param x 横坐标
	 * @param y 纵坐标
	 * @param width 宽度
	 * @param height 高度
	 * @param items 可选条目(首位为缺省值)
	 */
	public MyJComboBox(int x, int y, int width, int height, String[] items){
		this.setFont(new MyFont(15));
		this.setBounds(x, y, width, height);
		this.setForeground(Color.BLACK);
		if(items != null){
			for(int i = 0; i < items.length; i++){
				this.addItem(items[i]);
			}
			if(items.length > 0){
				this.setSelectedItem(items[0]);
			}	
		}
		this.setMaximumRowCount(4);
		this.setVisible(true);
	}
	
	/**
	 * 重设选项列表中的数据
	 * @param newItem
	 */
	public void reset(String[] newItem){
		this.removeAllItems();
		for(int i = 0; i < newItem.length; i ++){
			this.addItem(newItem[i]);
		}
	}
	
	/**
	 * 重载init方法
	 */
/**	private void init(){
		this.setOpaque(false);
		setUI(new MyJComboBoxUI());
		setRenderer(new MyJComboBoxRenderer());
		setBackground(XUtil.defaultComboBoxColor);
	}
	
	public Dimension getPreferredSize(){
		  return super.getPreferredSize();
		 }
	
	class MyJComboBoxRenderer implements ListCellRenderer{
		private DefaultListCellRenderer defaultCellRenderer = new DefaultListCellRenderer();
		
		public MyJComboBoxRenderer(){
			super();
		}
		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			JLabel renderer = (JLabel)defaultCellRenderer.getListCellRendererComponent(
				    list, value, index, isSelected, cellHasFocus);
				  if(isSelected){
				   renderer.setBackground(XUtil.defaultComboBoxBoundsColor);
				   renderer.setForeground(Color.WHITE);
				  }else{
				   renderer.setBackground(Color.WHITE);
				  }
				  list.setSelectionBackground(XUtil.defaultComboBoxColor);
				  list.setBorder(null);
				  renderer.setFont(XUtil.defaultComboBoxFont);
				  renderer.setHorizontalAlignment(JLabel.CENTER);
				  return renderer;
		}
		
	}
	
	class MyJComboBoxUI extends BasicComboBoxUI{
		private JButton arrow;
		 private boolean boundsLight = false;
		 private static final int ARCWIDTH = 15;
		 private static final int ARCHEIGHT = 15;
		 
		 public MyJComboBoxUI(){
			 super();
		 }
		 protected JButton createArrowButton() {
			  arrow = new JButton();
			  arrow.setIcon(XUtil.defaultComboBoxArrowIcon);
			  arrow.setRolloverEnabled(true);
			  arrow.setRolloverIcon(XUtil.defaultComboBoxArrowIcon_Into);
			  arrow.setBorder(null);
			  arrow.setBackground(XUtil.defaultComboBoxColor);
			  arrow.setOpaque(false);
			  arrow.setContentAreaFilled(false);
			  return arrow;
			 }

			 public void paint(Graphics g, JComponent c) {
			  hasFocus = comboBox.hasFocus();
			  Graphics2D g2 = (Graphics2D)g;
			  if (!comboBox.isEditable()) {
			   Rectangle r = rectangleForCurrentValue();
			   //重点:JComboBox的textfield 的绘制 并不是靠Renderer来控制 这点让我很吃惊.
			   //它会通过paintCurrentValueBackground来绘制背景
			   //然后通过paintCurrentValue();去绘制JComboBox里显示的值
			   paintCurrentValueBackground(g2, r, hasFocus);
			   paintCurrentValue(g2, r, hasFocus);
			  }
			  
			  g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
			  int width = (int) this.getPreferredSize(c).getWidth()
			    + arrow.getWidth() - 2;
			  int height = 0;
			  int heightOffset = 0;
			  if (comboBox.isPopupVisible()) {
			   heightOffset = 5;
			   height = (int) this.getPreferredSize(c).getHeight();
			   arrow.setIcon(XUtil.defaultComboBoxArrowIcon_Into);
			  } else {
			   heightOffset = 0;
			   height = (int) this.getPreferredSize(c).getHeight() - 1;
			   arrow.setIcon(XUtil.defaultComboBoxArrowIcon);
			  }
			  if (comboBox.isFocusable()) {
			   g2.setColor(new Color(150, 207, 254));
			  }
			  g2.drawRoundRect(0, 0, width, height + heightOffset,ARCWIDTH,ARCHEIGHT);
			 }

			 public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
			  Font oldFont = (Font) comboBox.getFont();
			  comboBox.setFont(XUtil.defaultComboBoxFont);
			  
			  super.paintCurrentValue(g, bounds, hasFocus);
			  comboBox.setFont((java.awt.Font) oldFont);
			 }

			 public Dimension getPreferredSize(JComponent c) {
			  return super.getPreferredSize(c);
			 }

			 public boolean isBoundsLight() {
			  return boundsLight;
			 }

			 public void setBoundsLight(boolean boundsLight) {
			  this.boundsLight = boundsLight;
			 }

			 protected ComboPopup createPopup() {
			  ComboPopup popup = new BasicComboPopup(comboBox) {
			   protected JScrollPane createScroller() {
			    IScrollPane sp = new IScrollPane(list,
			      ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
			      ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			    sp.setHorizontalScrollBar(null);
			    return sp;
			   }
			   //重载paintBorder方法 来画出我们想要的边框..
			   public void paintBorder(Graphics g){
			    Graphics2D g2 = (Graphics2D) g;
			    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			      RenderingHints.VALUE_ANTIALIAS_ON);
			    g2.setColor(new Color(150, 207, 254));
			    g2.drawRoundRect(0,-arrow.getHeight(),getWidth()-1,getHeight()+arrow.getHeight()-1,0,0);
			   }
			  };
			  return popup;
			 }
	}
	
	class IScrollBarUI extends BasicScrollBarUI{
		 public IScrollBarUI(){
		  super();
		 }

		 protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		  int width = thumbBounds.width;
		  int height = thumbBounds.height;
		  Graphics2D g2 = (Graphics2D)g;
		  g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		          RenderingHints.VALUE_ANTIALIAS_ON);
		  
		  g2.translate(thumbBounds.x, thumbBounds.y);
		  g2.setColor(XUtil.defaultComboBoxBoundsColor);
		  g2.drawRoundRect(1,1,width-2, height-2,5,5);
		  
		  g2.setColor(Color.ORANGE);
		  g2.drawLine(3,height/2,width-4,height/2);
		  g2.drawLine(3,height/2+3,width-4,height/2+3);
		  g2.translate(-thumbBounds.x, -thumbBounds.y);
		 }

		 protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		  g.setColor(XUtil.defaultComboBoxColor);
		  int x = trackBounds.x;
		  int y = trackBounds.y;
		  int width = trackBounds.width;
		  int height = trackBounds.height;
		  Graphics2D g2 = (Graphics2D)g;
		  g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		          RenderingHints.VALUE_ANTIALIAS_ON);
		  g2.setComposite(AlphaComposite
		    .getInstance(AlphaComposite.SRC_OVER, 0.1f));
		  
		  g2.fill3DRect(x, y, width, height, true);
		  g2.setComposite(AlphaComposite
		    .getInstance(AlphaComposite.SRC_OVER, 1f));
		  g2.setColor(XUtil.defaultComboBoxBoundsColor.brighter());
		  g2.fill3DRect(x, y, 1, height+1, true);
		  if(trackHighlight == DECREASE_HIGHLIGHT) {
		      paintDecreaseHighlight(g);
		  } 
		  else if(trackHighlight == INCREASE_HIGHLIGHT)  {
		      paintIncreaseHighlight(g);
		  }
		 }

		 protected JButton createIncreaseButton(int orientation) {
		  JButton button = new BasicArrowButton(orientation){
		   public void paint(Graphics g) {
		    Graphics2D g2 = (Graphics2D)g;
		    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		            RenderingHints.VALUE_ANTIALIAS_ON);
		    g2.setColor(XUtil.defaultComboBoxBoundsColor);
		    g2.drawLine(0,0,0,getHeight());
		    g2.drawLine(0,0,getWidth(),0-1);
		    g2.drawImage(((ImageIcon)XUtil.defaultComboBoxArrowIcon_Into).getImage(),-1,0,null);
		   }
		  };
		  button.setOpaque(false);
		  return button;
		 }

		 protected JButton createDecreaseButton(int orientation) {

		  
		  JButton button = new BasicArrowButton(orientation){
		   public void paint(Graphics g) {
		    Graphics2D g2 = (Graphics2D)g;
		    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		            RenderingHints.VALUE_ANTIALIAS_ON);
		    g2.setColor(XUtil.defaultComboBoxBoundsColor);
		    g2.drawLine(0,0,0,getHeight());
		    g2.drawLine(0,getHeight()-1,getWidth(),getHeight());
		    g2.drawImage(((ImageIcon)XUtil.defaultComboBoxArrowIcon_Into).getImage(),-1,0,null);
		   }
		  };
		  button.setOpaque(false);
		  return button;
		 }
		}*/
}