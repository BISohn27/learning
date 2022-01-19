package XML;

public class AddressBook {
	private String name;
	private String department;
	private String position;
	private String phone;
	
	public String getName() {
		return name;
	}
	public AddressBook setName(String name) {
		this.name = name;
		
		return this;
	}
	public String getDepartment() {
		return department;
	}
	public AddressBook setDepartment(String department) {
		this.department = department;
		
		return this;
	}
	public String getPosition() {
		return position;
	}
	public AddressBook setPosition(String position) {
		this.position = position;
		
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public AddressBook setPhone(String phone) {
		this.phone = phone;
		
		return this;
	}
	
	@Override
	public String toString() {
		return "�̸�: " + this.name + ", �μ�: " + this.department + ", ��å: " + this.position + ", ��ȭ��ȣ: " + this.phone + "\n";
	}
}
