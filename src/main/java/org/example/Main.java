package org.example; // Lub com.example.sevice - zależy jak nazwałeś pakiet przy tworzeniu projektu

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {


    public Main(ConferenceService conferenceService) {
        conferenceService.checkRoomAvailability("CRA", "2024-07-01", "2024-07-02");
        conferenceService.bookRoom("CRA", "2024-08-01", "2024-08-02", 201);
        conferenceService.bookRoom("CRA", "2024-07-01", "2024-07-02", 2024);
        conferenceService.bookRoom("CRA", "2024-08-02", "2024-08-01", 2024);


    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}