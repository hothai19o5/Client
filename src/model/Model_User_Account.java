package model;

import org.json.JSONObject;

public class Model_User_Account {
    private String userName;
    private int userID;
    private String gender;
    private String image;
    private boolean status;
    // Dùng định dạng json để truyền dữ liệu
    public Model_User_Account(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
            // Lấy dữ liệu từ khóa 
            this.userID = obj.getInt("userID");
            this.userName = obj.getString("userName");
            this.gender = obj.getString("gender");
            this.image = obj.getString("image");
            this.status = obj.getBoolean("status");
        } catch (Exception e) {
        }
    }

    public Model_User_Account(String userName, int userID, String gender, String image, boolean status) {
        this.userName = userName;
        this.userID = userID;
        this.gender = gender;
        this.image = image;
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
