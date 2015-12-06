package ui.Config;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 * 解析uiconfig包里面的省市区xml文件
 * @author zsq
 * @time 2015/11/21 14:20
 */
public class UiConfig_JComboBox {
	  /**
	   * 根据某个城市获取此省市的所有地区
	   * @param districts
	   * @return
	   */
	  /*public static List<String> getDistricts(String districts) {
	    List<String> list = new ArrayList<String>();
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    try {
	      factory.setIgnoringElementContentWhitespace(true);
	      
	      DocumentBuilder db = factory.newDocumentBuilder();
	      Document xmldoc = db.parse(new File("xml/Districts.xml"));
	      Element root = xmldoc.getDocumentElement();
	      
	      NodeList nodes = selectNodes("//District[@city='"+districts+"']", root);
	      for(int i=0; i<nodes.getLength(); i++) {
	        Node node = nodes.item(i);
	        String name = node.getTextContent();
	        list.add(name);
	      }
	    } catch (ParserConfigurationException e) {
	      e.printStackTrace();
	    } catch (SAXException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    return list;
	  }*/
	  
	  /**
	   * 根据某个省份的名字获取此省份的所有城市
	   * @param provinces
	   * @return
	   */
	  public static List<String> getCities(String provinces) {
	    List<String> list = new ArrayList<String>();
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    try {
	      factory.setIgnoringElementContentWhitespace(true);
	      
	      DocumentBuilder db = factory.newDocumentBuilder();
	      Document xmldoc = db.parse(new File("uiconfigs/Cities.xml"));
	      Element root = xmldoc.getDocumentElement();
	      
	      NodeList nodes = selectNodes("//City[@Province='"+provinces+"']", root);
	      for(int i=0; i<nodes.getLength(); i++) {
	        Node node = nodes.item(i);
	        String name = node.getTextContent();
	        list.add(name);
	      }
	    } catch (ParserConfigurationException e) {
	      e.printStackTrace();
	    } catch (SAXException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    return list;
	  }
	  
	  /**
	   * 获取所有省份
	   * @return 
	   */
	  public static List<String> getProvinces() {
	    List<String> list = new ArrayList<String>();
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    try {
	      factory.setIgnoringElementContentWhitespace(true);
	      
	      DocumentBuilder db = factory.newDocumentBuilder();
	      Document xmldoc = db.parse(new File("uiconfigs/Provinces.xml"));
	      Element root = xmldoc.getDocumentElement();
	      
	      NodeList nodes = selectNodes("/Provinces/Province", root);
	      for(int i=0; i<nodes.getLength(); i++) {
	        Node node = nodes.item(i);
	        String name = node.getTextContent();
	        list.add(name);
	      }
	    } catch (ParserConfigurationException e) {
	      e.printStackTrace();
	    } catch (SAXException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    return list;
	  }

	  /**
	   * 根据xpath获取某一个节点
	   * @param express
	   * @param source
	   * @return
	   */
	  public static Node selectSingleNode(String express, Object source) {// 查找节点，并返回第一个符合条件节点
	    Node result = null;
	    XPathFactory xpathFactory = XPathFactory.newInstance();
	    XPath xpath = xpathFactory.newXPath();
	    try {
	      result = (Node) xpath
	          .evaluate(express, source, XPathConstants.NODE);
	    } catch (XPathExpressionException e) {
	      e.printStackTrace();
	    }

	    return result;
	  }

	  /**
	   * 根据xpath获取符合条件的所有节点
	   * @param express
	   * @param source
	   * @return
	   */
	  public static NodeList selectNodes(String express, Object source) {// 查找节点，返回符合条件的节点集。
	    NodeList result = null;
	    XPathFactory xpathFactory = XPathFactory.newInstance();
	    XPath xpath = xpathFactory.newXPath();
	    try {
	      result = (NodeList) xpath.evaluate(express, source,
	          XPathConstants.NODESET);
	    } catch (XPathExpressionException e) {
	      e.printStackTrace();
	    }

	    return result;
	  }
	}

