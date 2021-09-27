package com.example.mockito;

import happyHotel.*;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class throwingExceptions {
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
    void should_ThrowException_When_NoRoomAvailable() {
        //given
        BookingRequest bookingRequest = new BookingRequest("1",
                LocalDate.of(2021,9,10),
                LocalDate.of(2021,9,14), 2, false);
        when(this.roomServiceMock.findAvailableRoomId(bookingRequest))
                .thenThrow(BusinessException.class);
        //when
        //Executable implements imitation for code which may throw any type of exception or throwable
        Executable executable = () -> bookingService.makeBooking(bookingRequest);
        //then
        assertThrows(BusinessException.class, executable);
    }

}
