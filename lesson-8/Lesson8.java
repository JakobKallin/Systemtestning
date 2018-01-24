import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class DocumentInfo {
    private String language;
    private List<String> stylesheets;
    private String title;
    private boolean hasDescription;
    private int paragraphCount;

    public DocumentInfo() {
        stylesheets = new ArrayList<String>();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getStylesheets() {
        return stylesheets;
    }

    public void addStylesheet(String stylesheet) {
        this.stylesheets.add(stylesheet);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean hasDescription() {
        return hasDescription;
    }

    public void setHasDescription(boolean hasDescription) {
        this.hasDescription = hasDescription;
    }

    public int getParagraphCount() {
        return paragraphCount;
    }

    public void setParagraphCount(int paragraphCount) {
        this.paragraphCount = paragraphCount;
    }
}

public class Lesson8 {
    public static DocumentInfo documentInfo(String xml) throws ParserConfigurationException, IOException, SAXException {
        InputSource input = new InputSource(new StringReader(xml));
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(input);
        DocumentInfo info = new DocumentInfo();

        if (doc.getElementsByTagName("h1").getLength() > 0) {
            info.setTitle(doc.getElementsByTagName("h1").item(0).getTextContent());
        }

        NodeList metas = doc.getElementsByTagName("meta");
        for (int i = 0; i < metas.getLength(); i++) {
            Element element = (Element) metas.item(i);
            if (element.hasAttribute("name") && element.getAttribute("name").equals("description")) {
                info.setHasDescription(true);
            }
        }

        NodeList links = doc.getElementsByTagName("link");
        for (int i = 0; i < links.getLength(); i++) {
            Element element = (Element) links.item(i);
            if (element.hasAttribute("rel") && element.getAttribute("rel").equals("stylesheet")) {
                info.addStylesheet(element.getAttribute("href"));
            }
        }

        info.setParagraphCount(doc.getElementsByTagName("p").getLength());

        if (doc.getDocumentElement().hasAttribute("lang")) {
            info.setLanguage(doc.getDocumentElement().getAttribute("lang"));
        }
        else {
            info.setLanguage("en");
        }

        return info;
    }

    public static boolean isPalindrome(String s1) {
        String s2 = s1.replaceAll("[^a-zA-Z]", "");
        String s3 = new StringBuilder(s2).reverse().toString();
        return s2.equals(s3);
    }

    public static double average(int[] numbers) {
        int sum = 0;
        for (int d : numbers) {
            sum += d;
        }
        return sum / numbers.length;
    }
}
