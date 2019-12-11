package by.gsu.pms;

import by.gsu.pms.model.*;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.gsu.pms.Utils.FILE_PATH;
import static by.gsu.pms.model.XmlModel.*;

public class RunnerDOM {
    public static void main(String[] args) throws IOException {
        Channel channel = new Channel();
        Utils.downloadXML();
        File xmlFile = new File(FILE_PATH);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName(XML_TAG_CHANNEL);
            Element channelElement = (Element) nodeList.item(0);
            channel.setTitle(getTagValue(XML_TAG_TITLE, channelElement));
            channel.setLink(getTagValue(XML_TAG_LINK, channelElement));
            channel.setDescription(getTagValue(XML_TAG_DESCRIPTION, channelElement));
            channel.setLanguage(getTagValue(XML_TAG_LANGUAGE, channelElement));
            Element imageElement = (Element) channelElement.getElementsByTagName(XML_TAG_IMAGE).item(0);
            channel.setImage(new Image(
                    getTagValue(XML_TAG_URL, imageElement),
                    getTagValue(XML_TAG_TITLE, imageElement),
                    getTagValue(XML_TAG_LINK, imageElement)
            ));
            channel.setPubDate(getTagValue(XML_TAG_PUB_DATE, channelElement));
            channel.setLastBuildDate(getTagValue(XML_TAG_LAST_BUILD_DATE, channelElement));
            channel.setTtl(Integer.parseInt(getTagValue(XML_TAG_TTL, channelElement)));
            NamedNodeMap atomLinkAttrs = channelElement.getElementsByTagName(XML_ATOM_TAG_LINK).item(0).getAttributes();
            channel.setAtomLink(new AtomLink(
                    atomLinkAttrs.getNamedItem(XML_ATTR_HREF).getNodeValue(),
                    atomLinkAttrs.getNamedItem(XML_ATTR_REL).getNodeValue(),
                    atomLinkAttrs.getNamedItem(XML_ATTR_TYPE).getNodeValue()
            ));
            nodeList = document.getElementsByTagName(XML_TAG_ITEM);
            List<Item> items = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                items.add(parseItem(nodeList.item(i)));
            }
            channel.setItems(items);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println(channel);
    }

    private static Item parseItem(Node node){
        Item item = new Item();
        Element element = (Element) node;
        item.setTitle(getTagValue(XML_TAG_TITLE, element));
        item.setLink(getTagValue(XML_TAG_LINK, element));
        item.setDescription(getTagValue(XML_TAG_DESCRIPTION, element));
        Element authorElement = (Element) element.getElementsByTagName(XML_ATOM_TAG_AUTHOR).item(0);
        try {
            item.setAtomAuthor(new AtomAuthor(
                    getTagValue(XML_ATOM_TAG_NAME, authorElement),
                    getTagValue(XML_ATOM_TAG_URI, authorElement)
            ));
        }catch (NullPointerException ex){
            item.setAtomAuthor(new AtomAuthor(
                    "Not correct author",
                    "Uri was not found!"
            ));
        }
        item.setCategory(new Category(
                getTagValue(XML_TAG_CATEGORY, element),
                element.getElementsByTagName(XML_TAG_CATEGORY).item(0)
                        .getAttributes().item(0).getNodeValue()
        ));
        NamedNodeMap enclosureAttributes = element.getElementsByTagName(XML_TAG_ENCLOSURE).item(0).getAttributes();
        item.setEnclosure(new Enclosure(
                enclosureAttributes.item(2).getNodeValue(),
                enclosureAttributes.item(1).getNodeValue(),
                Integer.parseInt(enclosureAttributes.item(0).getNodeValue())
        ));
        item.setGuid(new Guid(
                Boolean.parseBoolean(element.getElementsByTagName(XML_TAG_GUIDE).item(0)
                        .getAttributes().item(0).getNodeValue()),
                getTagValue(XML_TAG_GUIDE, element)
        ));
        item.setPubDate(getTagValue(XML_TAG_PUB_DATE, element));
        List<MediaContent> mediaContentList = new ArrayList<>();
        NodeList mediaContentNodes = element.getElementsByTagName(XML_MEDIA_TAG_CONTENT);
        for (int i = 0; i < mediaContentNodes.getLength(); i++) {
            mediaContentList.add(parseMediaContent(mediaContentNodes.item(i)));
        }
        item.setMediaContentList(mediaContentList);
        return item;
    }

    private static MediaContent parseMediaContent(Node node){
        NamedNodeMap nodeAttributes = node.getAttributes();
        return new MediaContent(
                nodeAttributes.getNamedItem(XML_TAG_URL).getNodeValue(),
                nodeAttributes.getNamedItem(XML_ATTR_TYPE).getNodeValue(),
                nodeAttributes.getNamedItem(XML_ATTR_MEDIUM).getNodeValue(),
                Integer.parseInt(nodeAttributes.getNamedItem(XML_ATTR_HEIGHT).getNodeValue()),
                Integer.parseInt(nodeAttributes.getNamedItem(XML_ATTR_WIDTH).getNodeValue()),
                Integer.parseInt(nodeAttributes.getNamedItem(XML_ATTR_FILE_SIZE).getNodeValue())

        );
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
