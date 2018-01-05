package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class MSWordDemo {

	
	 public static void main(String[] args) throws IOException, InvalidFormatException 
	    {
	        XWPFDocument docx = new XWPFDocument();
	        XWPFParagraph par = docx.createParagraph();
	        XWPFRun run = par.createRun();
	        run.setText("Hello, World. This is my first java generated docx-file. Have fun.");
	        run.setFontSize(13);
	        InputStream pic = new FileInputStream("D:\\Picture\\Expected Screenshot\\retailportal\\1.jpeg");
	        //byte [] picbytes = IOUtils.toByteArray(pic);
	        //run.addPicture(picbytes, Document.PICTURE_TYPE_JPEG);
	        run.addPicture(pic, Document.PICTURE_TYPE_JPEG, "0", 400, 400);
	        FileOutputStream out = new FileOutputStream("D:\\Picture\\Expected Screenshot\\retailportal\\ayaz.doc"); 
	        docx.write(out); 
	        out.close(); 
	        pic.close();
	    }
}
