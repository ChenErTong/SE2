package ui.myui;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
/**
 * 输入框
 * @author czw
 * @time 2015年11月17日下午10:42:28
 */
public class MyJTextField extends JTextField{
	private static final long serialVersionUID = 1L;
	/**
	 * 无缺省值
	 * @param x 横坐标
	 * @param y 纵坐标
	 * @param width 宽度
	 * @param height 高度
	 */
	public MyJTextField(int x, int y, int width, int height){
		this(x, y, width, height, null);
	}
	
	/**
	 * 有缺省值
	 * @param x 横坐标
	 * @param y 纵坐标
	 * @param width 宽度
	 * @param height 高度
	 * @param text 缺省值
	 * @param fontSize 字体大小
	 */
	public MyJTextField(int x, int y, int width, int height, String text){
		this.setBounds(x, y, width, height);
		this.setFont(new MyFont(15));
		this.setForeground(Color.BLACK);
		this.setText(text);
		this.setVisible(true);
	}
	
	/**
	 * 设置只可输入小数
	 */
	public void setOnlyDouble(){
		this.setDocument(new DoubleDocument());
	}
	
	/**
	 * 设置只可输入整数
	 * @param bitNum 最大位数
	 */
	public void setOnlyInteger(int bitNum){
		this.setDocument(new NumberLenghLimited(bitNum));
	}
	
	private class DoubleDocument extends PlainDocument {  
	      
	    private static final long serialVersionUID = 1L;  
	    private String reg = "^[0-9]+([.]{1}[0-9]+){0,1}$";  
	    public void insertString(int offset, String s, AttributeSet attributeSet)  
	            throws BadLocationException {  
	  
	        if (offset == 0 && s.equals(".")) {  
	  
	            Toolkit.getDefaultToolkit().beep();  
	            return;  
	        }  
	        String str = this.getText(0, this.getLength()) + s;  
	        int i = this.getText(0, this.getLength()).indexOf(".");  
	        if (i == -1 && str.endsWith(".")) {  
	            super.insertString(offset, s, attributeSet);  
	            return;  
	        }  
	        if (str.matches(reg)) {  
	            super.insertString(offset, s, attributeSet);  
	        } else {  
	            Toolkit.getDefaultToolkit().beep();  
	        }  
	    }  
	}
	
	private class NumberLenghLimited extends PlainDocument {
		private static final long serialVersionUID = 1L;
		private int limit;

		public NumberLenghLimited(int limit) {
			super();
			this.limit = limit;
		}

		public void insertString(int offset, String str, AttributeSet attr)
				throws BadLocationException {
			if (str == null) {
				return;
			}
			if ((getLength() + str.length()) <= limit) {

				char[] upper = str.toCharArray();
				int length = 0;
				for (int i = 0; i < upper.length; i++) {
					if (upper[i] >= '0' && upper[i] <= '9') {
						upper[length++] = upper[i];
					}
				}
				super.insertString(offset, new String(upper, 0, length), attr);
			}
		}
	}
}