package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // 1. Uruchamiamy silnik Mockito
class ConferenceServiceTest {

    @Mock // 2. Tworzymy atrapę magazynu sal
    private RoomStorage roomStorage;

    @Mock // 3. Tworzymy atrapę magazynu rezerwacji
    private ReservationStorage reservationStorage;

    @InjectMocks // 4. Wstrzykujemy atrapy do testowanego serwisu
    private ConferenceService conferenceService;

    @Test
    void should_BookRoom_When_RoomExistsAndIsFree() {
        // GIVEN - Warunki początkowe
        String roomCode = "CRA";
        // Uczymy atrapę: jak zapytają o salę "CRA", zwróć listę z jedną salą
        Room mockRoom = new Room(1, "Test Room", 10, roomCode);
        when(roomStorage.searchCode(roomCode)).thenReturn(List.of(mockRoom));

        // Uczymy atrapę: jak zapytają o rezerwacje, zwróć pustą listę (brak konfliktów)
        when(reservationStorage.getAllReservations()).thenReturn(Collections.emptyList());

        // WHEN - Akcja
        boolean result = conferenceService.bookRoom(roomCode, "2024-01-01", "2024-01-02", 101);

        // THEN - Sprawdzenie
        assertTrue(result, "Rezerwacja powinna się udać, gdy sala jest wolna");
    }

    @Test
    void should_NotBookRoom_When_RoomDoesNotExist() {
        // GIVEN
        String roomCode = "GHOST"; // Kod sali, która nie istnieje

        // Uczymy atrapę: jak zapytają o "GHOST", zwróć pustą listę
        when(roomStorage.searchCode(roomCode)).thenReturn(Collections.emptyList());

        // WHEN
        boolean result = conferenceService.bookRoom(roomCode, "2024-01-01", "2024-01-02", 999);

        // THEN
        assertFalse(result, "Rezerwacja nie powinna się udać dla nieistniejącej sali");
    }


}