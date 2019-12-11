package by.gsu.pms.model;

public class MediaContent {
    private String url;
    private String type;
    private String medium;
    private int height;
    private int width;
    private int fileSize;

    public MediaContent() {
    }

    public MediaContent(String url, String type, String medium, int height, int width, int fileSize) {
        this.url = url;
        this.type = type;
        this.medium = medium;
        this.height = height;
        this.width = width;
        this.fileSize = fileSize;
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

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "MediaContent{" +
                "\n\t\t\t\turl='" + url + '\'' +
                ", \n\t\t\t\ttype='" + type + '\'' +
                ", \n\t\t\t\tmedium='" + medium + '\'' +
                ", \n\t\t\t\theight=" + height +
                ", \n\t\t\t\twidth=" + width +
                ", \n\t\t\t\tfileSize=" + fileSize +
                '}';
    }
}
