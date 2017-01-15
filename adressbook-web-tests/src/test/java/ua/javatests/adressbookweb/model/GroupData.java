package ua.javatests.adressbookweb.model;

public class GroupData {
    private int id = Integer.MAX_VALUE;;
    private  String groupName;
    private  String header;
    private  String footer;

//    public GroupData(String groupName, String header, String footer) {
//        this.id = Integer.MAX_VALUE;
//        this.groupName = groupName;
//        this.header = header;
//        this.footer = footer;
//    }
//
//    public GroupData(int id, String groupName, String header, String footer) {
//        this.id = id;
//        this.groupName = groupName;
//        this.header = header;
//        this.footer = footer;
//    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    public GroupData withGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        return groupName != null ? groupName.equals(groupData.groupName) : groupData.groupName == null;

    }

    @Override
    public int hashCode() {
        return groupName != null ? groupName.hashCode() : 0;
    }

}
