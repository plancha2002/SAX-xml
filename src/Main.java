
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{


            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File("../file.xml");
            Document doc = builder.parse(file);

            NodeList lista = doc.getElementsByTagName("student");

            for (int i = 0; i < lista.getLength(); i++) {
                Node nodo = lista.item(i);

                if (nodo.getNodeType() == nodo.ELEMENT_NODE){
                    Element elemento = (Element) nodo;

                    String rollno = elemento.getAttribute("rollno");

                    String firstname = elemento.getElementsByTagName("firstname").item(0).getTextContent();
                    String lastname = elemento.getElementsByTagName("lastname").item(0).getTextContent();
                    String nickname = elemento.getElementsByTagName("nickname").item(0).getTextContent();
                    Integer marks = Integer.valueOf(elemento.getElementsByTagName("marks").item(0).getTextContent());

                    System.out.println("rollno: " + rollno);
                    System.out.println("Nombre: " + firstname);
                    System.out.println("Apellido: "+ lastname);
                    System.out.println("apodo: "+ nickname);
                    System.out.println("NOtas: "+ marks);
                }

            }
        } catch (ParserConfigurationException | IOException | SAXException  e) {
            System.out.println(e.getMessage());
        }

    }}