import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.odfdom.pkg.OdfFileDom;
import org.odftoolkit.simple.text.Paragraph;
import org.odftoolkit.simple.text.list.List;
import org.odftoolkit.simple.text.list.ListItem;

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
// Not necessary for this file. Testing purposes only.
import org.odftoolkit.odfdom.pkg.OdfElement;
import org.odftoolkit.odfdom.dom.attribute.fo.FoMarginLeftAttribute;
// For searching an OdfElement for a contained paragraph.
import org.odftoolkit.odfdom.incubator.doc.text.OdfTextParagraph;

class TestList {
    public static void main(String[] args) {
        TextDocument doc;
        try {
            /* getListContainerElement returns the root of the
             * container.
             */
            doc = TextDocument.newTextDocument();
            OdfFileDom dom = doc.getContentDom();
            OdfElement officeText = doc.getContentRoot();
            //List l = doc.addList();
            List list = new List(doc);
            list.addItem("Fuck.");
            ListItem li = list.addItem("You.");
            OdfElement Odfli = li.getOdfElement();
            /* The actual document editor seems to create a new style
             * and set the style on the containing paragraph in order
             * to get the indent.
             *
             * The .class is necessary to treat a class as a value,
             * and findFirstChildNode uses classes as values to get a
             * node type. findFirstChildNode is basically
             * getElementByTagName.
             */
            OdfElement para = Odfli.findFirstChildNode(OdfTextParagraph.class, Odfli);
            FoMarginLeftAttribute leftIndent = new FoMarginLeftAttribute(dom);
            leftIndent.setValue("1in");
            para.setOdfAttribute(leftIndent);
            //Odfli.setOdfAttributeValue(FoMarginLeftAttribute.getOdfName(), "1in");
            //officeText.appendChild(list);
            //NodeList kids = list.getChildNodes();
            //System.out.println(kids.getLength());
            //System.out.println(list.toString());
            doc.save("TestList.odt");
        } catch (Exception e) {
            System.err.println("Unable to create file.");
            System.err.println(e.getMessage());
        }
    }
}

