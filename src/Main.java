import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


import org.dom4j.xpath.DefaultXPath;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.Element;
import org.dom4j.Node;


public class Main {

    public static void main(String[] args) {
try {
    File inputFile = new File(args[0]);
    Document document = null;
    SAXReader saxReader = new SAXReader();
    document = saxReader.read(inputFile);
    DefaultXPath xpath = new DefaultXPath("//ns2:task");
    xpath.setNamespaceURIs(Collections.singletonMap("ns2", "http://www.ustcsoft.com"));
    List<Node> list = xpath.selectNodes(document);
    if (list.size() > 0) {
        for (int j = 0; j < list.size(); j++) {
            
            Element element = (Element) list.get(j);
            System.out.println(list.get(j).selectSingleNode("custname").getText());

            //遍歷
            for (Iterator<Element> it = element.elementIterator(); it.hasNext(); ) {
                Element element2 = it.next();
                String name = element2.getName();
                String content = element2.getText();
                System.out.println(name+":"+content);

            }

        }
    }
} catch (Exception e) {
    e.printStackTrace();
}

    }
}
