package event;

import model.Model_Register;

/*
    Đăng nhập, đăng kí
 */
public interface EventLogin {
    public void login();
    public void register(Model_Register data);
    public void goRegister();
    public void goLogin();
}
