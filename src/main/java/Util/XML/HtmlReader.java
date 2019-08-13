package Util.XML;

import SwordOffer.LoopAndRecursion.Fibonacci;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;

public class HtmlReader {
    public void readXMLFile(String fileName) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        File file = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        Document document = documentBuilder.parse(fileInputStream);
        NodeList body = document.getElementsByTagName("table class=\"table table-hover table-bordered\"");
        Node meta = body.item(1);
        NodeList childNodes = meta.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            Node item = node.getChildNodes().item(0).getChildNodes().item(0);
            System.out.println(item.getTextContent());
        }
    }

    public static void main(String[] args) {
        HtmlReader htmlReader = new HtmlReader();
        try {
            htmlReader.readXMLFile("C:\\Users\\mabyo\\Desktop\\html1.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
