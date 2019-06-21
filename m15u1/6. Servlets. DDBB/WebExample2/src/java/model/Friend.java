package model;

public class Friend {

    private int friendID;
    private String categoryId;
    private String name;
    private String phone;
    private int age;

    public Friend(int friendID) {
        this.friendID = friendID;
    }

    public Friend(String phone) {
        this.phone = phone;
    }

    public Friend() {
    }

    public Friend(int friendID, String name) {
        this.friendID = friendID;
        this.name = name;
    }
    

    public Friend(int friendID, String categoryId, String name, String phone, int age) {
        this.friendID = friendID;
        this.categoryId = categoryId;
        this.name = name;
        this.phone = phone;
        this.age = age;
    }
    
    public Friend(String phone, String name, int age) {
        this.phone = phone;
        this.name = name;
        this.age = age;
    }

    public int getFriendID() {
        return friendID;
    }

    public void setFriendID(int friendID) {
        this.friendID = friendID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "<br />Friend{" + "phone=" + phone + ", name=" + name + ", age=" + age + '}';
    }
}
