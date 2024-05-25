package model;

import org.json.JSONException;
import org.json.JSONObject;

public class Model_Receive_Image {
    private int fileID;
    private String image;
    private int height;
    private int width;
    
    public Model_Receive_Image(Object json){
        JSONObject obj = (JSONObject) json;
        try {
            // Lấy dữ liệu từ khóa
            fileID = obj.getInt("fileID");
            height = obj.getInt("height");
            width = obj.getInt("width");
            image = obj.getString("image");
        } catch (JSONException e) {
            System.err.println(e);
        }
    }
    
    public JSONObject toJsonOject(){
        try {
            JSONObject json = new JSONObject();
            json.put("fileID", fileID);
            json.put("image", image);
            json.put("height", height);
            json.put("width", width);
            return json;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public Model_Receive_Image() {
    }
    
    public Model_Receive_Image(int fileID, String image, int height, int width) {
        this.fileID = fileID;
        this.image = image;
        this.height = height;
        this.width = width;
    }

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
    
}
