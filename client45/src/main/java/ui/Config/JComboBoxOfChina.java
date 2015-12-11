package ui.Config;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import ui.myui.MyJComboBox;
/**
 * 实现下拉框省市区三级联动的类
 * @author zsq
 * @time 2015/11/21 14:35
 */
@SuppressWarnings({"rawtypes","unchecked","unused"})
public class JComboBoxOfChina {
	
	
	private MyJComboBox combobox_privince;
	
	private MyJComboBox combobox_city;

	private MyJComboBox combobox_area;
	
	private DefaultComboBoxModel model1 = new DefaultComboBoxModel();
	  private DefaultComboBoxModel model2 = new DefaultComboBoxModel();
	  private DefaultComboBoxModel model3 = new DefaultComboBoxModel();
	  
	  
	
	public JComboBoxOfChina() {
	    //设置省市区三级联动数据
	        //设置第一级数据，从xml里面获取数据
	    for(String str : UiConfig_JComboBox.getProvinces()) {
	      model1.addElement(str);
	    }
	    combobox_privince = new MyJComboBox(model1);
	    combobox_privince.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent evt) {
	        JComboBox source = (JComboBox) evt.getSource();
	        //根据获取的省份找到它下面的级别的市
	        String provinces = (String) source.getSelectedItem();
	        List<String> cities = UiConfig_JComboBox.getCities(provinces);
	        model2.removeAllElements();
	        for (String str : cities) {
	          model2.addElement(str);
	        }
	     
	      }
	    });
	    //设置二级数据
	    for (String str : UiConfig_JComboBox.getCities("北京市")) {
	      model2.addElement(str);
	    }
	    combobox_city = new MyJComboBox(model2);
	    combobox_city.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent evt) {
	        JComboBox source = (JComboBox) evt.getSource();
	        String city = (String) source.getSelectedItem();
	 
	      }
	    });
	   
	    combobox_area = new MyJComboBox(model3);
	  }

	  public JComboBox getCombobox_privince() {
	    return combobox_privince;
	  }

	  public JComboBox getCombobox_city() {
	    return combobox_city;
	  }

	  public JComboBox getCombobox_area() {
	    return combobox_area;
	  }
}

