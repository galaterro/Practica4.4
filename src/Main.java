import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;



public class Main {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "company", null);
            document.setXmlVersion("1.0");
            Element root = document.getDocumentElement();


            Element staff = document.createElement("staff");

            Element firstName = document.createElement("firstname");
            Text nodeChildValue = document.createTextNode("yong");
            firstName.appendChild(nodeChildValue);

            Element lastName = document.createElement("lastname");
            Text textNode = document.createTextNode("mook kim");
            lastName.appendChild(textNode);

            Element nickName = document.createElement("nickname");
            Text textNode1 = document.createTextNode("mkyong");
            nickName.appendChild(textNode1);

            Element salary = document.createElement("salary");
            Text textNode2 = document.createTextNode("199999");
            salary.appendChild(textNode2);

            staff.setAttribute("id", "1");
            staff.appendChild(firstName);
            staff.appendChild(lastName);
            staff.appendChild(nickName);
            staff.appendChild(salary);


            Element staff2 = document.createElement("staff2");

            Element firstName2 = document.createElement("firstname");
            Text nodeChildValue2 = document.createTextNode("low");
            firstName2.appendChild(nodeChildValue2);

            Element lastName2 = document.createElement("lastname");
            Text textNode3 = document.createTextNode("yin fong");
            lastName2.appendChild(textNode3);

            Element nickName2 = document.createElement("nickname");
            Text textNode4 = document.createTextNode("fong fong");
            nickName2.appendChild(textNode4);

            Element salary2 = document.createElement("salary");
            Text textNode5 = document.createTextNode("188888");
            salary2.appendChild(textNode5);

            staff2.setAttribute("id", "2");
            staff2.appendChild(firstName2);
            staff2.appendChild(lastName2);
            staff2.appendChild(nickName2);
            staff2.appendChild(salary2);

            root.appendChild(staff);
            root.appendChild(staff2);

            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("salida.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
