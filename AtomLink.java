package by.gsu.pms.model;

public class AtomLink {
    private String href;
    private String rel;
    private String type;

    public AtomLink(String href, String rel, String type) {
        this.href = href;
        this.rel = rel;
        this.type = type;
    }

    public AtomLink() {
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AtomLink{" +
                "href='" + href + '\'' +
                ", rel='" + rel + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
