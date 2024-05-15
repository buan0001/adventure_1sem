package kea.exercise;

public class Item {
    private String shortName;
    private String longName;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public Item(){}
    public Item(String longName, String shortName) {
        this.shortName = shortName;
        this.longName = longName;
    }
}
