package config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:44:45
 */
public class XMLReader {
	private Element root;
	public XMLReader(String string) {
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(string);
			root = doc.getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public String getValue(String key) {
		return root.attributeValue(key);
	}

}
