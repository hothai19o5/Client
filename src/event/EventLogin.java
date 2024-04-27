package event;

import model.Model_Login;
import model.Model_Register;

public interface EventLogin {

    public void login(Model_Login data);

    public void register(Model_Register data, EventMessage mes);

    public void goRegister();

    public void goLogin();
}
