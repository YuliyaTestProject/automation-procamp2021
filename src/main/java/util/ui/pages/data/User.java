package util.ui.pages.data;

import util.ui.properties.PropertiesUtil;

public class User {
    private String login;
    private String password;

    public User() {
        PropertiesUtil propertiesUtil = PropertiesUtil.getInstance();
        login = propertiesUtil.get("credentials.properties", "login");
        password = propertiesUtil.get("credentials.properties", "password");
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
