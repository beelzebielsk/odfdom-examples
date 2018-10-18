import org.odftoolkit.odfdom.doc.OdfTextDocument;
import org.odftoolkit.odfdom.dom.element.office.OfficeTextElement;
import org.odftoolkit.odfdom.pkg.OdfFileDom;
import org.odftoolkit.odfdom.incubator.doc.text.OdfTextParagraph;
import org.odftoolkit.odfdom.incubator.doc.text.OdfTextList;

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

class TestList {
    public static void main(String[] args) {
        OdfTextDocument doc;
        try {
            doc = OdfTextDocument.newTextDocument();
            OdfFileDom dom = doc.getContentDom();
            OfficeTextElement officeText = doc.getContentRoot();
            /* It seems that using the dom here specifies the parent
             * of the paragraph. The paragraph will become a child of
             * the root element of dom... I think.
             */
            OdfTextList list = new OdfTextList(dom, new String[] {
                    ">fuck",
                    ">you",
                    ">>youuuuuu",
                    ">so hard",
                    ">>>boiiiii",
                }, '>', "");
            officeText.appendChild(list);
            NodeList kids = list.getChildNodes();
            System.out.println(kids.getLength());
            System.out.println(list.toString());
            doc.save("TestList.odt");
        } catch (Exception e) {
            System.err.println("Unable to create file.");
            System.err.println(e.getMessage());
        }
    }
    public static void traverseNodes(NodeList l) {
        for (int i = 0; i < l.getLength(); i++) {
            Node item = l.item(i);
            System.out.println(item.getNodeName());
            if (item.hasChildNodes()) {
                traverseNodes(item.getChildNodes());
            }
        }
    }
}

