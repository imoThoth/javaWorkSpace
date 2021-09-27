package com.example.mockito;

import happyHotel.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatcher.*;


public class mockingVoidMethods {
    private BookingService bookingService;
    private PaymentService paymentServiceMock;
    private RoomService roomServiceMock;
    private BookingDAO bookingDAOMock;
    private MailSender mailSenderMock;

    @BeforeEach
    void setup() {

        this.bookingService = mock(BookingService.class);
        this.paymentServiceMock = mock(PaymentService.class);
        this.roomServiceMock = mock(RoomService.class);
        this.bookingDAOMock = mock(BookingDAO.class);
        this.mailSenderMock = mock(MailSender.class);

        this.bookingService = new BookingService(paymentServiceMock, roomServiceMock,
                bookingDAOMock, mailSenderMock);

    }

    @Test
    void should_ThrowException_WhenNoMailReady() {
        //given
        BookingRequest bookingRequest = new BookingRequest("1",
                LocalDate.of(2020,1,1),
                LocalDate.of(2020,1,5), 2, true);
        //Line 43 can be skipped as do nothing is the default behaviour for void method
        doThrow(new BusinessException()).when(mailSenderMock)
                .sendBookingConfirmation(any());
        //when
        Executable executable = () -> bookingService.makeBooking(bookingRequest);
        //then
        assertThrows(BusinessException.class, executable);
    }

    @Test
    void should_NotThrowException_WhenMailNotReady() {
        //given
        BookingRequest bookingRequest = new BookingRequest("1",
                LocalDate.of(2020,1,1),
                LocalDate.of(2020,1,5), 2, true);

        doThrow(new BusinessException()).when(mailSenderMock)
                .sendBookingConfirmation(any());
        //when
       bookingService.makeBooking(bookingRequest);
    }



}
