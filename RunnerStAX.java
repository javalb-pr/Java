package by.gsu.pms;

import by.gsu.pms.model.*;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static by.gsu.pms.Utils.FILE_PATH;
import static by.gsu.pms.model.XmlModel.*;

public class RunnerStAX {
    public static void main(String[] args) throws IOException {
        Utils.downloadXML();
        Channel channel = new Channel();
        Image image = new Image();
        AtomLink atomLink = new AtomLink();
        Item item = new Item();
        AtomAuthor atomAuthor = new AtomAuthor();
        Category category;
        Enclosure enclosure;
        Guid guid;
        List<MediaContent> mediaContentList = new ArrayList<>();
        MediaContent mediaContent;
        List<Item> itemList = new ArrayList<>();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        boolean isBeforeItems = false;
        boolean isImageBody = false;
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(FILE_PATH));
            while (reader.hasNext()){
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()){
                    StartElement startElement = xmlEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()){
                        case XML_TAG_CHANNEL: {
                            isBeforeItems = true;
                        }break;
                        case XML_TAG_TITLE:{
                            if (isImageBody) {
                                image.setTitle(reader.getElementText());
                            } else if (isBeforeItems) {
                                channel.setTitle(reader.getElementText());
                            }else {
                                item.setTitle(reader.getElementText());
                            }
                        }break;
                        case XML_TAG_LINK:{
                            if (isImageBody) {
                                image.setLink(reader.getElementText());
                            }else if (isBeforeItems) {
                                channel.setLink(reader.getElementText());
                            }else {
                                item.setLink(reader.getElementText());
                            }
                            if (startElement.getAttributeByName(new QName(XML_ATTR_HREF)) != null){
                                atomLink.setHref(startElement.getAttributeByName(new QName(XML_ATTR_HREF)).getValue());
                            }
                            if (startElement.getAttributeByName(new QName(XML_ATTR_REL)) != null){
                                atomLink.setRel(startElement.getAttributeByName(new QName(XML_ATTR_REL)).getValue());
                            }
                            if (startElement.getAttributeByName(new QName(XML_ATTR_TYPE)) != null){
                                atomLink.setType(startElement.getAttributeByName(new QName(XML_ATTR_TYPE)).getValue());
                            }
                        }break;
                        case XML_TAG_DESCRIPTION:{
                            if (isBeforeItems) {
                                channel.setDescription(reader.getElementText());
                            }else {
                                item.setDescription(reader.getElementText());
                            }
                        }break;
                        case XML_TAG_LANGUAGE:{
                            if (isBeforeItems) {
                                channel.setLanguage(reader.getElementText());
                            }
                        }break;
                        case XML_TAG_IMAGE:{
                            if (isBeforeItems) {
                                isImageBody = true;
                            }
                        }break;
                        case XML_TAG_URL:{
                            if (isImageBody) {
                                image.setUrl(reader.getElementText());
                            }
                        }break;
                        case XML_TAG_PUB_DATE:{
                            if (isBeforeItems) {
                                channel.setPubDate(reader.getElementText());
                            }else {
                                item.setPubDate(reader.getElementText());
                            }
                        }break;
                        case XML_TAG_LAST_BUILD_DATE:{
                            if (isBeforeItems){
                                channel.setLastBuildDate(reader.getElementText());
                            }
                        }break;
                        case XML_TAG_TTL:{
                            if (isBeforeItems){
                                channel.setTtl(Integer.parseInt(reader.getElementText()));
                            }
                        }break;
                        case XML_TAG_ITEM:{
                            mediaContentList = new ArrayList<>();
                            isBeforeItems = false;
                            item = new Item();
                        }
                        case XML_TAG_AUTHOR:{
                            atomAuthor = new AtomAuthor();
                        }break;
                        case XML_TAG_NAME:{
                            atomAuthor.setName(reader.getElementText());
                        }break;
                        case XML_TAG_URI:{
                            atomAuthor.setUri(reader.getElementText());
                        }break;
                        case XML_TAG_CATEGORY:{
                            category = new Category();
                            if (startElement.getAttributeByName(new QName(XML_ATTR_DOMAIN)) != null){
                                category.setDomain(startElement.getAttributeByName(
                                        new QName(XML_ATTR_DOMAIN)).getValue());
                            }
                            category.setName(reader.getElementText());
                            item.setCategory(category);
                        }break;
                        case XML_TAG_ENCLOSURE:{
                            enclosure = new Enclosure();
                            enclosure.setUrl(startElement.getAttributeByName(new QName(XML_TAG_URL)).getValue());
                            enclosure.setType(startElement.getAttributeByName(new QName(XML_ATTR_TYPE)).getValue());
                            enclosure.setLength(Integer.parseInt(
                                    startElement.getAttributeByName(new QName(XML_ATTR_LENGTH)).getValue()));
                            item.setEnclosure(enclosure);
                        }break;
                        case XML_TAG_GUIDE:{
                            guid = new Guid();
                            guid.setPermaLink(Boolean.parseBoolean(
                                    startElement.getAttributeByName(new QName(XML_ATTR_PERMAL_LINK)).getValue()
                            ));
                            guid.setLink(reader.getElementText());
                        }break;
                        case XML_TAG_CONTENT:{
                            mediaContent = new MediaContent();
                            mediaContent.setUrl(startElement.getAttributeByName(new QName(XML_TAG_URL)).getValue());
                            mediaContent.setType(startElement.getAttributeByName(new QName(XML_ATTR_TYPE)).getValue());
                            mediaContent.setMedium(startElement.getAttributeByName(new QName(XML_ATTR_MEDIUM)).getValue());
                            mediaContent.setHeight(Integer.parseInt(
                                    startElement.getAttributeByName(new QName(XML_ATTR_HEIGHT)).getValue()
                            ));
                            mediaContent.setWidth(Integer.parseInt(
                                    startElement.getAttributeByName(new QName(XML_ATTR_WIDTH)).getValue()
                            ));
                            mediaContent.setFileSize(Integer.parseInt(
                                    startElement.getAttributeByName(new QName(XML_ATTR_FILE_SIZE)).getValue()
                            ));
                            mediaContentList.add(mediaContent);
                        }
                    }
                }
                if (xmlEvent.isEndElement()){
                    EndElement endElement = xmlEvent.asEndElement();
                    switch (endElement.getName().getLocalPart()) {
                        case XML_TAG_CHANNEL: {
                            channel.setAtomLink(atomLink);
                            channel.setItems(itemList);
                            System.out.println(channel);
                        }break;
                        case XML_TAG_IMAGE: {
                            channel.setImage(image);
                            isImageBody = false;
                        }break;
                        case XML_TAG_ITEM:{
                            item.setMediaContentList(mediaContentList);
                            itemList.add(item);
                        }break;
                        case XML_TAG_AUTHOR:{
                            item.setAtomAuthor(atomAuthor);
                        }break;
                    }
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
