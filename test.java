import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class test {

    public static void main(String[] args) {
        String string = null;
        try {
        	try (FileInputStream input = new FileInputStream("samples/bus.pdf")){
	        	PDFParser pdfParser = new PDFParser(input);
	            pdfParser.parse(); 
	            try (PDDocument pdDocument = new PDDocument(pdfParser.getDocument())){
	            	 PDFTextStripper pdfTextStripper = new PDFLayoutTextStripper();
	            	 string = pdfTextStripper.getText(pdDocument);
	            }
            } 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(string);
    }

}