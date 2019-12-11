package by.gsu.pms.model;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static by.gsu.pms.model.XmlModel.*;

public class ChannelHandler extends DefaultHandler {
    private Channel channel;
    private Image image;
    private Item item;
    private AtomAuthor atomAuthor;
    private Category category;
    private Enclosure enclosure;
    private Guid guid;
    List<MediaContent> mediaContentList;
    List<Item> items = new ArrayList<>();
    private boolean channelTagsFlag = true;
    private boolean channelTitleFlag = false;
    private boolean channelLinkFlag = false;
    private boolean channelDescriptionFlag = false;
    private boolean channelLanguageFlag = false;
    private boolean imageTagFlag = false;
    private boolean imageUrlFlag = false;
    private boolean imageTitleFlag = false;
    private boolean imageLinkFlag = false;
    private boolean channelPubDateFlag = false;
    private boolean channelLastBuildDateFlag = false;
    private boolean channelTtlFlag = false;
    private boolean itemTitleFlag = false;
    private boolean itemLinkFlag = false;
    private boolean itemDescriptionFlag = false;
    private boolean atomAuthorNameFlag = false;
    private boolean atomAuthorUriFlag = false;
    private boolean itemCategoryFlag = false;
    private boolean itemGuidFlag = false;
    private boolean itemPubDateFlag = false;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(XML_TAG_CHANNEL)){
            channel = new Channel();
        }
        if (channelTagsFlag){
            if (qName.equals(XML_TAG_TITLE)){
                channelTitleFlag = true;
            }
            if (qName.equals(XML_TAG_LINK)){
                channelLinkFlag = true;
            }
            if (qName.equals(XML_TAG_DESCRIPTION)){
                channelDescriptionFlag = true;
            }
            if (qName.equals(XML_TAG_LANGUAGE)){
                channelLanguageFlag = true;
            }
            if (qName.equals(XML_TAG_IMAGE)){
                image = new Image();
                imageTagFlag = true;
            }
            if (imageTagFlag) {
                if (qName.equals(XML_TAG_URL)){
                    imageUrlFlag = true;
                }
                if (qName.equals(XML_TAG_TITLE)){
                    imageTitleFlag = true;
                }
                if (qName.equals(XML_TAG_LINK)){
                    imageLinkFlag = true;
                }
            }
            if (qName.equals(XML_TAG_PUB_DATE)){
                channelPubDateFlag = true;
            }
            if (qName.equals(XML_TAG_LAST_BUILD_DATE)){
                channelLastBuildDateFlag = true;
            }
            if (qName.equals(XML_TAG_TTL)){
                channelTtlFlag = true;
            }
            if (qName.equals(XML_ATOM_TAG_LINK)){
                channel.setAtomLink(new AtomLink(
                        attributes.getValue(XML_ATTR_HREF),
                        attributes.getValue(XML_ATTR_REL),
                        attributes.getValue(XML_ATTR_TYPE)
                ));
            }
        }
        if (qName.equals(XML_TAG_ITEM)){
            mediaContentList = new ArrayList<>();
        }
        if (qName.equals(XML_TAG_TITLE)){
            item = new Item();
            itemTitleFlag = true;
        }
        if (qName.equals(XML_TAG_LINK)){
            itemLinkFlag = true;
        }
        if (qName.equals(XML_TAG_DESCRIPTION)){
            itemDescriptionFlag = true;
        }
        if (qName.equals(XML_ATOM_TAG_AUTHOR)){
            atomAuthor = new AtomAuthor();
        }
        if (qName.equals(XML_ATOM_TAG_NAME)){
            atomAuthorNameFlag = true;
        }
        if (qName.equals(XML_ATOM_TAG_URI)){
            atomAuthorUriFlag = true;
        }
        if (qName.equals(XML_TAG_CATEGORY)){
            category = new Category();
            category.setDomain(attributes.getValue(XML_ATTR_DOMAIN));
            itemCategoryFlag = true;
        }
        if (qName.equals(XML_TAG_ENCLOSURE)){
            enclosure = new Enclosure();
            enclosure.setUrl(attributes.getValue(XML_TAG_URL));
            enclosure.setType(attributes.getValue(XML_ATTR_TYPE));
            enclosure.setLength(Integer.parseInt(attributes.getValue(XML_ATTR_LENGTH)));
            item.setEnclosure(enclosure);
        }
        if (qName.equals(XML_TAG_GUIDE)){
            guid = new Guid();
            guid.setPermaLink(Boolean.parseBoolean(attributes.getValue(XML_ATTR_PERMAL_LINK)));
            itemGuidFlag = true;
        }
        if (qName.equals(XML_TAG_PUB_DATE)){
            itemPubDateFlag = true;
        }
        if (qName.equals(XML_MEDIA_TAG_CONTENT)){
            mediaContentList.add(new MediaContent(
               attributes.getValue(XML_TAG_URL),
               attributes.getValue(XML_ATTR_TYPE),
               attributes.getValue(XML_ATTR_MEDIUM),
               Integer.parseInt(attributes.getValue(XML_ATTR_HEIGHT)),
               Integer.parseInt(attributes.getValue(XML_ATTR_WIDTH)),
               Integer.parseInt(attributes.getValue(XML_ATTR_FILE_SIZE))
            ));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(XML_TAG_CHANNEL)){
            channel.setItems(items);
            System.out.println(channel);
        }
        if (qName.equals(XML_TAG_ITEM)){
            item.setMediaContentList(mediaContentList);
            items.add(item);
        }
        if (qName.equals(XML_ATOM_TAG_LINK)){
            channelTagsFlag = false;
        }
        if (qName.equals(XML_TAG_IMAGE)){
            channel.setImage(image);
            imageTagFlag = false;
        }
        if (qName.equals(XML_TAG_DESCRIPTION)){
            itemDescriptionFlag = false;
        }
        if (qName.equals(XML_ATOM_TAG_AUTHOR)){
            item.setAtomAuthor(atomAuthor);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        if (channelTitleFlag) {
            channel.setTitle(value);
            channelTitleFlag = false;
        }
        if (channelLinkFlag) {
            channel.setLink(value);
            channelLinkFlag = false;
        }
        if (channelDescriptionFlag) {
            channel.setDescription(value);
            channelDescriptionFlag = false;
        }
        if (channelLanguageFlag) {
            channel.setLanguage(value);
            channelLanguageFlag = false;
        }
        if (imageUrlFlag){
            image.setUrl(value);
            imageUrlFlag = false;
        }
        if (imageTitleFlag){
            image.setTitle(value);
            imageTitleFlag = false;
        }
        if (imageLinkFlag){
            image.setLink(value);
            imageLinkFlag = false;
        }
        if (channelPubDateFlag){
            channel.setPubDate(value);
            channelPubDateFlag = false;
        }
        if (channelLastBuildDateFlag){
            channel.setLastBuildDate(value);
            channelLastBuildDateFlag = false;
        }
        if (channelTtlFlag){
            channel.setTtl(Integer.parseInt(value));
            channelTtlFlag = false;
        }
        if (itemTitleFlag){
            item.setTitle(value);
            itemTitleFlag = false;
        }
        if (itemLinkFlag){
            item.setLink(value);
            itemLinkFlag = false;
        }
        if (itemDescriptionFlag){
            String pastValue = item.getDescription();
            if (pastValue != null){
                item.setDescription(pastValue.concat(value));
            } else {
                item.setDescription(value);
            }
        }
        if (atomAuthorNameFlag){
            atomAuthor.setName(value);
            atomAuthorNameFlag = false;
        }
        if (atomAuthorUriFlag){
            atomAuthor.setUri(value);
            atomAuthorUriFlag = false;
        }
        if (itemCategoryFlag){
            category.setName(value);
            item.setCategory(category);
            itemCategoryFlag = false;
        }
        if (itemGuidFlag){
            guid.setLink(value);
            item.setGuid(guid);
            itemGuidFlag = false;
        }
        if (itemPubDateFlag){
            item.setPubDate(value);
            itemPubDateFlag = false;
        }
    }

    public Channel getChannel() {
        return channel;
    }
}
