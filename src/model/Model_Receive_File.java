package model;

import org.json.JSONException;
import org.json.JSONObject;

public class Model_Receive_File {
    private int fileID;
    
    public Model_Receive_File(Object json){
        JSONObject obj = (JSONObject) json;
        try {
            // Lấy dữ liệu từ khóa
            fileID = obj.getInt("fileID");
        } catch (JSONException e) {
            System.err.println(e);
            System.out.println("Error at Client Model_Receive_File Contructor");
        }
    }
    
    public JSONObject toJsonOject(){
        try {
            JSONObject json = new JSONObject();
            json.put("fileID", fileID);
            return json;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Error at Client Model_Receive_File toJsonOject");
            return null;
        }
    }

    public Model_Receive_File() {
    }

    public Model_Receive_File(int fileID) {
        this.fileID = fileID;
    }
    
    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }
    
}
