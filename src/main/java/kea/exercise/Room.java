package kea.exercise;

public class Room {
    private boolean visited = false;
    private String name;
    private Room northRoom = null;
    private Room southRoom = null;
    private Room eastRoom = null;
    private Room westRoom = null;
    private String longDescription;
    private String shortDescriptio;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getShortDescriptio() {
        return shortDescriptio;
    }

    public void setShortDescriptio(String shortDescriptio) {
        this.shortDescriptio = shortDescriptio;
    }

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getNorthRoom() {
        return northRoom;
    }

    public void setNorthRoom(Room northRoom) {

        this.northRoom = northRoom;
        if (northRoom.getSouthRoom() == null) {
            northRoom.setSouthRoom(this);
        }
    }

    public Room getSouthRoom() {
        return southRoom;
    }

    public void setSouthRoom(Room southRoom) {
        this.southRoom = southRoom;
        if (southRoom.getNorthRoom() == null) {
            southRoom.setNorthRoom(this);
        }
    }

    public Room getEastRoom() {
        return eastRoom;
    }

    public void setEastRoom(Room eastRoom) {
        this.eastRoom = eastRoom;
        if (eastRoom.getWestRoom() == null) {
        eastRoom.setWestRoom(this);}
    }

    public Room getWestRoom() {
        return westRoom;
    }

    public void setWestRoom(Room westRoom) {
        this.westRoom = westRoom;
        if (westRoom.getEastRoom() == null) {
        westRoom.setEastRoom(this);}
    }
}
