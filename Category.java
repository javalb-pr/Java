package by.gsu.pms.model;

public class Category {
    private String name;
    private String domain;

    public Category() {
    }

    public Category(String name, String domain) {
        this.name = name;
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }
}
