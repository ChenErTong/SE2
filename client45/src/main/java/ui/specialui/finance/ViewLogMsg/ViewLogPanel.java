package ui.specialui.finance.ViewLogMsg;

import ui.myui.MyJButton;
import ui.myui.MyJPanel;
import ui.myui.MyJTextField;
import ui.specialui.finance.Frame_Finance;
import ui.specialui.manager.FrameManager;
import ui.specialui.manager.ViewLogMsg.LogTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
@SuppressWarnings("unused")
public class ViewLogPanel extends MyJPanel{
	private DateLabel[] dateLabel;
	private InputField[] input;
	private Point inPanelPoint = new Point(0,25);
	public ViewLogPanel(Frame_Finance frame_Finance) {
		super(0, 25, 1280, 720-25);
		this.setOpaque(false);
	}
	private static final long serialVersionUID = 1L;
	
	
	private MyJButton search, showAll;
	/** 标签、输入框、按钮之间的间隙 */
	private int interval = 20;

	/** 显示日志 */
	private LogTextArea logText;
	/** 显示日志的TextArea与界面的内边距 */
	private int padding = 72;
	/** 输入panel的大小 */
	private Dimension inPanelDimen = new Dimension(80, 82);
	private Point logTextPoint = new Point(padding, inPanelPoint.y + inPanelDimen.height);
	private Dimension logTextSize = new Dimension(1280- padding * 2, 480);

	public ViewLogPanel() {
		super(0,0,0,0);
		this.setOpaque(false);
		this.setLayout(null);
		this.addInputPanel();
		this.addLogText();
	}
	public ViewLogPanel(FrameManager frameManager) {
		super(0, 25, 1280, 720-25);
		this.setOpaque(false);
	}
	
	class DateLabel extends JLabel {

		private static final long serialVersionUID = 11733136455717335L;

		public DateLabel(String Text) {
			super(Text, JLabel.LEFT);
			this.setFont(getFont());
		}
	}
	
	/**
	 * 添加日志信息
	 */
	private void addLogText() {
		logText = new LogTextArea();
		logText.setLocation(logTextPoint);
		logText.setSize(logTextSize);
		this.add(logText, BorderLayout.CENTER);
	}
	private void addInputPanel() {
		InputPanel inPanel = new InputPanel();
		inPanel.setLocation(inPanelPoint);
		inPanel.setSize(inPanelDimen);
		this.add(inPanel, BorderLayout.NORTH);
	}
	private class InputPanel extends JPanel {
		
		private static final long serialVersionUID = -1836768806430466838L;

		public InputPanel() {
			this.setOpaque(false);
			this.setLayout(new FlowLayout(FlowLayout.CENTER, interval, interval));
			this.addInput();
			this.addButton();
		}
		
	/**
	 * 添加输入日期的输入框
	 */
	private void addInput() {
		dateLabel = new DateLabel[3];
		input = new InputField[3];
		SimpleDateFormat[] sdf = new SimpleDateFormat[3];
		String[] date_s = {"年", "月", "日"};
		String[] dateFormat = {"yyyy", "MM", "dd"};
		Date curDate = new Date();
		// 初始化输入框，设置标签和输入框的位置，并且添加标签和输入框
		for(int i = 0; i < dateLabel.length; i++) {
			dateLabel[i] = new DateLabel(date_s[i]);
			sdf[i] = new SimpleDateFormat(dateFormat[i]);
			input[i] = new InputField();
			input[i].setText(sdf[i].format(curDate));
			input[i].setFont(getFont());
			input[i].setHorizontalAlignment(JTextField.CENTER);
			this.add(input[i]);
			this.add(dateLabel[i]);
		}
	}
	
	/**
	 * 添加查询和显示全部按钮
	 */
	private void addButton() {
		search = new MyJButton(0,0,0,0,"查询",18);
		this.add(search);
		showAll = new MyJButton(0,0,0,0,"显示全部",18);

		this.add(showAll);
	}
}
	
	class InputField extends TextField {

		private static final long serialVersionUID = -7461764475544506463L;
		
		public InputField() {
			
		}

		public void setHorizontalAlignment(int center) {
			// TODO Auto-generated method stub
			
		}

	
	}
}
