package by.gsu.pms.model;

import java.util.List;

public class Item {
    private String title;
    private String link;
    private String description;
    private AtomAuthor atomAuthor;
    private Category category;
    private Enclosure enclosure;
    private Guid guid;
    private String pubDate;
    private List<MediaContent> mediaContentList;

    public Item() {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public Guid getGuid() {
        return guid;
    }

    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public AtomAuthor getAtomAuthor() {
        return atomAuthor;
    }

    public void setAtomAuthor(AtomAuthor atomAuthor) {
        this.atomAuthor = atomAuthor;
    }

    @Override
    public String toString() {
        return "Item{" +
                "\n\t\ttitle='" + title + '\'' +
                ", \n\t\tlink='" + link + '\'' +
                ", \n\t\tdescription='" + description + '\'' +
                ", \n\t\tatomAuthor=" + atomAuthor +
                ", \n\t\tcategory=" + category +
                ", \n\t\tenclosure=" + enclosure +
                ", \n\t\tguid=" + guid +
                ", \n\t\tpubDate='" + pubDate + '\'' +
                ", \n\t\tmediaContentList=" + mediaContentList +
                '}';
    }

    public List<MediaContent> getMediaContentList() {
        return mediaContentList;
    }

    public void setMediaContentList(List<MediaContent> mediaContentList) {
        this.mediaContentList = mediaContentList;
    }

}
