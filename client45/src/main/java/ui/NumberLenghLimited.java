package ui;

import javax.swing.text.*;

/**
 * 文本输入框只能输入数字并可以限制长度
 * 用法：MyJTextField.setDocument(new NumberLenghtLimited(int numberLength));
 * @author czw
 * @time 2015年11月17日下午11:03:19
 */
public class NumberLenghLimited extends PlainDocument {
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