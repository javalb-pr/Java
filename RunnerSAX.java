package by.gsu.pms;

import by.gsu.pms.model.ChannelHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

import static by.gsu.pms.Utils.FILE_PATH;

public class RunnerSAX {
    public static void main(String[] args) {
        try {
            Utils.downloadXML();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            ChannelHandler channelHandler = new ChannelHandler();
            saxParser.parse(new File(FILE_PATH), channelHandler);
            //System.out.println(channelHandler.getChannel());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
