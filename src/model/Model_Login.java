package model;

import org.json.JSONException;
import org.json.JSONObject;

public class Model_Login {

    private String userName;
    private String password;

    public Model_Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Model_Login() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // Dùng định dạng json để truyền dữ liệu
    public JSONObject toJSONObject() {
        try {
            JSONObject obj = new JSONObject();
            // Tạo các cặp khóa - dữ liệu
            obj.put("userName", userName);
            obj.put("password", password);
            return obj;
        } catch (JSONException e) {
            return null;
        }
    }
}
