import ReadXml.Models.RecordModel;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ReadXmlFiles readXmlFiles = new ReadXmlFiles();
        ArrayList<ArrayList<RecordModel>> ulkeler = readXmlFiles.readXML();
        System.out.println(ulkeler.get(1).get(3).year);
    }

}

