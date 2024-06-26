package model;

import org.json.JSONException;
import org.json.JSONObject;

public class Model_Receive_Message {

    private int messageType;    // Kiểu tin nhắn text, emoji, file
    private int fromUserID;     // Gửi từ người dùng có ID là ...
    private String text;    // Nội dung tin nhắn
    private Model_Receive_Image dataImage;  //Các thông tin về ảnh 
    private Model_Receive_File dataFile;    // Các thông tin về file

    public Model_Receive_Message(int fromUserID, String text, int messageType) {
        this.messageType = messageType;
        this.fromUserID = fromUserID;
        this.text = text;
    }
    // Constructor nhận đối tượng JSON và chuyển nó thành thuộc tính của lớp
    public Model_Receive_Message(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
            // Lấy dữ liệu từ khóa
            messageType = obj.getInt("messageType");
            fromUserID = obj.getInt("fromUserID");
            text = obj.getString("text");
            if(!obj.isNull("dataImage")){
                dataImage = new Model_Receive_Image(obj.get("dataImage"));
            }
            if(!obj.isNull("dataFile")){
                dataFile = new Model_Receive_File(obj.get("dataFile"));
            }
        } catch (JSONException e) {
            System.err.println(e);
        }
    }

   // Tạo đối tượng JSON từ các thuộc tính của lớp
    public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            // Tạo các cặp khóa dữ liệu
            json.put("messageType", messageType);
            json.put("fromUserID", fromUserID);
            json.put("text", text);
            if(dataImage != null){
                json.put("dataImage", dataImage.toJsonOject());
            }
            if(dataFile != null){
                json.put("dataFile", dataFile.toJsonOject());
            }
            return json;
        } catch (JSONException e) {
            System.err.println(e);
            return null;
        }
    }

    public Model_Receive_File getDataFile() {
        return dataFile;
    }

    public void setDataFile(Model_Receive_File dataFile) {
        this.dataFile = dataFile;
    }
    
    public Model_Receive_Image getDataImage() {
        return dataImage;
    }

    public void setDataImage(Model_Receive_Image dataImage) {
        this.dataImage = dataImage;
    }
    
    public int getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public int getMessageType(){
        return messageType;
    }
    
    public void setMessageType(int messageType){
        this.messageType = messageType;
    }
}