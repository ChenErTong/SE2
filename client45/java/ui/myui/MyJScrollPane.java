package ui.myui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

public class MyJScrollPane extends JScrollPane {
	private static final long serialVersionUID = 1L;

	public MyJScrollPane(int x, int y, int width, int height, Component view){
		super(view);
		this.setBounds(x, y, width, height);
		this.getViewport().setBackground(new Color(0,0,0,0.3f));
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setVisible(true);
	}
}
