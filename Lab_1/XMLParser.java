import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class XMLParser {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("patient_details.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            
            NodeList patientList = doc.getElementsByTagName("data");
            
            System.out.println("<table border='1'>");
            System.out.println("<tr><th>Name</th><th>Age</th><th>Gender</th></tr>");
            
            for (int temp = 0; temp < patientList.getLength(); temp++) {
                Node patientNode = patientList.item(temp);
                
                if (patientNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element patientElement = (Element) patientNode;
                    String name = patientElement.getElementsByTagName("name").item(0).getTextContent();
                    String age = patientElement.getElementsByTagName("age").item(0).getTextContent();
                    String gender = patientElement.getElementsByTagName("gender").item(0).getTextContent();
                    
                    System.out.println("<tr><td>" + name + "</td><td>" + age + "</td><td>" + gender + "</td></tr>");
                }
            }
            
            System.out.println("</table>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
