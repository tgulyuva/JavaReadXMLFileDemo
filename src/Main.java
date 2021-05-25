import ReadXml.Models.RecordModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.readXML();

        }

    private void readXML()
    {
        Document doc = null;
        try
        {
            doc = parseXML("src/country_populations.xml");
        }
        catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (SAXException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        if(doc != null)
        {
            ArrayList<RecordModel> allCases = new ArrayList<RecordModel>();
            NodeList nList = doc.getElementsByTagName("record");
            for (int i = 0; i < nList.getLength(); i++)
            {
                Node nNode = nList.item(i);
                Element eElement = (Element) nNode;
                RecordModel data = new RecordModel();

                Element nameElement =  (Element) eElement.getElementsByTagName("field").item(0);

                data.name=nameElement.getFirstChild().getTextContent();
                data.key =nameElement.getAttribute("key").toString();

                System.out.println("Name : " + nameElement.getFirstChild().getTextContent());
                System.out.println("Key : " + nameElement.getAttribute("key").toString());

                Element countryElement =  (Element) eElement.getElementsByTagName("field").item(1);
                System.out.println("Country : " + countryElement.getFirstChild().getTextContent());
                data.country= countryElement.getFirstChild().getTextContent();

                Element yearElement =  (Element) eElement.getElementsByTagName("field").item(2);
                System.out.println("Year : " + yearElement.getFirstChild().getTextContent());
                data.year= yearElement.getFirstChild().getTextContent();

                Element valueElement =  (Element) eElement.getElementsByTagName("field").item(3);
                System.out.println("Value : " + valueElement.getFirstChild().getTextContent());
                data.value= valueElement.getFirstChild().getTextContent();

                Element categoryElement =  (Element) eElement.getElementsByTagName("field").item(4);
                System.out.println("Category : " + categoryElement.getFirstChild().getTextContent());
                data.category= categoryElement.getFirstChild().getTextContent();

                allCases.add(data);

                System.out.println("----------------------------------------------");
            }
        }
    }

    private Document parseXML(String filePath) throws ParserConfigurationException, SAXException, IOException
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(filePath);
        doc.getDocumentElement().normalize();
        return doc;
    }
}

