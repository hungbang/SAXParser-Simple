package simple;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CustomHandler extends DefaultHandler{

List<Employee> employees = null;
	
	public List<Employee> getEmployees() {
		return employees;
	}
	Employee employee = null;
	
	
	boolean bFirstName = false;
	boolean bLastName = false;
	boolean bLocation = false;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("===uril: "+ uri + " localName: " + localName );
		if("Employee".equalsIgnoreCase(qName)){
			String id = attributes.getValue("id");
			employee = new Employee();
			employee.setId(id);
			if(employees == null){
				employees = new ArrayList<>();
			}
		}
		if("FirstName".equalsIgnoreCase(qName)){
			bFirstName = true;
		}
		else if("LastName".equalsIgnoreCase(qName)){
			bLastName = true;
		}
		else if("Location".equalsIgnoreCase(qName)){
			bLocation = true;
		}
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(bFirstName){
			employee.setFirstName(new String(ch, start, length));
			bFirstName = false;
		}
		if(bLastName){
			employee.setLastName(new String(ch, start, length));
			bLastName = false;
		}
		if(bLocation){
			employee.setLocation(new String(ch, start, length));
			bLocation = false;
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if("Employee".equalsIgnoreCase(qName)){
			employees.add(employee);
		}
	}
	
	
	
}
