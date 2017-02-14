package simple;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class AppMain {

	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			CustomHandler handler = new CustomHandler();
			XMLReader xmlReader = parser.getXMLReader();
			xmlReader.setContentHandler(handler);
			xmlReader.parse("/Users/KAI/servjsp/SAXParser-Simple/src/simple/Employee.xml");
			
//			parser.parse("/Users/KAI/servjsp/SAXParser-Simple/src/simple/Employee.xml", handler);
			
			
			List<Employee> employees = handler.getEmployees();
			employees.forEach(employee -> {
				System.out.println(employee.toString());
			});
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
