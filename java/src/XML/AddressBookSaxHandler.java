package XML;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

public class AddressBookSaxHandler extends DefaultHandler{
	private List<AddressBook> addressBookList;
	private AddressBook addressBook;
	private String str;
	
	public AddressBookSaxHandler() {
		addressBookList = new ArrayList<>();
	}
	
	@Override
	public void startElement(String uri, String localName, String name, Attributes att) {
		if(name.equals("worker")) {
			addressBook = new AddressBook();
			addressBookList.add(addressBook);
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String name) {
		if(name.equals("name")) {
			addressBook.setName(str);
		} else if(name.equals("department")) {
			addressBook.setDepartment(str);
		} else if(name.equals("position")) {
			addressBook.setPosition(str);
		} else if(name.equals("phone")) {
			addressBook.setPhone(str);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) {
		str = new String(ch,start,length);
	}
	
	public List<AddressBook> getAddressBookList() {
		return addressBookList;
	}
	
	public void setAddressBookList(List<AddressBook> addressBookList) {
		this.addressBookList = addressBookList;
	}
}
