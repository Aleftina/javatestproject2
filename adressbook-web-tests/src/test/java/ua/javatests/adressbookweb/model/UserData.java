package ua.javatests.adressbookweb.model;

public class UserData {
    private int id = Integer.MAX_VALUE;
    private String lastName;
    private String name;
    private String address;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String allPhones;
    private String email;
    private String group;

    public String getAllPhones() {
        return allPhones;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public UserData withId(int id) {
        this.id = id;
        return this;
    }

    public UserData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserData withName(String name) {
        this.name = name;
        return this;
    }

    public UserData withAddress(String address) {
        this.address = address;
        return this;
    }

    public UserData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public UserData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public UserData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public UserData withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserData withGroup(String group) {
        this.group = group;
        return this;
    }

    public UserData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (id != userData.id) return false;
        if (lastName != null ? !lastName.equals(userData.lastName) : userData.lastName != null) return false;
        return name != null ? name.equals(userData.name) : userData.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

}