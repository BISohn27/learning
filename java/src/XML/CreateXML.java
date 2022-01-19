package XML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXML {
	public Document createAddressbookXML(String workerDepartment,String workerName, String workerPosition, String workerPhone) {
		
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.newDocument();
			
			Element addressBook = doc.createElement("addressbook");
			doc.appendChild(addressBook);
			
			Element worker = doc.createElement("worker");
			addressBook.appendChild(worker);
			
			Element name = doc.createElement("name");
			worker.appendChild(doc.createTextNode(workerName));
			worker.appendChild(name);
			
			Element department = doc.createElement("department");
			department.appendChild(doc.createTextNode(workerDepartment));
			worker.appendChild(department);
			
			Element position = doc.createElement("position");
			position.appendChild(doc.createTextNode(workerPosition));
			worker.appendChild(position);
			
			Element phone = doc.createElement("phone");
			phone.appendChild(doc.createTextNode(workerPhone));
			worker.appendChild(phone);
			
			return doc;
		} catch(ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
