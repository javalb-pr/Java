package by.gsu.pms.model;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    private String title;
    private String link;
    private String description;
    private String language;
    private Image image;
    private String pubDate;
    private String lastBuildDate;
    private int ttl;
    private AtomLink atomLink;
    private List<Item> items;

    public Channel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "\ntitle='" + title + '\'' +
                ", \nlink='" + link + '\'' +
                ", \ndescription='" + description + '\'' +
                ", \nlanguage='" + language + '\'' +
                ", \nimage=" + image +
                ", \npubDate='" + pubDate + '\'' +
                ", \nlastBuildDate='" + lastBuildDate + '\'' +
                ", \nttl=" + ttl +
                ", \natomLink=" + atomLink +
                ", \nitems=" + items +
                '}';
    }

    public AtomLink getAtomLink() {
        return atomLink;
    }

    public void setAtomLink(AtomLink atomLink) {
        this.atomLink = atomLink;
    }

}
