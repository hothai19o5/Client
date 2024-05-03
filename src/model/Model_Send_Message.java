package model;
import app.MessageType;
import org.json.JSONException;
import org.json.JSONObject;

public class Model_Send_Message {

    private int fromUserID; // Người gửi
    private int toUserID;   // Người nhận
    private String text;    // Text
    private MessageType messageType;    // Kiểu tin nhắn

    public int getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
    }

    public int getToUserID() {
        return toUserID;
    }

    public void setToUserID(int toUserID) {
        this.toUserID = toUserID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public MessageType getMessageType(){
        return messageType;
    }
    
    public void setMessageType(MessageType messageType){
        this.messageType = messageType;
    }

    public Model_Send_Message(int fromUserID, int toUserID, String text, MessageType messageType) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.text = text;
        this.messageType = messageType;
    }

    public Model_Send_Message() {
    }
    // Dùng định dạng json để truyền dữ liệu
    public JSONObject toJsonObject() {
        try {
            // Tạo các cặp khóa - dữ liệu
            JSONObject json = new JSONObject();
            json.put("messageType", messageType.getValue());
            json.put("fromUserID", fromUserID);
            json.put("toUserID", toUserID);
            json.put("text", text);
            return json;
        } catch (JSONException e) {
            return null;
        }
    }
}

