import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * The following sets of input data were reported as simply "didn't work" and we didn't get the expected output data, so
 * we just added them as empty test cases for now. Please figure out what's wrong and come up with minimal inputs that
 * still get the wrong output.
 */
public class Lesson8Test {
    @Test
    public void testAverage() {
        int[] numbers = {123, 2, 1, 7, 10, 5, 15, 4, 84, 108, 1, 1};
        double result = Lesson8.average(numbers);
    }

    @Test
    public void testIsPalindrome() {
        boolean result = Lesson8.isPalindrome("A man, a plan, a canal: Panama!");
    }

    @Test
    public void testDocumentInfo() throws IOException, SAXException, ParserConfigurationException {
        String xml = "<?xml version=\"1.0\"?>\n" +
                "<html lang=\"en\">\n" +
                "    <head>\n" +
                "        <meta charset=\"UTF-8\"/>\n" +
                "        <link href=\"base.css\" rel=\"stylesheet\"/>\n" +
                "        <link href=\"layout.css \" rel=\"stylesheet\"/>\n" +
                "        <link href=\"colors.css\" rel=\"stylesheet\"/>\n" +
                "        <meta name=\"description\" content=\"  At the Mountains of Madness by H. P. Lovecraft \"/>\n" +
                "        <link href=\"crossbrowser.css\" rel=\"stylesheet \"/>\n" +
                "        <title>At the Mountains of Madness</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>At the Mountains of Madness </h1>\n" +
                "        <p>I am forced into speech because men of science have refused to follow my advice without knowing why. It is altogether against my will that I tell my reasons for opposing this contemplated invasion of the antarctic—with its vast fossil hunt and its wholesale boring and melting of the ancient ice caps. And I am the more reluctant because my warning may be in vain.</p>\n" +
                "        <p>Doubt of the real facts, as I must reveal them, is inevitable; yet, if I suppressed what will seem extravagant and incredible, there would be nothing left. The hitherto withheld photographs, both ordinary and aerial, will count in my favor, for they are damnably vivid and graphic. Still, they will be doubted because of the great lengths to which clever fakery can be carried. The ink drawings, of course, will be jeered at as obvious impostures, notwithstanding a strangeness of technique which art experts ought to remark and puzzle over.</p>\n" +
                "        <p>In the end I must rely on the judgment and standing of the few scientific leaders who have, on the one hand, sufficient independence of thought to weigh my data on its own hideously convincing merits or in the light of certain primordial and highly baffling myth-cycles; and on the other hand, sufficient influence to deter the exploring world in general from any rash and over-ambitious program in the region of those mountains of madness. It is an unfortunate fact that relatively obscure men like myself and my associates, connected only with a small university, have little chance of making an impression where matters of a wildly bizarre or highly controversial nature are concerned.</p>\n" +
                "    </body>\n" +
                "</html>";
        DocumentInfo info = Lesson8.documentInfo(xml);
    }
}