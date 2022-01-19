package XML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParserXML {
	public void parseXML(String path) {
		File xml = new File(path);
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = factory.newDocumentBuilder();
			Document doc = docBuilder.parse(xml);
			
			Element addressBook = doc.getDocumentElement();
			System.out.println("Root node is " + addressBook.getNodeName());
			
			NodeList children = addressBook.getChildNodes();
			for(int i = 0; i<children.getLength(); i++) {
				Node node = children.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element)node;
					String nodeName = element.getNodeName();
					System.out.println("Node Name is " + nodeName);
					System.out.println(nodeName + "'s value is " + element.getTextContent());
					System.out.println();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
