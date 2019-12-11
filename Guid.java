package by.gsu.pms.model;

public class Guid {
    private boolean isPermaLink;
    private String link;

    public Guid() {
    }

    public Guid(boolean isPermaLink, String link) {
        this.isPermaLink = isPermaLink;
        this.link = link;
    }

    public boolean isPermaLink() {
        return isPermaLink;
    }

    public void setPermaLink(boolean permaLink) {
        isPermaLink = permaLink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Guid{" +
                "isPermaLink=" + isPermaLink +
                ", link='" + link + '\'' +
                '}';
    }
}
