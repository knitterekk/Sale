package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomStorage {
    private List<Room> rooms;

    public RoomStorage() {
        this.rooms = new ArrayList<>();

        rooms.add(new Room(1, "Conference Room A", 10, "CRA"));
        rooms.add(new Room(2, "Conference Room B", 20, "CRB"));
        rooms.add(new Room(3, "Meeting Room 1", 5, "MR1"));
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Room> searchCode(String code) {
        List<Room> result = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getCode().equalsIgnoreCase(code)) {
                result.add(room);
            }
        }
        return result;
    }


}
