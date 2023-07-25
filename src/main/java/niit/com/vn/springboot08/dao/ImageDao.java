package niit.com.vn.springboot08.dao;

import niit.com.vn.springboot08.models.Image;

import java.util.ArrayList;

public class ImageDao extends DB {
    public void insert(String path) {
        try {
            this.connection.createStatement().executeUpdate("INSERT INTO images(path) VALUES ('" + path + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Image> getAll() {
        try {
            ArrayList<Image> images = new ArrayList<>();
            var resultSet = this.connection.createStatement().executeQuery("SELECT * FROM images");
            while (resultSet.next()) {
                images.add(new Image(resultSet.getInt("id"), resultSet.getString("path")));
            }
            return images;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
