package org.example;

public class Room {
    private int id;
    private String name;
    private int capacity;
    private String code;

    public Room(int id, String name, int capacity, String code) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.code = code;
    }

    public Room() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;

    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", code='" + code + '\'' +
                '}';
    }
}
