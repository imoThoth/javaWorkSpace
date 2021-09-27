package com.example.mockito;

import happyHotel.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatcher.*;

public class argumentMatchers {
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
    /*
    * Rules for Argument Matchers
    * -Use any() for objects and primitive specifics any() for all other types
    * -To mix any() matchers with exact value use eq(amount)
    * -For nullable Strings use any(), else use anyString()
    * */

    @Test
    void should_ThrowException_When_PaymentTooHigh() {
        //given
        BookingRequest bookingRequest = new BookingRequest("1",
                LocalDate.of(2021,9,10),
                LocalDate.of(2021,9,14), 2, true);
        //should throw exception for any booking
        //accepts parameters booking request and floating price
        when(this.paymentServiceMock.pay(any(BookingRequest.class), anyDouble()))
                .thenThrow(BusinessException.class);
        //when
        //Executable implements imitation for code which may throw any type of exception or throwable
        Executable executable = () -> bookingService.makeBooking(bookingRequest);
        //then
        assertThrows(BusinessException.class, executable);
    }

}
