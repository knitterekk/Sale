package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 1. Uruchamia cały kontekst Springa (jak prawdziwą aplikację)
class ConferenceServiceIntegrationTest {

    @Autowired // 2. Wstrzykujemy PRAWDZIWY serwis (z prawdziwymi listami w środku)
    private ConferenceService conferenceService;

    @Test
    void should_MakeReservation_InRealScenario() {
        // GIVEN
        // Wybieramy termin, który na pewno jest wolny (np. wrzesień)
        // Pamiętaj: w konstruktorach Storage masz już dodane jakieś dane "startowe".
        String start = "2024-09-01";
        String end = "2024-09-02";
        String roomCode = "CRA"; // Ta sala istnieje w RoomStorage (dodałeś ją w konstruktorze)

        // WHEN
        // Próbujemy zrobić rezerwację naprawdę
        boolean result = conferenceService.bookRoom(roomCode, start, end, 500);

        // THEN
        // Powinno się udać (true)
        assertTrue(result, "Rezerwacja powinna się udać w wolnym terminie");

        // BONUS CHECK:
        // Spróbujmy zarezerwować to samo jeszcze raz - teraz powinno się nie udać!
        // To potwierdzi, że ReservationStorage naprawdę zapamiętał pierwszą rezerwację.
        boolean resultAgain = conferenceService.bookRoom(roomCode, start, end, 501);
        assertFalse(resultAgain, "Druga rezerwacja tego samego terminu powinna się nie udać");
    }
}