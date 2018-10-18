import org.odftoolkit.odfdom.doc.OdfTextDocument;
import java.net.URI;

class Document {
    public static void main(String[] args) {
        OdfTextDocument outputOdt;
        try {
            outputOdt = OdfTextDocument.newTextDocument();
            outputOdt.addText("Hello World!");
            outputOdt.save("./empty-document.odt");
        } catch (Exception e) {
            System.err.println("Unable to create file.");
            System.err.println(e.getMessage());
        }
    }
}
