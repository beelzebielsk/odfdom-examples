import org.odftoolkit.odfdom.doc.OdfTextDocument;
import org.odftoolkit.odfdom.dom.element.office.OfficeTextElement;
import org.odftoolkit.odfdom.pkg.OdfFileDom;
import org.odftoolkit.odfdom.incubator.doc.text.OdfTextParagraph;
//import org.w3c.dom.Node;

/* NOTE: Dom manipulations are part of xerces, it seems, because
 * OdfFileDom extends DocumentImpl, which comes from xerces.
 */

/* The goal of this file is to figure out if I could add a paragraph
 * through dom manipulation. However, I'm having a hard time finding
 * references to the dom manipulation functionality. It looks like it
 * comes from apache xerxes
 */
class TestDOMManip {
    public static void main(String[] args) {
        OdfTextDocument doc;
        try {
            doc = OdfTextDocument.newTextDocument();
            OfficeTextElement officeText = doc.getContentRoot();
            OdfFileDom dom = doc.getContentDom();
            /* I'm still a little confused here, but it seems that you
             * have to specify the owning document in the paragraph's
             * constructor (dom), and then you have to choose a
             * specific node to add the new node to.
             *
             * NOTE: This will not be the 1st paragraph in the
             * document.
             */
            OdfTextParagraph para = new OdfTextParagraph(dom);
            para.addContent("content");
            officeText.appendChild(para);
            doc.save("TestDOMManip.odt");
        } catch (Exception e) {
            System.err.println("Unable to create file.");
            System.err.println(e.getMessage());
        }
    }
}
