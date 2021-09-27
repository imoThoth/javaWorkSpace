package com.example.mockito;

import happyHotel.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

public class returnCustomValue {

    private BookingService bookingService;
    private PaymentService paymentServiceMock;
    private RoomService roomServiceMock;
    private BookingDAO bookingDAOMock;
    private MailSender mailSenderMock;

    @BeforeEach
    void setup() {

        this.paymentServiceMock = mock(PaymentService.class);
        this.roomServiceMock = mock(RoomService.class);
        this.bookingDAOMock = mock(BookingDAO.class);
        this.mailSenderMock = mock(MailSender.class);

        this.bookingService = new BookingService(paymentServiceMock, roomServiceMock,
                bookingDAOMock, mailSenderMock);

    }

    @Test
    void should_CountAvaiablePlaces_When_OneRoomAvaiable() {
        //given
        //Collections.singleton returns a list containing only specified objects
        when(this.roomServiceMock.getAvailableRooms())
                .thenReturn(Collections.singletonList(new Room("Room 1", 2)));
        int expected = 2;
        //when
        int actual = bookingService.getAvailablePlaceCount();
        //then
        assertEquals(expected,actual);
    }

    @Test
    void should_CountAvailablePlaces_When_MultpleRoomsAvailable() {
        //given
        List<Room> rooms = Arrays.asList(new Room("Room 1", 2),
                new Room("Room 2", 5));
        when(this.roomServiceMock.getAvailableRooms())
                .thenReturn(rooms);
        int expectedCapacity = 7;
        //when
        int actualCapacity = bookingService.getAvailablePlaceCount();
        //then
        assertEquals(expectedCapacity, actualCapacity);
    }

    @Test
    void should_CountAvailablePlaces_When_CalledMultipledTimes(){
        //given
        when(this.roomServiceMock.getAvailableRooms())
                .thenReturn(Collections.singletonList(new Room("Room 1", 12)))
                .thenReturn(Collections.emptyList());
        //when
        int expectedFirstCall = 12;
        int expectedSecondCall = 0;

        int actualFirstcall = bookingService.getAvailablePlaceCount();
        int actualSecondCall = bookingService.getAvailablePlaceCount();
        //then
        assertAll(
                () -> assertEquals(expectedFirstCall, actualFirstcall),
                () -> assertEquals(expectedSecondCall, actualSecondCall)
        );
    }

}
//Mockito uses nice mocks

