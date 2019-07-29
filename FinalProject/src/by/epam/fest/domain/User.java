package by.epam.fest.domain;

public class User extends Entity {

    private UserInfo userInfo;
    private String login;
    private String password;
    private Role role;
    private String avatar;

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setAvatar(String avatar){ this.avatar=avatar;}

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getAvatar(){ return avatar;}
}
