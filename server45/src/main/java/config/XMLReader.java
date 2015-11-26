package config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLReader {
	private Element root;
	private Document doc;
	private File file;
	public XMLReader(String string) {
		try {
			SAXReader reader = new SAXReader();
			file=new File(string);
			doc = reader.read(file);
			root = doc.getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public String getValue(String key) {
		return root.attributeValue(key);
	}
	
	public void setValue(String key,String value){
		Attribute attribute=root.attribute(key);
		if(attribute==null)
			root.addAttribute(key, value);
		else {
			root.remove(attribute);
			root.addAttribute(key, value);
		}
		
		try {
			this.saveDocument(doc, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveDocument(Document document,File xmlFile) throws IOException{  
		Writer osWrite=new OutputStreamWriter(new FileOutputStream(xmlFile));//创建输出流  
		OutputFormat format = OutputFormat.createPrettyPrint();  //获取输出的指定格式    
		format.setEncoding("UTF-8");//设置编码 ，确保解析的xml为UTF-8格式  
		XMLWriter writer = new XMLWriter(osWrite,format);//XMLWriter 指定输出文件以及格式    
		writer.write(document);//把document写入xmlFile指定的文件(可以为被解析的文件或者新创建的文件)    
		writer.flush();  
		writer.close();  
	}
	

}
