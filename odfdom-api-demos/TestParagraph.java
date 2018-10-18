import org.odftoolkit.odfdom.doc.OdfTextDocument;
import org.odftoolkit.odfdom.incubator.doc.text.OdfTextParagraph;

class TestParagraph {
    public static void main(String[] args) {
        OdfTextDocument doc;
        try {
            doc = OdfTextDocument.newTextDocument();
            OdfTextParagraph para1 = doc.newParagraph();
            para1.addContent("content");
            OdfTextParagraph para2 = doc.newParagraph();
            para2.addContent("linebreak\n");
            /* The difference between the two methods seems to be that
             * the whitespace is handled specially. I'm not sure if it
             * accounts for whitespace by adding it in whereas the
             * other doesn't, or by coalescing whitespace into
             * something convenient, like a series of spaces into one
             * space.
             */
            para2.addContentWhitespace("linebreak\nafter");
            doc.save("TestParagraph.odt");
        } catch (Exception e) {
            System.err.println("Unable to create file.");
            System.err.println(e.getMessage());
        }
    }
}
