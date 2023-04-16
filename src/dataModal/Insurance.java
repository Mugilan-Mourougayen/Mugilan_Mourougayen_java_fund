package dataModal;

public class Insurance {
    private Integer id;
    private String name;

    public Insurance(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + id +
                ", name='" + name  +
                "}\n";
    }
}
