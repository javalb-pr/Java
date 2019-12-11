package by.gsu.pms;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Utils {
    private static final String URL_FOR_XML = "http://news.tut.by/rss/index.rss";
    public static final String FILE_PATH = "file.xml";

    public static void downloadXML() throws IOException {
        URL url = new URL(URL_FOR_XML);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(FILE_PATH);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

//    public static LocalDate xmlDateToLocalDate(String xmlDate){
//        return LocalDate.parse(xmlDate, DateTimeFormatter.ofPattern(XML_DATE_FORMAT));
//    }
}
