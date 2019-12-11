package by.gsu.pms.model;

public class Enclosure {
    private String url;
    private String type;
    private int length;

    public Enclosure() {
    }

    public Enclosure(String url, String type, int length) {
        this.url = url;
        this.type = type;
        this.length = length;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Enclosure{" +
                "url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", length=" + length +
                '}';
    }
}
