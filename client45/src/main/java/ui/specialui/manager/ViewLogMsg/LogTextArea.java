package ui.specialui.manager.ViewLogMsg;

import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import util.GetDate;
/**
 * 负责显示记录日志详细信息的文本框区域
 * @author zsq
 * @version 2015/12/05 15:14
 */
public class LogTextArea extends JScrollPane{
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private String title;
	/** 真正的TextArea在这 */
	private JTextArea textArea;

	public LogTextArea() {
		this.setOpaque(false);	// 将JScrollPane设置为透明
		this.getViewport().setOpaque(false);	// 将中间的viewport设置为透明
		this.addMouseWheelListener(new WheelListener()); // 设置鼠标滚轮监听
		this.addTextArea();	// 添加文本域
		this.setBorder();	// 设置边框
		this.modifyScrollBar();	// 修改滚动条样式
	}

	private void modifyScrollBar() {
		JScrollBar bar = this.getVerticalScrollBar();
		bar.setBackground(Color.LIGHT_GRAY);
		bar.setOpaque(false);
		bar.setBorder(new EmptyBorder(0, 0, 0, 0));
	}

	private void addTextArea() {
		textArea = new JTextArea();
		textArea.setForeground(Color.WHITE);
		//TODO 显示logmessage的信息
		textArea.setLineWrap(true);
		textArea.setFont(getFont());
		textArea.setOpaque(false);
		textArea.setEditable(false);
		this.setViewportView(textArea);
	}

	private void setBorder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 title = sdf.format(GetDate.getDate()); // 初始化标题为当前日期
		this.setBorder(null);
	}

	public void setTitle(String title) {
		this.title = title;
		this.setBorder(null);
		this.repaint();
	}

	/**
	 * 将logmessage显示 TODO 连接bl层
	 */
	@SuppressWarnings("rawtypes")
	public void append(ArrayList logs) {
		
	}

	public void append(String text) {
		textArea.append(text);
	}

	public void setText(String text) {
		textArea.setText(text);
	}

	private class WheelListener implements MouseWheelListener {

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			JScrollBar onlineFriendsBar = LogTextArea.this.getVerticalScrollBar();
			if (!((onlineFriendsBar.getValue() == onlineFriendsBar.getMinimum() && e.getWheelRotation() <= 0) || (onlineFriendsBar.getValue() == onlineFriendsBar.getMaximum() && e.getWheelRotation() >= 0))) {
				if (onlineFriendsBar.getValue() + onlineFriendsBar.getUnitIncrement() * e.getUnitsToScroll() * 2 >= onlineFriendsBar.getMaximum()) {
					onlineFriendsBar.setValue(onlineFriendsBar.getMaximum());
				} else if (onlineFriendsBar.getValue() + onlineFriendsBar.getUnitIncrement() * e.getUnitsToScroll() * 2 <= onlineFriendsBar.getMinimum()) {
					onlineFriendsBar.setValue(onlineFriendsBar.getMinimum());
				} else {
					onlineFriendsBar.setValue(onlineFriendsBar.getValue() + onlineFriendsBar.getUnitIncrement()
												* e.getUnitsToScroll() * 10);
				}
			}
		}
	}
}
