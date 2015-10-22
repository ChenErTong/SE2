package ui.mainui;

import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton buttons[];
	
	public MainPanel(){
		initPanel();
	}

	private void initPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		initButtons();
		setVisible(true);
	}

	private void initButtons() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("tempUiConfig.txt"));
			ArrayList<String> buttonString = new ArrayList<>();
			String line="";
			while((line=br.readLine())!=null){
				buttonString.add(line);
				System.out.println(line);
			}
			int size=buttonString.size();
			System.out.println(size);
			buttons = new JButton[size];
			for (int i = 0; i < buttons.length; i++) {
				buttons[i]=new JButton();
				buttons[i].setText(buttonString.get(i));
//				buttons[i].addMouseListener();
				buttons[i].setVisible(true);
				this.add(buttons[i]);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
