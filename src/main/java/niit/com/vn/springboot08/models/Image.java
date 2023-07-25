package niit.com.vn.springboot08.models;

public class Image {
    int id;
    String path;

    public Image(int id, String path) {
        this.id = id;
        this.path = path;
    }

    public String getPath() {
        return "/uploads/"+path;
    }
}
