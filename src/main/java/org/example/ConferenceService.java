package org.example;

import org.springframework.stereotype.Component;

@Component
public class ConferenceService {
    private final ReservationStorage reservationStorage;
    private final RoomStorage roomStorage;

    public ConferenceService(ReservationStorage reservationStorage, RoomStorage roomStorage) {
        this.reservationStorage = reservationStorage;
        this.roomStorage = roomStorage;
    }

    public void checkRoomAvailability(String roomCode, String startDate, String endDate) {
        boolean isAvailable = true;
        for (Reservation reservation : reservationStorage.getAllReservations()) {
            if (reservation.getRoomCode().equalsIgnoreCase(roomCode)) {
                // Simple date overlap check (assuming dates are in "YYYY-MM-DD" format)
                if (!(endDate.compareTo(reservation.getStartDate()) < 0 || startDate.compareTo(reservation.getEndDate()) > 0)) {
                    isAvailable = false;
                    break;
                }
            }
        }
        if (isAvailable) {
            System.out.println("Room " + roomCode + " is available from " + startDate + " to " + endDate);
        } else {
            System.out.println("Room " + roomCode + " is NOT available from " + startDate + " to " + endDate);
        }


    }

    public boolean bookRoom(String roomCode, String startDate, String endDate, int employeedId) {
        if (roomStorage.searchCode(roomCode).isEmpty()) {
            System.out.println("Room code " + roomCode + " does not exist.");
            return false;
        }

        if (startDate.compareTo(endDate) >= 0) {
            System.out.println("Invalid date range: Start date must be before end date.");
            return false;
        }

        for (Reservation reservation : reservationStorage.getAllReservations()) {
            if (reservation.getRoomCode().equalsIgnoreCase(roomCode)) {
                // Simple date overlap check (assuming dates are in "YYYY-MM-DD" format)
                if (!(endDate.compareTo(reservation.getStartDate()) < 0 || startDate.compareTo(reservation.getEndDate()) > 0)) {
                    System.out.println("Cannot book room " + roomCode + " from " + startDate + " to " + endDate + " as it is already booked.");
                    return false;
                }
            }
        }
        Reservation newReservation = new Reservation(startDate, endDate, employeedId, roomCode);
        reservationStorage.addReservation(newReservation);
        System.out.println("Successfully booked room " + roomCode + " from " + startDate + " to " + endDate + " for employee ID " + employeedId);
        return true;
    }

}


