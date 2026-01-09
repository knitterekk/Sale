package org.example;

public class Reservation {
    private String startDate;
    private String endDate;
    private int employeeId;
    private String roomCode;

    public Reservation(String startDate, String endDate, int employeeId, String roomCode) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeId = employeeId;
        this.roomCode = roomCode;
    }

    public Reservation() {
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", employeeId=" + employeeId +
                ", roomCode='" + roomCode + '\'' +
                '}';
    }
}
