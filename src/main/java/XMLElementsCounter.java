import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class XMLElementsCounter {
    private static Map<String, Integer> nodeNameToOccurrencesNumber = new LinkedHashMap<>();

    public void count(String filePath) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.parse(filePath);
            NodeList nodeList = document.getElementsByTagName("*");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    String nodeName = node.getNodeName();
                    nodeNameToOccurrencesNumber.compute(nodeName, (k, val) -> Optional.ofNullable(val).map(v -> v + 1).orElse(1));
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException pce) {
            throw new RuntimeException("We got an exception while counting elements in the xml... " +
                    "Please, check if the filepath is valid and the file contains xml structure");
        }
    }

    public Map<String, Integer> getNodeNameToOccurrencesNumber() {
        return nodeNameToOccurrencesNumber;
    }
}