package web.model;

public class User {
    private String userName;
    private String userStatus;
    private int userAge;

    public User() {
    }

    public User(String userName, String userStatus, int userAge) {
        this.userName = userName;
        this.userStatus = userStatus;
        this.userAge = userAge;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
