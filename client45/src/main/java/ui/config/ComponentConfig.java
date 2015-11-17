package ui.config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ComponentConfig {
	public ComponentConfig(String address){
		SAXReader reader = new SAXReader();
		Document doc;
		try {
			doc = reader.read(address);
			Element ui = doc.getRootElement();
			Element label = ui.element("Label");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
