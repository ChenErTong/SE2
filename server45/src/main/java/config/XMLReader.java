package config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLReader {
	private Element root;
	private Document doc;
	public XMLReader(String string) {
		try {
			SAXReader reader = new SAXReader();
			doc = reader.read(string);
			root = doc.getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public String getValue(String key) {
		return root.attributeValue(key);
	}
	
//	public void setValue(String key,String value){
//		doc.setRootElement(root.addAttribute(key, value));
//		SAXWriter writer = new SAXWriter();
//		try {
//			writer.write(doc);
//		} catch (SAXException e) {
//			e.printStackTrace();
//		}
//	}
	

}
