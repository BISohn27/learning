package XML;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;


public class SAXParser {
	public void parseXMLBySAX(String path) {
		File file = new File(path);
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		try {
			javax.xml.parsers.SAXParser parser = factory.newSAXParser();
			AddressBookSaxHandler handler = new AddressBookSaxHandler();
			parser.parse(file, handler);
			
			List<AddressBook> list = handler.getAddressBookList();
			
			for(AddressBook ab : list) {
				System.out.println(ab);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
