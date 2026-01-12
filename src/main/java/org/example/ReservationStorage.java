package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationStorage {
    private List<Reservation> reservations;

    public ReservationStorage() {
        this.reservations = new ArrayList<>();

        reservations.add(new Reservation("2024-07-01", "2024-07-02", 101, "CRA"));
        reservations.add(new Reservation("2024-07-03", "2024-07-04", 102, "CRB"));
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }


}
