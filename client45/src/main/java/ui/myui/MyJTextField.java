package ui.myui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.RenderingHints.Key;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import ui.image.CommonImage;

/**
 * 输入框
 * 
 * @author czw
 * @time 2015年11月17日下午10:42:28
 */
public class MyJTextField extends JTextField {
	private static final long serialVersionUID = 1L;

	private Image background = null;

	/**
	 * 无缺省值
	 * 
	 * @param x
	 *            横坐标
	 * @param y
	 *            纵坐标
	 * @param width
	 *            宽度
	 * @param height
	 *            高度
	 */
	public MyJTextField(int x, int y, int width, int height) {
		this(x, y, width, height, null);
	}

	/**
	 * 有缺省值
	 * 
	 * @param x
	 *            横坐标
	 * @param y
	 *            纵坐标
	 * @param width
	 *            宽度
	 * @param height
	 *            高度
	 * @param text
	 *            缺省值
	 * @param fontSize
	 *            字体大小
	 */
	public MyJTextField(int x, int y, int width, int height, String text) {
		this.setBounds(x, y, width, height);
		this.setFont(new MyFont(15));
		this.setForeground(new Color(0,0,0,0.6f));
		this.setText(text);
		this.setVisible(true);
		
		// 调整文本起始位置
		this.setPreferredSize(new Dimension(200, 25));
		Border empty = new EmptyBorder(0, 10, 0, 0);
		this.setBorder(empty);

		this.setOpaque(false);

		Image selected = CommonImage.getTEXTFIELD_SELECTED();
		Image unselected = CommonImage.getTEXTFIELD_UNSELECTED();
		background = unselected;
		this.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				background = unselected;
				MyJTextField.this.repaint();
			}

			public void focusGained(FocusEvent e) {
				background = selected;
				MyJTextField.this.repaint();
			}
		});
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		HashMap<Key, Object> mapH = new HashMap<Key, Object>();
		// 色差
		mapH.put(RenderingHints.KEY_ALPHA_INTERPOLATION,
				RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		// 抗锯齿
		mapH.put(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
		mapH.put(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		// 呈现质量开关
		mapH.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		// 抖动形状
		mapH.put(RenderingHints.KEY_DITHERING,
				RenderingHints.VALUE_DITHER_ENABLE);
		g2d.setRenderingHints(mapH);
		g2d.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), 0,
				0, background.getWidth(null), background.getHeight(null), null);
		super.paintComponent(g);
		this.repaint();
	}

	// ==========================================================
	/**
	 * 设置只可输入小数
	 */
	public void setOnlyDouble() {
		this.setDocument(new DoubleDocument());
	}

	/**
	 * 设置只可输入整数
	 * 
	 * @param bitNum
	 *            最大位数
	 */
	public void setOnlyInteger(int bitNum) {
		this.setDocument(new NumberLenghLimited(bitNum));
	}

	/**
	 * 使输入满足格式yyyy-MM-dd.
	 */
	public void setForDate() {
		this.setDocument(new DateDocument());
	}

	/**
	 * 使输入满足格式yyyy-MM-dd-HH-mm.
	 */
	public void setForTime() {
		this.setDocument(new TimeDocument());
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

	private class DateDocument extends PlainDocument {
		private static final long serialVersionUID = 1L;

		public void insertString(int offset, String str,
				AttributeSet attributeSet) throws BadLocationException {
			if (str == null) {
				return;
			}

			int flag = 0;
			if (getLength() <= 4) {
				flag = 2;
			} else if (getLength() <= 7) {
				flag = 1;
			}
			String s = "";
			for (char c : str.toCharArray()) {
				if ((c >= '0') && (c <= '9')) {
					s += c;
				}
			}

			int length = getLength() + s.length() + flag;
			if (length <= 10) {
				if ((flag == 2) && (length >= 6)) {
					s = s.substring(0, 4 - getLength()) + "-"
							+ s.substring(4 - getLength());
					flag--;
				}

				if ((flag == 1) && (length >= 8)) {
					s = s.substring(0, 7 - getLength()) + "-"
							+ s.substring(7 - getLength());
					flag--;
				}
				super.insertString(offset, s, attributeSet);
			}
		}
	}

	private class TimeDocument extends PlainDocument {
		private static final long serialVersionUID = 1L;

		public void insertString(int offset, String str,
				AttributeSet attributeSet) throws BadLocationException {
			if (str == null) {
				return;
			}

			int flag = 0;
			if (getLength() <= 4) {
				flag = 4;
			} else if (getLength() <= 7) {
				flag = 3;
			} else if (getLength() <= 10) {
				flag = 2;
			} else if (getLength() <= 13) {
				flag = 1;
			}
			String s = "";
			for (char c : str.toCharArray()) {
				if ((c >= '0') && (c <= '9')) {
					s += c;
				}
			}

			int length = getLength() + s.length() + flag;
			if (length <= 16) {
				if ((flag == 4) && (length >= 8)) {
					s = s.substring(0, 4 - getLength()) + "-"
							+ s.substring(4 - getLength());
					flag--;
				}

				if ((flag == 3) && (length >= 10)) {
					s = s.substring(0, 7 - getLength()) + "-"
							+ s.substring(7 - getLength());
					flag--;
				}

				if ((flag == 2) && (length >= 12)) {
					s = s.substring(0, 10 - getLength()) + "-"
							+ s.substring(10 - getLength());
					flag--;
				}

				if ((flag == 1) && (length >= 14)) {
					s = s.substring(0, 13 - getLength()) + ":"
							+ s.substring(13 - getLength());
					flag--;
				}
				super.insertString(offset, s, attributeSet);
			}
		}
	}
}