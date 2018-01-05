package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;



public class TestCustom
{

    public static void main(String []a) throws FileNotFoundException, IOException, InvalidFormatException
    {

        CustomXWPFDocument document = new CustomXWPFDocument(new FileInputStream(new File("D:\\Picture\\Expected Screenshot\\retailportal\\test.docx")));
        FileOutputStream fos = new FileOutputStream(new File("D:\\Picture\\Expected Screenshot\\retailportal\\test.docx"));

        String blipId = document.addPictureData(new FileInputStream(new File("D:\\Picture\\Expected Screenshot\\retailportal\\bae_Storefron.jpg")), Document.PICTURE_TYPE_JPEG);

        System.out.println(document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG));
  
        //System.out.println(document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG));
        document.createPicture(blipId,document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG), 620, 380);


        document.write(fos);
        fos.flush();
        fos.close();

    }

}